package rs.ac.uns.ftn.db.jdbc.exam.dto;
import java.sql.Date;

public class KupovineAnalizaDTO {
    private String imeIPrezime;
    private String statusKorpe;
    private int kolicinaUKorpi;
    private Date datumKreiranja;
    private int brojUtisaka;
    private double zadovoljstvoKupca;

    // Konstruktor
    public KupovineAnalizaDTO(String imeIPrezime, String statusKorpe, 
            int kolicinaUKorpi, Date datumKreiranja, 
            int brojUtisaka, double zadovoljstvoKupca) {
        this.imeIPrezime = imeIPrezime;
        this.statusKorpe = statusKorpe;
        this.kolicinaUKorpi = kolicinaUKorpi;
        this.datumKreiranja = datumKreiranja;
        this.brojUtisaka = brojUtisaka;
        this.zadovoljstvoKupca = zadovoljstvoKupca;
    }

    // Getteri i setteri
    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public String getStatusKorpe() {
        return statusKorpe;
    }

    public void setStatusKorpe(String statusKorpe) {
        this.statusKorpe = statusKorpe;
    }

    public int getKolicinaUKorpi() {
        return kolicinaUKorpi;
    }

    public void setKolicinaUKorpi(int kolicinaUKorpi) {
        this.kolicinaUKorpi = kolicinaUKorpi;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public int getBrojUtisaka() {
        return brojUtisaka;
    }

    public void setBrojUtisaka(int brojUtisaka) {
        this.brojUtisaka = brojUtisaka;
    }

    public double getZadovoljstvoKupca() {
        return zadovoljstvoKupca;
    }

    public void setZadovoljstvoKupca(double zadovoljstvoKupca) {
        this.zadovoljstvoKupca = zadovoljstvoKupca;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-15s %-15d %-20s %-15d %-15.2f",
            imeIPrezime, statusKorpe, kolicinaUKorpi, 
            datumKreiranja, brojUtisaka, zadovoljstvoKupca);
    }

    public static String getFormattedHeader() {
        return String.format("%-30s %-15s %-15s %-20s %-15s %-15s",
            "IME I PREZIME", "STATUS KORPE", "KOLICINA", 
            "DATUM KREIRANJA", "BROJ UTISAKA", "ZADOVOLJSTVO");
    }
}