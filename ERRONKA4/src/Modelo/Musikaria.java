package Modelo;

import java.util.ArrayList;
/**
 * Klase hau musika artista bat errepresentatzen du, bakarlari edo talde izan daitekeena, albumen informazioa eta ezaugarriak ditu.
 */
public class Musikaria extends Artista {
	
	/** Artistaaren albumen zerrenda. */
    protected ArrayList<Musikaria> album;
    
    /** Artistaaren ezaugarriak definitzen dituen enum-eko laburpena, bakarlaria edo taldea izan daitezkeena. */
    protected Ezaugarriak ezaugarriak;
    
    /**
     * Artistaaren ezaugarriak definitzen dituen enum-a, bakarlaria edo taldea izan daitezkeena.
     */
    public enum Ezaugarriak {
        BAKALRRIA,
        TALDEA
    }

    
    /**
     * Musikaria klasearen eraikitzailea.
     *
     * @param id Artistaren ID-a.
     * @param izena Artistaren izena.
     * @param irudia Artista irudia.
     * @param deskribapena Artista deskribapena.
     * @param album Artista albumen zerrenda.
     * @param ezaugarriak Artista ezaugarriak.
     */
    public Musikaria(int id, String izena, String irudia, String deskribapena, ArrayList<Musikaria> album, Ezaugarriak ezaugarriak) {
        super(id, izena, irudia, deskribapena);
        this.album = album;
        this.ezaugarriak = ezaugarriak;
    }

    
    /**
     * Artistaaren albumen zerrenda itzultzen du.
     *
     * @return Artistaaren albumen zerrenda.
     */
	public ArrayList<Musikaria> getAlbum() {
		return album;
	}

	
	/**
     * Artistaaren albumen zerrenda ezartzen du.
     *
     * @param album Ezarri nahi den albumen zerrenda.
     */
	public void setAlbum(ArrayList<Musikaria> album) {
		this.album = album;
	}

	
	/**
     * Artistaaren ezaugarriak itzultzen ditu.
     *
     * @return Artistaaren ezaugarriak.
     */
	public Ezaugarriak getEzaugarriak() {
		return ezaugarriak;
	}

	/**
     * Artistaaren ezaugarriak ezartzen ditu.
     *
     * @param ezaugarriak Ezarri nahi diren ezaugarriak.
     */
	public void setEzaugarriak(Ezaugarriak ezaugarriak) {
		this.ezaugarriak = ezaugarriak;
	}
    
    

   
}