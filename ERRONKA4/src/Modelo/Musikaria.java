package Modelo;

import java.util.ArrayList;

public class Musikaria extends Artista {
    
    protected ArrayList<Musikaria> album;
    protected Ezaugarriak ezaugarriak;
    
    public enum Ezaugarriak {
        BAKALRRIA,
        TALDEA
    }

    public Musikaria(int id, String izena, String irudia, String deskribapena, ArrayList<Musikaria> album, Ezaugarriak ezaugarriak) {
        super(id, izena, irudia, deskribapena);
        this.album = album;
        this.ezaugarriak = ezaugarriak;
    }

	public ArrayList<Musikaria> getAlbum() {
		return album;
	}

	public void setAlbum(ArrayList<Musikaria> album) {
		this.album = album;
	}

	public Ezaugarriak getEzaugarriak() {
		return ezaugarriak;
	}

	public void setEzaugarriak(Ezaugarriak ezaugarriak) {
		this.ezaugarriak = ezaugarriak;
	}
    
    

   
}