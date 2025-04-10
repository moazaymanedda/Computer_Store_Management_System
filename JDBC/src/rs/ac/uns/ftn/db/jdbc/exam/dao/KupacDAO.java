package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupovineAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Kupac;

public interface KupacDAO extends CRUDDao<Kupac, Integer> {

	List<KupovineAnalizaDTO> getKupovineAnaliza() throws SQLException;

	List<KupacDTO> getAllKupci() throws SQLException;

	List<KupacStatistikaDTO> dobaviStatistikuKupaca() throws SQLException;
}
