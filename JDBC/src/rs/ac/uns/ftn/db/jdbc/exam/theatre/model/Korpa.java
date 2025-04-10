package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

import java.util.Date;

public class Korpa {
    private int idKorpe;
    private Date datumKreiranja;
    private String statusKorpe;
    private int idKupca;

    // Default konstruktor
    public Korpa() {
        super();
    }

    // Parametarski konstruktor
    public Korpa(int idKorpe, Date datumKreiranja, String statusKorpe, int idKupca) {
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

    // Metode hashCode, equals i toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datumKreiranja == null) ? 0 : datumKreiranja.hashCode());
        result = prime * result + idKorpe;
        result = prime * result + idKupca;
        result = prime * result + ((statusKorpe == null) ? 0 : statusKorpe.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Korpa other = (Korpa) obj;
        if (datumKreiranja == null) {
            if (other.datumKreiranja != null)
                return false;
        } else if (!datumKreiranja.equals(other.datumKreiranja))
            return false;
        if (idKorpe != other.idKorpe)
            return false;
        if (idKupca != other.idKupca)
            return false;
        if (statusKorpe == null) {
            if (other.statusKorpe != null)
                return false;
        } else if (!statusKorpe.equals(other.statusKorpe))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-10s %-20s %-6d", idKorpe, datumKreiranja, statusKorpe, idKupca);
    }

    // Zaglavlje za formatirani ispis
    public static String getFormattedHeader() {
        return String.format("%-6s %-10s %-20s %-6s", "ID", "DATUM", "STATUS", "ID KUPCA");
    }
}
