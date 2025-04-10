package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class ArtikalAnalizaDTO {
    private String nazivArtikla;
    private String tipArtikla;
    private int kolNaSt;
    private int brojAktivnihKorpi;
    private int brojZatvorenihKorpi;
    private String popularnost;
    
    // Konstruktor
    public ArtikalAnalizaDTO(String nazivArtikla, String tipArtikla, 
                            int kolNaSt, int brojAktivnihKorpi, 
                            int brojZatvorenihKorpi, String popularnost) {
        this.nazivArtikla = nazivArtikla;
        this.tipArtikla = tipArtikla;
        this.kolNaSt = kolNaSt;
        this.brojAktivnihKorpi = brojAktivnihKorpi;
        this.brojZatvorenihKorpi = brojZatvorenihKorpi;
        this.popularnost = popularnost;
    }
    
    // Getteri i setteri
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
    
    public int getKolNaSt() {
        return kolNaSt;
    }
    
    public void setKolNaSt(int kolNaSt) {
        this.kolNaSt = kolNaSt;
    }
    
    public int getBrojAktivnihKorpi() {
        return brojAktivnihKorpi;
    }
    
    public void setBrojAktivnihKorpi(int brojAktivnihKorpi) {
        this.brojAktivnihKorpi = brojAktivnihKorpi;
    }
    
    public int getBrojZatvorenihKorpi() {
        return brojZatvorenihKorpi;
    }
    
    public void setBrojZatvorenihKorpi(int brojZatvorenihKorpi) {
        this.brojZatvorenihKorpi = brojZatvorenihKorpi;
    }
    
    public String getPopularnost() {
        return popularnost;
    }
    
    public void setPopularnost(String popularnost) {
        this.popularnost = popularnost;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nazivArtikla == null) ? 0 : nazivArtikla.hashCode());
        result = prime * result + ((tipArtikla == null) ? 0 : tipArtikla.hashCode());
        result = prime * result + kolNaSt;
        result = prime * result + brojAktivnihKorpi;
        result = prime * result + brojZatvorenihKorpi;
        result = prime * result + ((popularnost == null) ? 0 : popularnost.hashCode());
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
        ArtikalAnalizaDTO other = (ArtikalAnalizaDTO) obj;
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
        if (kolNaSt != other.kolNaSt)
            return false;
        if (brojAktivnihKorpi != other.brojAktivnihKorpi)
            return false;
        if (brojZatvorenihKorpi != other.brojZatvorenihKorpi)
            return false;
        if (popularnost == null) {
            if (other.popularnost != null)
                return false;
        } else if (!popularnost.equals(other.popularnost))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-15d %-20d %-20d %-15s",
                nazivArtikla, tipArtikla, kolNaSt, brojAktivnihKorpi, brojZatvorenihKorpi, popularnost);
    }
    
    public static String getFormattedHeader() {
        return String.format("%-20s %-15s %-15s %-20s %-20s %-15s",
                "NAZIV ARTIKLA", "TIP ARTIKLA", "KOL NA ST", "AKTIVNE KORPE", "ZATVORENE KORPE", "POPULARNOST");
    }
}