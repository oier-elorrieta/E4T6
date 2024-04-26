package Modelo;

/**
 * Artista klaseak eratzen duen Artista objektua.
 */
public class Artista {
    protected int id;
    protected String izena;
    protected String irudia;
    
    /**
     * Artista objektua sortzen du ID, izena eta irudia zehaztuak erabiliz.
     * 
     * @param id Artistaren identifikazioa.
     * @param izena Artistaren artistikoa izena.
     * @param irudia Artistaren irudia.
     */
    public Artista(int id, String izena, String irudia) {
        this.id = id;
        this.izena = izena;
        this.irudia = irudia;
    }

    /**
     * Artistaren identifikazioa itzultzen du.
     * 
     * @return Artistaren identifikazioa.
     */
    public int getId() {
        return id;
    }

    /**
     * Artistaren identifikazioa ezartzen du.
     * 
     * @param id Ezarri behar den Artistaren identifikazioa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Artistaren artistikoa izena itzultzen du.
     * 
     * @return Artistaren artistikoa izena.
     */
    public String getIzenArtistikoa() {
        return izena;
    }

    /**
     * Artistaren artistikoa izena ezartzen du.
     * 
     * @param izena Ezarri behar den Artistaren artistikoa izena.
     */
    public void setIzenArtistikoa(String izena) {
        this.izena = izena;
    }

    /**
     * Artistaren irudia itzultzen du.
     * 
     * @return Artistaren irudia.
     */
    public String getIrudia() {
        return irudia;
    }

    /**
     * Artistaren irudia ezartzen du.
     * 
     * @param irudia Ezarri behar den Artistaren irudia.
     */
    public void setIrudia(String irudia) {
        this.irudia = irudia;
    }

    /**
     * Artistaren string errepresentazioa itzultzen du.
     * 
     * @return Artistaren string errepresentazioa.
     */
    @Override
    public String toString() {
        return "Artista [id=" + id + ", IzenArtistikoa=" + izena + ", Irudia=" + irudia + "]";
    }

}