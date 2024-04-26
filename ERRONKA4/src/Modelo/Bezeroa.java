package Modelo;

import java.sql.Date;

/**
 * Bezeroa klaseak eratzen duen Bezeroa objektua.
 */
public class Bezeroa {
    protected int id;
    protected String izena;
    protected String abizena;
    protected String hizkuntza;
    protected String erabiltzailea;
    protected String pasahitza;
    protected Date jaiotzedata;
    protected Date erregistrodata;
    protected Date premiummuga;
    protected boolean premium;
    
    /**
     * Bezeroa objektua sortzen du ID, izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotze-data eta erregistro-data zehaztuak erabiliz.
     * 
     * @param id Bezeroaren identifikazioa.
     * @param izena Bezeroaren izena.
     * @param abizena Bezeroaren abizena.
     * @param hizkuntza Bezeroaren hizkuntza.
     * @param erabiltzailea Bezeroaren erabiltzaile izena.
     * @param pasahitza Bezeroaren pasahitza.
     * @param jaiotzedata Bezeroaren jaiotze-data.
     * @param erregistrodata Bezeroaren erregistro-data.
     */
    public Bezeroa(String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza, Date jaiotzedata, Date erregistrodata) {
       
        this.izena = izena;
        this.abizena = abizena;
        this.hizkuntza = hizkuntza;
        this.erabiltzailea = erabiltzailea;
        this.pasahitza = pasahitza;
        this.jaiotzedata = jaiotzedata;
        this.erregistrodata = erregistrodata;
    }
    
   
    
   
	/**
     * Bezeroaren identifikazioa itzultzen du.
     * 
     * @return Bezeroaren identifikazioa.
     */
    public int getId() {
        return id;
    }

    /**
     * Bezeroaren identifikazioa ezartzen du.
     * 
     * @param id Ezarri behar den Bezeroaren identifikazioa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Bezeroaren izena itzultzen du.
     * 
     * @return Bezeroaren izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Bezeroaren izena ezartzen du.
     * 
     * @param izena Ezarri behar den Bezeroaren izena.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Bezeroaren abizena itzultzen du.
     * 
     * @return Bezeroaren abizena.
     */
    public String getAbizena() {
        return abizena;
    }

    /**
     * Bezeroaren abizena ezartzen du.
     * 
     * @param abizena Ezarri behar den Bezeroaren abizena.
     */
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    /**
     * Bezeroaren hizkuntza itzultzen du.
     * 
     * @return Bezeroaren hizkuntza.
     */
    public String getHizkuntza() {
        return hizkuntza;
    }

    /**
     * Bezeroaren hizkuntza ezartzen du.
     * 
     * @param hizkuntza Ezarri behar den Bezeroaren hizkuntza.
     */
    public void setHizkuntza(String hizkuntza) {
        this.hizkuntza = hizkuntza;
    }

    /**
     * Bezeroaren erabiltzailea itzultzen du.
     * 
     * @return Bezeroaren erabiltzailea.
     */
    public String getErabiltzailea() {
        return erabiltzailea;
    }

    /**
     * Bezeroaren erabiltzailea ezartzen du.
     * 
     * @param erabiltzailea Ezarri behar den Bezeroaren erabiltzailea.
     */
    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }

    /**
     * Bezeroaren pasahitza itzultzen du.
     * 
     * @return Bezeroaren pasahitza.
     */
    public String getPasahitza() {
        return pasahitza;
    }

    /**
     * Bezeroaren pasahitza ezartzen du.
     * 
     * @param pasahitza Ezarri behar den Bezeroaren pasahitza.
     */
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

    /**
     * Bezeroaren jaiotze-data itzultzen du.
     * 
     * @return Bezeroaren jaiotze-data.
     */
    public Date getJaiotzedata() {
        return jaiotzedata;
    }

    /**
     * Bezeroaren jaiotze-data ezartzen du.
     * 
     * @param jaiotzedata Ezarri behar den Bezeroaren jaiotze-data.
     */
    public void setJaiotzedata(Date jaiotzedata) {
        this.jaiotzedata = jaiotzedata;
    }

    /**
     * Bezeroaren erregistro-data itzultzen du.
     * 
     * @return Bezeroaren erregistro-data.
     */
    public Date getErregistrodata() {
        return erregistrodata;
    }

    /**
     * Bezeroaren erregistro-data ezartzen du.
     * 
     * @param erregistrodata Ezarri behar den Bezeroaren erregistro-data.
     */
    public void setErregistrodata(Date erregistrodata) {
        this.erregistrodata = erregistrodata;
    }
    
    public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

    /**
     * Bezeroaren string errepresentazioa itzultzen du.
     * 
     * @return Bezeroaren string errepresentazioa.
     */
    @Override
    public String toString() {
        return "Bezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza
                + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", jaiotzedata=" + jaiotzedata
                + ", erregistrodata=" + erregistrodata + "]";
    }

}