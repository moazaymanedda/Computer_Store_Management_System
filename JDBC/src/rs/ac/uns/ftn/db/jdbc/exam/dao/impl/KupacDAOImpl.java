package rs.ac.uns.ftn.db.jdbc.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.exam.dao.KupacDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupovineAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Kupac;

public class KupacDAOImpl implements KupacDAO {

	
	@Override
	public List<KupacStatistikaDTO> dobaviStatistikuKupaca() throws SQLException {
	    List<KupacStatistikaDTO> statistika = new ArrayList<>();
	    
	    String sql = """
	        SELECT 
	            k.ime_kupca || ' ' || k.prezime_kupca AS ime_i_prezime,
	            COUNT(DISTINCT r.id_racuna) AS broj_racuna,
	            SUM(r.ukupan_iznos) AS ukupna_potrosnja
	        FROM Kupac k
	        LEFT JOIN Racun r ON k.id_kupca = r.id_kupca
	        GROUP BY k.id_kupca, k.ime_kupca, k.prezime_kupca
	        HAVING COUNT(r.id_racuna) > 0
	        ORDER BY ukupna_potrosnja DESC
	    """;
	    
	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql);
	         ResultSet resultSet = preparedStatement.executeQuery()) {
	        
	        while (resultSet.next()) {
	            String imeIPrezime = resultSet.getString("ime_i_prezime");
	            int brojRacuna = resultSet.getInt("broj_racuna");
	            double ukupnaPotrosnja = resultSet.getDouble("ukupna_potrosnja");
	            
	            statistika.add(new KupacStatistikaDTO(imeIPrezime, brojRacuna, ukupnaPotrosnja));
	        }
	    }
	    
	    return statistika;
	}
	
	//Kompleksan upit 1 - Analiza kupovina po kupcima
	@Override
	public List<KupovineAnalizaDTO> getKupovineAnaliza() throws SQLException {
	    String query = """
	            SELECT
	                k.ime_kupca || ' ' || k.prezime_kupca AS ime_i_prezime,
	                kr.status_korpe,
	                COUNT(DISTINCT s.id_artikla) AS količina_u_korpi,
	                kr.datum_kreiranja,
	                COUNT(DISTINCT u.id_utiska) AS broj_utisaka,
	                AVG(u.ocena) AS zadovoljstvo_kupca
	            FROM
	                Kupac k
	                LEFT JOIN Korpa kr ON k.id_kupca = kr.id_kupca
	                LEFT JOIN sadrži s ON kr.id_korpe = s.id_korpe AND kr.id_kupca = s.id_kupca
	                LEFT JOIN Artikal a ON s.id_artikla = a.id_artikla
	                LEFT JOIN Utisak u ON k.id_kupca = u.id_kupca
	            WHERE
	                kr.datum_kreiranja >= ADD_MONTHS(SYSDATE, -6)
	            GROUP BY
	                k.id_kupca,
	                k.ime_kupca,
	                k.prezime_kupca,
	                kr.status_korpe,
	                kr.id_korpe,
	                kr.datum_kreiranja
	            HAVING
	                COUNT(DISTINCT s.id_artikla) > 0
	            ORDER BY
	                kr.datum_kreiranja DESC,
	                COUNT(DISTINCT s.id_artikla) DESC
	            """;

	    List<KupovineAnalizaDTO> kupovineList = new ArrayList<>();

	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query);
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            KupovineAnalizaDTO kupovina = new KupovineAnalizaDTO(
	                resultSet.getString("ime_i_prezime"),
	                resultSet.getString("status_korpe"),
	                resultSet.getInt("količina_u_korpi"),
	                resultSet.getDate("datum_kreiranja"),
	                resultSet.getInt("broj_utisaka"),
	                resultSet.getDouble("zadovoljstvo_kupca")
	            );
	            kupovineList.add(kupovina);
	        }
	    }

	    return kupovineList;
	}
	
	
	// Metoda za listanje svih kupaca
	@Override
	public List<KupacDTO> getAllKupci() throws SQLException {
	    String query = "SELECT id_kupca, ime_kupca, prezime_kupca FROM Kupac ORDER BY id_kupca";
	    List<KupacDTO> kupci = new ArrayList<>();
	    
	    try (Connection connection = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            System.out.println("ID Kupca: " + rs.getInt("id_kupca") + 
	                             ", Ime: " + rs.getString("ime_kupca") + 
	                             ", Prezime: " + rs.getString("prezime_kupca"));
	            kupci.add(new KupacDTO(rs.getInt("id_kupca"), 
	                                 rs.getString("ime_kupca"), 
	                                 rs.getString("prezime_kupca")));
	        }
	    }
	    return kupci;
	}
	
	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Kupac entity) throws SQLException {
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
	public Iterable<Kupac> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Kupac> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kupac findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Kupac entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Kupac> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
