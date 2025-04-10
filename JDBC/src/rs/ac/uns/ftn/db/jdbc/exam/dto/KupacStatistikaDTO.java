package rs.ac.uns.ftn.db.jdbc.exam.dto;

public class KupacStatistikaDTO {
    private String imeIPrezime;
    private int brojRacuna;
    private double ukupnaPotrosnja;

    // Konstruktor
    public KupacStatistikaDTO(String imeIPrezime, int brojRacuna, double ukupnaPotrosnja) {
        this.imeIPrezime = imeIPrezime;
        this.brojRacuna = brojRacuna;
        this.ukupnaPotrosnja = ukupnaPotrosnja;
    }

    // Getteri i setteri
    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public int getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(int brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public double getUkupnaPotrosnja() {
        return ukupnaPotrosnja;
    }

    public void setUkupnaPotrosnja(double ukupnaPotrosnja) {
        this.ukupnaPotrosnja = ukupnaPotrosnja;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imeIPrezime == null) ? 0 : imeIPrezime.hashCode());
        result = prime * result + brojRacuna;
        long temp = Double.doubleToLongBits(ukupnaPotrosnja);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        KupacStatistikaDTO other = (KupacStatistikaDTO) obj;
        if (brojRacuna != other.brojRacuna)
            return false;
        if (Double.doubleToLongBits(ukupnaPotrosnja) != Double.doubleToLongBits(other.ukupnaPotrosnja))
            return false;
        return imeIPrezime != null ? imeIPrezime.equals(other.imeIPrezime) : other.imeIPrezime == null;
    }

    @Override
    public String toString() {
        return String.format("%-30s %-10d %-10.2f", imeIPrezime, brojRacuna, ukupnaPotrosnja);
    }

    public static String getFormattedHeader() {
        return String.format("%-30s %-10s %-10s", "IME I PREZIME", "BROJ RACUNA", "UKUPNA POTROSNJA");
    }
}
