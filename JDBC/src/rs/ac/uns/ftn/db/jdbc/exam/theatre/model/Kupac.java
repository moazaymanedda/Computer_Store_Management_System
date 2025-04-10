package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

public class Kupac {
    private int idKupca;
    private String imeKupca;
    private String prezimeKupca;

    // Default konstruktor
    public Kupac() {
        super();
    }

    // Parametarski konstruktor
    public Kupac(int idKupca, String imeKupca, String prezimeKupca) {
        super();
        this.idKupca = idKupca;
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
    }

    // Getteri i setteri
    public int getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(int idKupca) {
        this.idKupca = idKupca;
    }

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    // Metode hashCode, equals i toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idKupca;
        result = prime * result + ((imeKupca == null) ? 0 : imeKupca.hashCode());
        result = prime * result + ((prezimeKupca == null) ? 0 : prezimeKupca.hashCode());
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
        Kupac other = (Kupac) obj;
        if (idKupca != other.idKupca)
            return false;
        if (imeKupca == null) {
            if (other.imeKupca != null)
                return false;
        } else if (!imeKupca.equals(other.imeKupca))
            return false;
        if (prezimeKupca == null) {
            if (other.prezimeKupca != null)
                return false;
        } else if (!prezimeKupca.equals(other.prezimeKupca))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-30.30s %-20.20s", idKupca, imeKupca, prezimeKupca);
    }

    // Zaglavlje za formatirani ispis
    public static String getFormattedHeader() {
        return String.format("%-6s %-30.30s %-20.20s", "ID", "IME KUPCA", "PREZIME KUPCA");
    }
}
