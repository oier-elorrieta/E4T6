package Modelo;

/**
 * Audio klaseak eratzen duen Audio objektua.
 */
public class Audio {
    protected int id;
    protected String izena;
    protected String erreprodukzioak;
    protected double iraupena;
    
    /**
     * Audio objektua sortzen du ID, izena, erreprodukzioak eta iraupena zehaztuak erabiliz.
     * 
     * @param id Audioren identifikazioa.
     * @param izena Audioren izena.
     * @param erreprodukzioak Audioren erreprodukzio-formatua.
     * @param iraupena Audioren iraupena minutuetan.
     */
    public Audio(int id, String izena, String erreprodukzioak, double iraupena) {
        this.id = id;
        this.izena = izena;
        this.erreprodukzioak = erreprodukzioak;
        this.iraupena = iraupena;
    }


    /**
     * Audioren identifikazioa itzultzen du.
     * 
     * @return Audioren identifikazioa.
     */
    public int getId() {
        return id;
    }


    /**
     * Audioren identifikazioa ezartzen du.
     * 
     * @param id Ezarri behar den Audioren identifikazioa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Audioren izena itzultzen du.
     * 
     * @return Audioren izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Audioren izena ezartzen du.
     * 
     * @param izena Ezarri behar den Audioren izena.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Audioren erreprodukzio-formatua itzultzen du.
     * 
     * @return Audioren erreprodukzio-formatua.
     */
    public String getErreprodukzioak() {
        return erreprodukzioak;
    }

    /**
     * Audioren erreprodukzio-formatua ezartzen du.
     * 
     * @param erreprodukzioak Ezarri behar den Audioren erreprodukzio-formatua.
     */
    public void setErreprodukzioak(String erreprodukzioak) {
        this.erreprodukzioak = erreprodukzioak;
    }

    /**
     * Audioren iraupena minutuetan itzultzen du.
     * 
     * @return Audioren iraupena minutuetan.
     */
    public double getIraupena() {
        return iraupena;
    }

    /**
     * Audioren iraupena minutuetan ezartzen du.
     * 
     * @param iraupena Ezarri behar den Audioren iraupena minutuetan.
     */
    public void setIraupena(double iraupena) {
        this.iraupena = iraupena;
    }

    /**
     * Audioren string errepresentazioa itzultzen du.
     * 
     * @return Audioren string errepresentazioa.
     */
    @Override
    public String toString() {
        return "Audio [id=" + id + ", izena=" + izena + ", erreprodukzioak=" + erreprodukzioak + ", iraupena="
                + iraupena + "]";
    }


}
