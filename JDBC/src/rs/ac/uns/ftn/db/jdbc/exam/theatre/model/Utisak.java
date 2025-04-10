package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

import java.util.Date;

public class Utisak {
    private int idUtiska;
    private double ocena;
    private String komentar;
    private Date datumUtiska;
    private int idKupca;

    // Default konstruktor
    public Utisak() {
        super();
    }

    // Parametarski konstruktor
    public Utisak(int idUtiska, double ocena, String komentar, Date datumUtiska, int idKupca) {
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

    // Metode hashCode, equals i toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(ocena);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((datumUtiska == null) ? 0 : datumUtiska.hashCode());
        result = prime * result + idKupca;
        result = prime * result + idUtiska;
        result = prime * result + ((komentar == null) ? 0 : komentar.hashCode());
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
        Utisak other = (Utisak) obj;
        if (Double.doubleToLongBits(ocena) != Double.doubleToLongBits(other.ocena))
            return false;
        if (datumUtiska == null) {
            if (other.datumUtiska != null)
                return false;
        } else if (!datumUtiska.equals(other.datumUtiska))
            return false;
        if (idKupca != other.idKupca)
            return false;
        if (idUtiska != other.idUtiska)
            return false;
        if (komentar == null) {
            if (other.komentar != null)
                return false;
        } else if (!komentar.equals(other.komentar))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-5.1f %-50.50s %-10s %-6d", idUtiska, ocena, komentar, datumUtiska, idKupca);
    }

    // Zaglavlje za formatirani ispis
    public static String getFormattedHeader() {
        return String.format("%-6s %-5s %-50s %-10s %-6s", "ID", "OCENA", "KOMENTAR", "DATUM", "ID KUPCA");
    }
}
