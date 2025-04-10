package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.KorpaDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.UtisakDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Korpa;

public class KorpaDAOImpl implements KorpaDAO {


	// Metoda za izračunavanje ukupnog iznosa korpe
	private double izracunajUkupanIznos(Connection conn, int idKorpe) throws SQLException {
	    String query = """
	        SELECT SUM(a.cena) as ukupan_iznos
	        FROM sadrži s
	        JOIN Artikal a ON s.id_artikla = a.id_artikla
	        WHERE s.id_korpe = ?
	    """;
	    
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setInt(1, idKorpe);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return rs.getDouble("ukupan_iznos");
	        }
	        return 0.0;
	    }
	}


	// Metoda za dobijanje sledećeg slobodnog ID-a za bilo koju tabelu
	private int getNextId(String tabela, String kolona) throws SQLException {
	    String query = "SELECT NVL(MAX(" + kolona + "), 0) + 1 AS next_id FROM " + tabela;
	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        if (rs.next()) {
	            return rs.getInt("next_id");
	        }
	        return 1; // Defaultni ID ako tabela nema nijedan unos
	    }
	}

	@Override
	public void kreirajKupovinuSaRacunomIUtiskom(int idKupca, List<Integer> artikliIds, 
	                                            String nacinPlacanja, UtisakDTO utisak) throws SQLException {
	    Connection connection = null;

	    try {
	        connection = ConnectionUtil_HikariCP.getConnection();
	        connection.setAutoCommit(false);

	        // 1. Postavimo NULL samo za id_korpe u računu
	        String updateRacunSQL = """
	            UPDATE Racun 
	            SET id_korpe = NULL 
	            WHERE id_kupca = ? AND id_korpe IN (SELECT id_korpe FROM Korpa WHERE id_kupca = ?)
	        """;
	        try (PreparedStatement updateRacunStmt = connection.prepareStatement(updateRacunSQL)) {
	            updateRacunStmt.setInt(1, idKupca);
	            updateRacunStmt.setInt(2, idKupca);
	            updateRacunStmt.executeUpdate();
	        }

	        // 2. Brisanje stare korpe i njenog sadržaja
	        String deleteSadrziSQL = "DELETE FROM sadrži WHERE id_kupca = ?";
	        String deleteKorpaSQL = "DELETE FROM Korpa WHERE id_kupca = ?";
	        
	        try (PreparedStatement deleteSadrziStmt = connection.prepareStatement(deleteSadrziSQL);
	             PreparedStatement deleteKorpaStmt = connection.prepareStatement(deleteKorpaSQL)) {
	            
	            deleteSadrziStmt.setInt(1, idKupca);
	            deleteSadrziStmt.executeUpdate();
	            
	            deleteKorpaStmt.setInt(1, idKupca);
	            deleteKorpaStmt.executeUpdate();
	        }

	        // 3. Kreiranje nove korpe
	        int idKorpe = getNextId("Korpa", "id_korpe");
	        String korpaSQL = "INSERT INTO Korpa (id_korpe, datum_kreiranja, status_korpe, id_kupca) VALUES (?, SYSDATE, 'Zatvorena', ?)";
	        try (PreparedStatement korpaStmt = connection.prepareStatement(korpaSQL)) {
	            korpaStmt.setInt(1, idKorpe);
	            korpaStmt.setInt(2, idKupca);
	            korpaStmt.executeUpdate();
	        }

	        // 4. Dodavanje artikala u korpu
	        String sadrziSQL = "INSERT INTO sadrži (id_artikla, id_korpe, id_kupca) VALUES (?, ?, ?)";
	        try (PreparedStatement sadrziStmt = connection.prepareStatement(sadrziSQL)) {
	            for (Integer artikalId : artikliIds) {
	                sadrziStmt.setInt(1, artikalId);
	                sadrziStmt.setInt(2, idKorpe);
	                sadrziStmt.setInt(3, idKupca);
	                sadrziStmt.executeUpdate();
	            }
	        }

	        // 5. Kreiranje računa
	        int idRacuna = getNextId("Racun", "id_racuna");
	        double ukupanIznos = izracunajUkupanIznos(connection, idKorpe);
	        String racunSQL = """
	            INSERT INTO Racun (id_racuna, datum_izdavanja, ukupan_iznos, nacin_placanja, id_korpe, id_kupca)
	            VALUES (?, SYSDATE, ?, ?, ?, ?)
	        """;
	        try (PreparedStatement racunStmt = connection.prepareStatement(racunSQL)) {
	            racunStmt.setInt(1, idRacuna);
	            racunStmt.setDouble(2, ukupanIznos);
	            racunStmt.setString(3, nacinPlacanja);
	            racunStmt.setInt(4, idKorpe);
	            racunStmt.setInt(5, idKupca);
	            racunStmt.executeUpdate();
	        }
	        
	        // 6. Smanjenje količine na stanju za svaki artikal
	        String updateKolNaStSQL = "UPDATE Artikal SET kol_na_st = kol_na_st - 1 WHERE id_artikla = ?";
	        try (PreparedStatement updateKolNaStStmt = connection.prepareStatement(updateKolNaStSQL)) {
	            for (Integer artikalId : artikliIds) {
	                updateKolNaStStmt.setInt(1, artikalId);
	                updateKolNaStStmt.executeUpdate();
	            }
	        }

	        // 7. Kreiranje utiska
	        int idUtiska = getNextId("Utisak", "id_utiska");
	        String utisakSQL = """
	            INSERT INTO Utisak (id_utiska, ocena, komentar, datum_utiska, id_kupca)
	            VALUES (?, ?, ?, SYSDATE, ?)
	        """;
	        try (PreparedStatement utisakStmt = connection.prepareStatement(utisakSQL)) {
	            utisakStmt.setInt(1, idUtiska);
	            utisakStmt.setDouble(2, utisak.getOcena());
	            utisakStmt.setString(3, utisak.getKomentar());
	            utisakStmt.setInt(4, idKupca);
	            utisakStmt.executeUpdate();
	        }

	        connection.commit();
	        System.out.println("Uspešno kreirana kupovina sa računom i utiskom. ID korpe: " + idKorpe);

	    } catch (SQLException e) {
	        if (connection != null) {
	            connection.rollback();
	        }
	        throw e;
	    } finally {
	        if (connection != null) {
	            connection.setAutoCommit(true);
	            connection.close();
	        }
	    }
	}



	
	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Korpa entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Korpa> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Korpa> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korpa findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Korpa entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Korpa> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
