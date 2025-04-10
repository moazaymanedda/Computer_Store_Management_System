package rs.ac.uns.ftn.db.jdbc.exam.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.exam.dao.KupacDAO;
import rs.ac.uns.ftn.db.jdbc.exam.dao.impl.KupacDAOImpl;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacStatistikaDTO;

public class KupacService {
	private static final KupacDAO kupacDAO = new KupacDAOImpl();

	public List<KupacStatistikaDTO> getStatistikaKupaca() throws SQLException {
		return kupacDAO.dobaviStatistikuKupaca();
	}
	

    public List<KupacDTO> getAllKupci() throws SQLException {
        return kupacDAO.getAllKupci();
    }
}
