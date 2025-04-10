package rs.ac.uns.ftn.db.jdbc.exam.dto;

import java.sql.Date;

public class RacunDTO {
    private int idRacuna;
    private Date datumIzdavanja;
    private double ukupanIznos;
    private String nacinPlacanja;
    private int idKorpe;
    private int idKupca;
    
    public RacunDTO(int idRacuna, Date datumIzdavanja, double ukupanIznos, 
                    String nacinPlacanja, int idKorpe, int idKupca) {
        this.idRacuna = idRacuna;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.nacinPlacanja = nacinPlacanja;
        this.idKorpe = idKorpe;
        this.idKupca = idKupca;
    }
    
    // Getteri i setteri
    public int getIdRacuna() { return idRacuna; }
    public void setIdRacuna(int idRacuna) { this.idRacuna = idRacuna; }
    public Date getDatumIzdavanja() { return datumIzdavanja; }
    public void setDatumIzdavanja(Date datumIzdavanja) { this.datumIzdavanja = datumIzdavanja; }
    public double getUkupanIznos() { return ukupanIznos; }
    public void setUkupanIznos(double ukupanIznos) { this.ukupanIznos = ukupanIznos; }
    public String getNacinPlacanja() { return nacinPlacanja; }
    public void setNacinPlacanja(String nacinPlacanja) { this.nacinPlacanja = nacinPlacanja; }
    public int getIdKorpe() { return idKorpe; }
    public void setIdKorpe(int idKorpe) { this.idKorpe = idKorpe; }
    public int getIdKupca() { return idKupca; }
    public void setIdKupca(int idKupca) { this.idKupca = idKupca; }
}
