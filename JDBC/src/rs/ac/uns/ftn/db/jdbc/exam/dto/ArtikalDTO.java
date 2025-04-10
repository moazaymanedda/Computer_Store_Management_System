package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class ArtikalDTO {

    private int idArtikla;
    private double cena;
    private String nazivArtikla;
    private String tipArtikla;
    private int kolNaSt;

    // Default konstruktor
    public ArtikalDTO() {
        super();
    }

    // Parametarski konstruktor
    public ArtikalDTO(int idArtikla, double cena, String nazivArtikla, String tipArtikla, int kolNaSt) {
        super();
        this.idArtikla = idArtikla;
        this.cena = cena;
        this.nazivArtikla = nazivArtikla;
        this.tipArtikla = tipArtikla;
        this.kolNaSt = kolNaSt;
    }
    
    public ArtikalDTO(int idArtikla, double cena, String nazivArtikla) {
        super();
        this.idArtikla = idArtikla;
        this.cena = cena;
        this.nazivArtikla = nazivArtikla;
    }

    // Getteri i setteri
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

    public int getKolNaSt() {
        return kolNaSt;
    }

    public void setKolNaSt(int kolNaSt) {
        this.kolNaSt = kolNaSt;
    }

    @Override
    public String toString() {
        return String.format("ArtikalDTO [idArtikla=%d, cena=%.2f, nazivArtikla=%s, tipArtikla=%s, kolNaSt=%d]", 
            idArtikla, cena, nazivArtikla, tipArtikla, kolNaSt);
    }
}
