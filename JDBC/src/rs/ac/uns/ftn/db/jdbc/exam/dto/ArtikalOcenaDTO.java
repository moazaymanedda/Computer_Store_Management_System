package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class ArtikalOcenaDTO {
    private String nazivArtikla;
    private double prosecnaOcena;
    private int brojUtisaka;
    
    public ArtikalOcenaDTO(String nazivArtikla, double prosecnaOcena, int brojUtisaka) {
        this.nazivArtikla = nazivArtikla;
        this.prosecnaOcena = prosecnaOcena;
        this.brojUtisaka = brojUtisaka;
    }

    public String getNazivArtikla() {
        return nazivArtikla;
    }
    
    public void setNazivArtikla(String nazivArtikla) {
        this.nazivArtikla = nazivArtikla;
    }
    
    public double getProsecnaOcena() {
        return prosecnaOcena;
    }
    
    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }
    
    public int getBrojUtisaka() {
        return brojUtisaka;
    }
    
    public void setBrojUtisaka(int brojUtisaka) {
        this.brojUtisaka = brojUtisaka;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nazivArtikla == null) ? 0 : nazivArtikla.hashCode());
        long temp = Double.doubleToLongBits(prosecnaOcena);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + brojUtisaka;
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
        ArtikalOcenaDTO other = (ArtikalOcenaDTO) obj;
        if (nazivArtikla == null) {
            if (other.nazivArtikla != null)
                return false;
        } else if (!nazivArtikla.equals(other.nazivArtikla))
            return false;
        if (Double.doubleToLongBits(prosecnaOcena) != Double.doubleToLongBits(other.prosecnaOcena))
            return false;
        if (brojUtisaka != other.brojUtisaka)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15.2f %-10d", nazivArtikla, prosecnaOcena, brojUtisaka);
    }

    
    public static String getFormattedHeader() {
        return String.format("%-20s %-15s %-15s",
                "NAZIV ARTIKLA", "PROSECNA OCENA", "BROJ UTISAKA");
    }

}
