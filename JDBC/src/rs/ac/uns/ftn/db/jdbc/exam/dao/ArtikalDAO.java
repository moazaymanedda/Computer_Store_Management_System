package rs.ac.uns.ftn.db.jdbc.exam.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalOcenaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.theatre.model.Artikal;

public interface ArtikalDAO extends CRUDDao<Artikal, Integer> {

	List<ArtikalOcenaDTO> getProsecneOcenePoTipu() throws SQLException;

	List<ArtikalAnalizaDTO> getArtikliAnaliza() throws SQLException;

	List<ArtikalDTO> getAllArtikli() throws SQLException;

}
