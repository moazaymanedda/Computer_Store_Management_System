package rs.ac.uns.ftn.db.jdbc.exam.theatre.model;

public class DesktopRacunar {

    private int idArtikla;
    private char polovan; // 'N' ili 'Y'
    private char popravljen; // 'N' ili 'Y'

    public DesktopRacunar() {
        super();
    }

    public DesktopRacunar(int idArtikla, char polovan, char popravljen) {
        super();
        this.idArtikla = idArtikla;
        this.polovan = polovan;
        this.popravljen = popravljen;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idArtikla;
        result = prime * result + Character.hashCode(polovan);
        result = prime * result + Character.hashCode(popravljen);
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
        DesktopRacunar other = (DesktopRacunar) obj;
        if (idArtikla != other.idArtikla)
            return false;
        if (polovan != other.polovan)
            return false;
        if (popravljen != other.popravljen)
            return false;
        return true;
    }

    public int getIdArtikla() {
        return idArtikla;
    }

    public void setIdArtikla(int idArtikla) {
        this.idArtikla = idArtikla;
    }

    public char getPolovan() {
        return polovan;
    }

    public void setPolovan(char polovan) {
        if (polovan == 'N' || polovan == 'Y') {
            this.polovan = polovan;
        } else {
            throw new IllegalArgumentException("Polovan mora biti 'N' ili 'Y'");
        }
    }

    public char getPopravljen() {
        return popravljen;
    }

    public void setPopravljen(char popravljen) {
        if (popravljen == 'N' || popravljen == 'Y') {
            this.popravljen = popravljen;
        } else {
            throw new IllegalArgumentException("Popravljen mora biti 'N' ili 'Y'");
        }
    }

    @Override
    public String toString() {
        return String.format("%-6d %-10s %-10s", 
                idArtikla, 
                polovan == 'Y' ? "Da" : "Ne", 
                popravljen == 'Y' ? "Da" : "Ne");
    }

    public static String getFormattedHeader() {
        return String.format("%-6s %-10s %-10s", "ID", "POLOVAN", "POPRAVLJEN");
    }
}
