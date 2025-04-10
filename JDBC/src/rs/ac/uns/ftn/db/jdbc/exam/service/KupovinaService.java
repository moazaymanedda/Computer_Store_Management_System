package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.KupacDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.KorpaDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.KupacDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupovineAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.UtisakDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.KorpaDAOImpl;

public class KupovinaService {
	private static final KupacDAO kupacDAO = new KupacDAOImpl();
	private static final KorpaDAO korpaDAO = new KorpaDAOImpl();
	
	
    // Metoda za kreiranje kupovine sa računom i utiskom
    public void kreirajKupovinuSaRacunomIUtiskom(int idKupca, List<Integer> artikliIds, 
                                                String nacinPlacanja, UtisakDTO utisak) 
            throws SQLException {
    	korpaDAO.kreirajKupovinuSaRacunomIUtiskom(idKupca, artikliIds, nacinPlacanja, utisak);
    }
    
    // Metoda za analizu kupovina po kupcima
    public List<KupovineAnalizaDTO> getKupovineAnaliza() throws SQLException {
        return kupacDAO.getKupovineAnaliza();
    }

    
    

	
	
	
	
	
	
}
