package Modelo;

import java.util.Objects;

/**
 * Artista klaseak eratzen duen Artista objektua.
 */
public class Artista {
    protected int id;
    protected String izena;
    protected String irudia;
    protected String deskribapena;

    /**
     * Artista klasearen eraikitzailea.
     * @param id Artistaren IDa.
     * @param izena Artista izena.
     * @param irudia Artista irudia.
     * @param deskribapena Artista deskribapena.
     */
    public Artista(int id, String izena, String irudia, String deskribapena) {
        super();
        this.id = id;
        this.izena = izena;
        this.irudia = irudia;
        this.deskribapena = deskribapena;
    }

    /**
     * IDaren getter metodoa.
     * @return Artista IDa.
     */
    public int getId() {
        return id;
    }

    /**
     * IDaren setter metodoa.
     * @param id Artista IDa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Izenaren getter metodoa.
     * @return Artista izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Izenaren setter metodoa.
     * @param izena Artista izena.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Irudiaren getter metodoa.
     * @return Artista irudia.
     */
    public String getIrudia() {
        return irudia;
    }

    /**
     * Irudiaren setter metodoa.
     * @param irudia Artista irudia.
     */
    public void setIrudia(String irudia) {
        this.irudia = irudia;
    }

    /**
     * Deskribapenaren getter metodoa.
     * @return Artista deskribapena.
     */
    public String getDeskribapena() {
        return deskribapena;
    }

    /**
     * Deskribapenaren setter metodoa.
     * @param deskribapena Artista deskribapena.
     */
    public void setDeskribapena(String deskribapena) {
        this.deskribapena = deskribapena;
    }

    @Override
    public String toString() {
        return "Artista [id=" + id + ", izena=" + izena + ", irudia=" + irudia + ", deskribapena=" + deskribapena + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(deskribapena, id, irudia, izena);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artista other = (Artista) obj;
        return Objects.equals(deskribapena, other.deskribapena) && id == other.id
                && Objects.equals(irudia, other.irudia) && Objects.equals(izena, other.izena);
    }
}
