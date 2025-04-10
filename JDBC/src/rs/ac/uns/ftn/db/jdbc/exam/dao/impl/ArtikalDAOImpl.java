package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rs.ac.uns.ftn.db.jdbc.exam.dao.ArtikalDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalOcenaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Artikal;
import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;

public class ArtikalDAOImpl implements ArtikalDAO {

	// Jednostavan upit - prosečna ocena zadovoljstva kupca po tipu artikla
	public List<ArtikalOcenaDTO> getProsecneOcenePoTipu() throws SQLException {
	    String query = """
            SELECT a.tip_artikla, AVG(u.ocena) as prosecna_ocena, COUNT(u.id_utiska) as broj_utisaka
				FROM Artikal a
				JOIN sadrži s ON a.id_artikla = s.id_artikla
				JOIN Korpa k ON s.id_korpe = k.id_korpe
				JOIN Utisak u ON k.id_kupca = u.id_kupca
				WHERE EXISTS (
				    SELECT 1
				    FROM Racun r
				    WHERE r.id_kupca = k.id_kupca
				)
				GROUP BY a.tip_artikla
				ORDER BY prosecna_ocena DESC
	    	""";
	    
	    /*
	    String query2 = """
	            SELECT a.tip_artikla, AVG(u.ocena) as prosecna_ocena, COUNT(u.id_utiska) as broj_utisaka
	            FROM Artikal a
	            JOIN sadrži s ON a.id_artikla = s.id_artikla
	            JOIN Korpa k ON s.id_korpe = k.id_korpe
	            JOIN Utisak u ON k.id_kupca = u.id_kupca
	            GROUP BY a.tip_artikla
	            ORDER BY prosecna_ocena DESC
		    """;
		 */
	    
	    List<ArtikalOcenaDTO> artikalOceneList = new ArrayList<>();
	    
	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        
	        while (resultSet.next()) {
	            ArtikalOcenaDTO artikalOcena = new ArtikalOcenaDTO(
	                resultSet.getString(1),  // naziv_artikla
	                resultSet.getDouble(2),  // prosecna_ocena
	                resultSet.getInt(3)      // broj_utisaka
	            );
	            artikalOceneList.add(artikalOcena);
	        }
	    }
	    
	    return artikalOceneList;
	}
	
	
	@Override
	public List<ArtikalAnalizaDTO> getArtikliAnaliza() throws SQLException {
	    String query = """
			SELECT
			    a.naziv_artikla,
			    a.tip_artikla,
			    a.kol_na_st as kolicina_na_stanju,
			    SUM(CASE WHEN kr.status_korpe = 'Aktivna' THEN 1 ELSE 0 END) as broj_aktivnih_korpi,
			    SUM(CASE WHEN kr.status_korpe = 'Zatvorena' THEN 1 ELSE 0 END) as broj_zatvorenih_korpi,
			    ROUND(
			        (COUNT(s.id_artikla) * 100.0) / 
			        (SELECT COUNT(*) FROM sadrži s2 JOIN Korpa kr2 ON s2.id_korpe = kr2.id_korpe AND s2.id_kupca = kr2.id_kupca 
			         WHERE kr2.status_korpe IN ('Aktivna', 'Zatvorena') AND kr2.datum_kreiranja >= ADD_MONTHS(SYSDATE, -3)),
			        2
			    ) || '%' as popularnost
			FROM
			    Artikal a
			    LEFT JOIN sadrži s ON a.id_artikla = s.id_artikla
			    LEFT JOIN Korpa kr ON s.id_korpe = kr.id_korpe AND s.id_kupca = kr.id_kupca
			    LEFT JOIN Kupac k ON kr.id_kupca = k.id_kupca
			WHERE
			    kr.datum_kreiranja >= ADD_MONTHS(SYSDATE, -3)
			GROUP BY
			    a.id_artikla,
			    a.naziv_artikla,
			    a.tip_artikla,
			    a.kol_na_st
			HAVING
			    COUNT(s.id_artikla) > 0
			ORDER BY
			    popularnost DESC
	        """;

	    List<ArtikalAnalizaDTO> artikliList = new ArrayList<>();

	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            ArtikalAnalizaDTO artikal = new ArtikalAnalizaDTO(
	                resultSet.getString(1),  // naziv_artikla
	                resultSet.getString(2),  // tip_artikla
	                resultSet.getInt(3),     // kol_na_st
	                resultSet.getInt(4),     // broj_aktivnih_korpi
	                resultSet.getInt(5),     // broj_zatvorenih_korpi
	                resultSet.getString(6)   // popularnost
	            );
	            artikliList.add(artikal);
	        }
	    }

	    return artikliList;
	}
	
	// Metoda za listanje svih artikala
	@Override
	public List<ArtikalDTO> getAllArtikli() throws SQLException {
	    String query = "SELECT id_artikla, naziv_artikla, cena FROM Artikal ORDER BY id_artikla";
	    List<ArtikalDTO> artikli = new ArrayList<>();
	    
	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            System.out.println("ID Artikla: " + rs.getInt("id_artikla") + 
	                             ", Naziv: " + rs.getString("naziv_artikla") +
	                             ", Cena: " + rs.getDouble("cena"));
	            artikli.add(new ArtikalDTO(rs.getInt("id_artikla"), 
	                                     rs.getDouble("cena"),
	                                     rs.getString("naziv_artikla")));
	        }
	    }
	    return artikli;
	}
	
	
	
	
	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Artikal entity) throws SQLException {
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
	public Iterable<Artikal> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Artikal> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artikal findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Artikal entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Artikal> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
