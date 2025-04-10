package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

public class Artikal {

    private int idArtikla;
    private double cena;
    private String nazivArtikla;
    private String tipArtikla;
    private int kolicinaNaStanju;

    public Artikal() {
        super();
    }

    public Artikal(int idArtikla, double cena, String nazivArtikla, String tipArtikla, int kolicinaNaStanju) {
        super();
        this.idArtikla = idArtikla;
        this.cena = cena;
        this.nazivArtikla = nazivArtikla;
        this.tipArtikla = tipArtikla;
        this.kolicinaNaStanju = kolicinaNaStanju;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idArtikla;
        result = prime * result + ((nazivArtikla == null) ? 0 : nazivArtikla.hashCode());
        result = prime * result + ((tipArtikla == null) ? 0 : tipArtikla.hashCode());
        result = prime * result + Double.hashCode(cena);
        result = prime * result + kolicinaNaStanju;
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
        Artikal other = (Artikal) obj;
        if (idArtikla != other.idArtikla)
            return false;
        if (nazivArtikla == null) {
            if (other.nazivArtikla != null)
                return false;
        } else if (!nazivArtikla.equals(other.nazivArtikla))
            return false;
        if (tipArtikla == null) {
            if (other.tipArtikla != null)
                return false;
        } else if (!tipArtikla.equals(other.tipArtikla))
            return false;
        if (Double.compare(cena, other.cena) != 0)
            return false;
        if (kolicinaNaStanju != other.kolicinaNaStanju)
            return false;
        return true;
    }

    public int getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(int idArtikla) {
        this.idArtikla = idArtikla;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }

    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }

    public String getTipArtikla() {
        return tipArtikla;
    }

    public void setTipArtikla(String tipArtikla) {
        this.tipArtikla = tipArtikla;
    }

    public int getKolicinaNaStanju() {
        return kolicinaNaStanju;
    }

    public void setKolicinaNaStanju(int kolicinaNaStanju) {
        this.kolicinaNaStanju = kolicinaNaStanju;
    }

    @Override
    public String toString() {
        return String.format("%-6d %-10.2f %-30.30s %-20.20s %-6d", 
                idArtikla, cena, nazivArtikla, tipArtikla, kolicinaNaStanju);
    }

    public static String getFormattedHeader() {
        return String.format("%-6s %-10s %-30s %-20s %-6s", 
                "ID", "CENA", "NAZIV ARTIKLA", "TIP ARTIKLA", "KOL");
    }
}
