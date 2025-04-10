package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class KupacDTO {
    private int idKupca;
    private String imeKupca;
    private String prezimeKupca;

    // Default konstruktor
    public KupacDTO() {
        super();
    }

    // Parametarski konstruktor
    public KupacDTO(int idKupca, String imeKupca, String prezimeKupca) {
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

    @Override
    public String toString() {
        return String.format("KupacDTO [idKupca=%d, imeKupca=%s, prezimeKupca=%s]", 
            idKupca, imeKupca, prezimeKupca);
    }
}
