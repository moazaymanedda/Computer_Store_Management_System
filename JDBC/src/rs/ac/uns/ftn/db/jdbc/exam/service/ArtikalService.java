package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.ArtikalDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.ArtikalDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalOcenaDTO;

public class ArtikalService {
	private static final ArtikalDAO artikalDAO = new ArtikalDAOImpl();

    // Metoda za dobavljanje svih artikala
    public List<ArtikalDTO> getAllArtikli() throws SQLException {
        return artikalDAO.getAllArtikli();
    }
    
    // Metoda za detaljnu analizu artikala
    public List<ArtikalAnalizaDTO> getArtikliAnaliza() throws SQLException {
        return artikalDAO.getArtikliAnaliza();
    }
    
    // Metoda za prosečne ocene po tipu artikla
    public List<ArtikalOcenaDTO> getProsecneOcenePoTipu() throws SQLException {
        return artikalDAO.getProsecneOcenePoTipu();
    }
}
