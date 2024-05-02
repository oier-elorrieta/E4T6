package Modelo;

import java.util.Objects;

/**
 * Artista klaseak eratzen duen Artista objektua.
 */
public class Artista {
    protected int id; // Artistaaren identifikadorea
    protected String izena; // Artistaaren izena
    protected String irudia; // Artistaaren irudia
    protected String deskribapena; // Artistaaren deskribapena

    /**
     * Artistaaren konstruktorea.
     * 
     * @param id Artistaaren identifikadorea
     * @param izena Artistaaren izena
     * @param irudia Artistaaren irudia
     * @param deskribapena Artistaaren deskribapena
     */
    public Artista(int id, String izena, String irudia, String deskribapena) {
        super();
        this.id = id;
        this.izena = izena;
        this.irudia = irudia;
        this.deskribapena = deskribapena;
    }

    /**
     * Artistaaren identifikadorearen getter metoda.
     * 
     * @return Artistaaren identifikadorea
     */
    public int getId() {
        return id;
    }

    /**
     * Artistaaren identifikadorearen setter metoda.
     * 
     * @param id Artistaaren identifikadorea
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Artistaaren izenaren getter metoda.
     * 
     * @return Artistaaren izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Artistaaren izenaren setter metoda.
     * 
     * @param izena Artistaaren izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Artistaaren irudiaren getter metoda.
     * 
     * @return Artistaaren irudia
     */
    public String getIrudia() {
        return irudia;
    }

    /**
     * Artistaaren irudiaren setter metoda.
     * 
     * @param irudia Artistaaren irudia
     */
    public void setIrudia(String irudia) {
        this.irudia = irudia;
    }

    /**
     * Artistaaren deskribapenaren getter metoda.
     * 
     * @return Artistaaren deskribapena
     */
    public String getDeskribapena() {
        return deskribapena;
    }

    /**
     * Artistaaren deskribapenaren setter metoda.
     * 
     * @param deskribapena Artistaaren deskribapena
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