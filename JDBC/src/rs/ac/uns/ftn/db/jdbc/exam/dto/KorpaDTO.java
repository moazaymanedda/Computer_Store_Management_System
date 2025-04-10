package rs.ac.uns.ftn.db.jdbc.exam.dto;

import java.sql.Date;

public class KorpaDTO {
    private int idKorpe;
    private Date datumKreiranja;
    private String statusKorpe;
    private int idKupca;

    // Default konstruktor
    public KorpaDTO() {
        super();
    }

    // Parametarski konstruktor
    public KorpaDTO(int idKorpe, Date datumKreiranja, String statusKorpe, int idKupca) {
        super();
        this.idKorpe = idKorpe;
        this.datumKreiranja = datumKreiranja;
        this.statusKorpe = statusKorpe;
        this.idKupca = idKupca;
    }

    // Getteri i setteri
    public int getIdKorpe() {
        return idKorpe;
    }

    public void setIdKorpe(int idKorpe) {
        this.idKorpe = idKorpe;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getStatusKorpe() {
        return statusKorpe;
    }

    public void setStatusKorpe(String statusKorpe) {
        this.statusKorpe = statusKorpe;
    }

    public int getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(int idKupca) {
        this.idKupca = idKupca;
    }

    @Override
    public String toString() {
        return String.format("KorpaDTO [idKorpe=%d, datumKreiranja=%s, statusKorpe=%s, idKupca=%d]", 
            idKorpe, datumKreiranja, statusKorpe, idKupca);
    }
}
