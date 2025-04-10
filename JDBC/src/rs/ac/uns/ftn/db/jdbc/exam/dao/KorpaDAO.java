package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dto.UtisakDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Korpa;

public interface KorpaDAO extends CRUDDao<Korpa, Integer> {

	void kreirajKupovinuSaRacunomIUtiskom(int idKupca, List<Integer> artikliIds, String nacinPlacanja, UtisakDTO utisak)
			throws SQLException;

}
