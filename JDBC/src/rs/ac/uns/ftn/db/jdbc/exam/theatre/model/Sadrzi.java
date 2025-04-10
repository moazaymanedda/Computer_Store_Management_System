package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

public class Sadrzi {
    private int idArtikla;
    private int idKorpe;
    private int idKupca;

    // Default konstruktor
    public Sadrzi() {
        super();
    }

    // Parametarski konstruktor
    public Sadrzi(int idArtikla, int idKorpe, int idKupca) {
        super();
        this.idArtikla = idArtikla;
        this.idKorpe = idKorpe;
        this.idKupca = idKupca;
    }

    // Getteri i setteri
    public int getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(int idArtikla) {
        this.idArtikla = idArtikla;
    }

    public int getIdKorpe() {
        return idKorpe;
    }

    public void setIdKorpe(int idKorpe) {
        this.idKorpe = idKorpe;
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
        result = prime * result + idArtikla;
        result = prime * result + idKorpe;
        result = prime * result + idKupca;
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
        Sadrzi other = (Sadrzi) obj;
        if (idArtikla != other.idArtikla)
            return false;
        if (idKorpe != other.idKorpe)
            return false;
        if (idKupca != other.idKupca)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-10d %-10d", idArtikla, idKorpe, idKupca);
    }

    // Zaglavlje za formatirani ispis
    public static String getFormattedHeader() {
        return String.format("%-10s %-10s %-10s", "ID ARTIKLA", "ID KORPE", "ID KUPCA");
    }
}
