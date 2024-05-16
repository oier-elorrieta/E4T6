package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Podcaster klaseak eratzen duen Podcaster objektua.
 */
public class Podcaster extends Artista {

    /** Podcaster-en podkasterrak. */
    protected ArrayList<Podcaster> podkasterrak;

    /**
     * Podcasteraren eraikitzailea.
     *
     * @param id Podcasteraren identifikatzailea.
     * @param izena Podcasteraren izena.
     * @param irudia Podcasteraren irudia.
     * @param deskribapena Podcasteraren deskribapena.
     * @param podkasterrak Podcaster-en podkasterrak.
     */
    public Podcaster(int id, String izena, String irudia, String deskribapena, ArrayList<Podcaster> podkasterrak) {
        super(id, izena, irudia, deskribapena);
        this.podkasterrak = podkasterrak;
    }

    /**
     * Podcaster-en podkasterrak itzultzen ditu.
     *
     * @return Podcaster-en podkasterrak.
     */
    public ArrayList<Podcaster> getPodkasterrak() {
        return podkasterrak;
    }

    /**
     * Podcaster-en podkasterrak ezartzen ditu.
     *
     * @param podkasterrak Ezarri nahi diren Podcaster-en podkasterrak.
     */
    public void setPodkasterrak(ArrayList<Podcaster> podkasterrak) {
        this.podkasterrak = podkasterrak;
    }
}
