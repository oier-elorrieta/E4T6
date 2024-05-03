package Modelo;

import java.util.ArrayList; // Import ArrayList from java.util
import java.util.Objects;

public class Podcaster extends Artista {

    protected ArrayList<Podcaster> podkasterrak;

    public Podcaster(int id, String izena, String irudia, String deskribapena, ArrayList<Podcaster> podkasterrak) {
        super(id, izena, irudia, deskribapena);
        this.podkasterrak = podkasterrak;
    }

	public ArrayList<Podcaster> getPodkasterrak() {
		return podkasterrak;
	}

	public void setPodkasterrak(ArrayList<Podcaster> podkasterrak) {
		this.podkasterrak = podkasterrak;
	}
    
    
}