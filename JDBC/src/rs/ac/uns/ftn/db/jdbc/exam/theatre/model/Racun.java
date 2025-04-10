package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

import java.util.Date;
import java.util.Objects;

public class Racun {
    private int idRacuna;
    private Date datumIzdavanja;
    private Double ukupanIznos;
    private String nacinPlacanja;
    private int idKorpe;
    private int idKupca;

    // Default konstruktor
    public Racun() {
        super();
    }

    // Parametarski konstruktor
    public Racun(int idRacuna, Date datumIzdavanja, Double ukupanIznos, String nacinPlacanja, int idKorpe, int idKupca) {
        super();
        this.idRacuna = idRacuna;
        this.datumIzdavanja = datumIzdavanja;
        this.ukupanIznos = ukupanIznos;
        this.nacinPlacanja = nacinPlacanja;
        this.idKorpe = idKorpe;
        this.idKupca = idKupca;
    }

    // Getteri i setteri
    public int getIdRacuna() {
        return idRacuna;
    }

    public void setIdRacuna(int idRacuna) {
        this.idRacuna = idRacuna;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public String getNacinPlacanja() {
        return nacinPlacanja;
    }

    public void setNacinPlacanja(String nacinPlacanja) {
        this.nacinPlacanja = nacinPlacanja;
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
        return Objects.hash(idRacuna, datumIzdavanja, ukupanIznos, nacinPlacanja, idKorpe, idKupca);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Racun other = (Racun) obj;
        return idRacuna == other.idRacuna &&
               Objects.equals(datumIzdavanja, other.datumIzdavanja) &&
               Objects.equals(ukupanIznos, other.ukupanIznos) &&
               Objects.equals(nacinPlacanja, other.nacinPlacanja) &&
               idKorpe == other.idKorpe &&
               idKupca == other.idKupca;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-10.2f %-15s %-10d %-10d",
                idRacuna, datumIzdavanja, ukupanIznos, nacinPlacanja, idKorpe, idKupca);
    }

    // Zaglavlje za formatirani ispis
    public static String getFormattedHeader() {
        return String.format("%-10s %-20s %-10s %-15s %-10s %-10s",
                "ID RACUNA", "DATUM IZDAVANJA", "UKUPAN IZNOS", "NACIN PLACANJA", "ID KORPE", "ID KUPCA");
    }
}
