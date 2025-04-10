package rs.ac.uns.ftn.db.jdbc.exam.dto;

import java.sql.Date;

public class UtisakDTO {
    private int idUtiska;
    private double ocena;
    private String komentar;
    private Date datumUtiska;
    private int idKupca;

    // Default konstruktor
    public UtisakDTO() {
        super();
    }

    // Parametarski konstruktor
    public UtisakDTO(int idUtiska, double ocena, String komentar, Date datumUtiska, int idKupca) {
        super();
        this.idUtiska = idUtiska;
        this.ocena = ocena;
        this.komentar = komentar;
        this.datumUtiska = datumUtiska;
        this.idKupca = idKupca;
    }

    // Getteri i setteri
    public int getIdUtiska() {
        return idUtiska;
    }

    public void setIdUtiska(int idUtiska) {
        this.idUtiska = idUtiska;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Date getDatumUtiska() {
        return datumUtiska;
    }

    public void setDatumUtiska(Date datumUtiska) {
        this.datumUtiska = datumUtiska;
    }

    public int getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(int idKupca) {
        this.idKupca = idKupca;
    }

    @Override
    public String toString() {
        return String.format("UtisakDTO [idUtiska=%d, ocena=%.1f, komentar=%s, datumUtiska=%s, idKupca=%d]", 
            idUtiska, ocena, komentar, datumUtiska, idKupca);
    }
}
