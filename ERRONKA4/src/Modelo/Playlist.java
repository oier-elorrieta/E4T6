package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Playlist klaseak eratzen duen Playlista objektua.
 */
public class Playlist {
    
    /** Playlisten identifikazioa. */
    protected int id;
    
    /** Playlisten izenburua. */
    protected String izenburua;
    
    /** Playlisten sortze data. */
    protected String sorreradata;
    
    /** Playlisten abestiak. */
    protected ArrayList<Album> Abestiak;
	
    /**
     * Playlistaren eraikitzailea.
     *
     * @param id Playlisten identifikazioa.
     * @param izenburua Playlisten izenburua.
     * @param sorreradata Playlisten sortze data.
     * @param abestiak Playlisten abestiak.
     */
    public Playlist(int id, String izenburua, String sorreradata, ArrayList<Album> abestiak) {
        this.id = id;
        this.izenburua = izenburua;
        this.sorreradata = sorreradata;
        Abestiak = abestiak;
    }

    /**
     * Playlisten identifikazioa itzultzen du.
     *
     * @return Playlisten identifikazioa.
     */
    public int getId() {
        return id;
    }

    /**
     * Playlisten identifikazioa ezartzen du.
     *
     * @param id Ezarri nahi den Playlisten identifikazioa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Playlisten izenburua itzultzen du.
     *
     * @return Playlisten izenburua.
     */
    public String getIzenburua() {
        return izenburua;
    }

    /**
     * Playlisten izenburua ezartzen du.
     *
     * @param izenburua Ezarri nahi den Playlisten izenburua.
     */
    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }

    /**
     * Playlisten sortze data itzultzen du.
     *
     * @return Playlisten sortze data.
     */
    public String getSorreradata() {
        return sorreradata;
    }

    /**
     * Playlisten sortze data ezartzen du.
     *
     * @param sorreradata Ezarri nahi den Playlisten sortze data.
     */
    public void setSorreradata(String sorreradata) {
        this.sorreradata = sorreradata;
    }

    /**
     * Playlisten abestiak itzultzen ditu.
     *
     * @return Playlisten abestiak.
     */
    public ArrayList<Album> getAbestiak() {
        return Abestiak;
    }

    /**
     * Playlisten abestiak ezartzen ditu.
     *
     * @param abestiak Ezarri nahi den Playlisten abestiak.
     */
    public void setAbestiak(ArrayList<Album> abestiak) {
        Abestiak = abestiak;
    }

    /**
     * Playlistenaren String errepresentazioa itzultzen du.
     *
     * @return Playlistenaren String errepresentazioa.
     */
    @Override
    public String toString() {
        return "Playlist [id=" + id + ", izenburua=" + izenburua + ", sorreradata=" + sorreradata + ", Abestiak=" + Abestiak + "]";
    }

    /**
     * Playlistenaren kodea itzultzen du.
     *
     * @return Playlistenaren kodea.
     */
    @Override
    public int hashCode() {
        return Objects.hash(Abestiak, id, izenburua, sorreradata);
    }

    /**
     * Bi Playlisten arteko berdintasuna konprobatzen du.
     *
     * @param obj Konparatzeko Playlista.
     * @return Bi Playlisten arteko berdintasuna badago true, bestela false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        return Objects.equals(Abestiak, other.Abestiak) && id == other.id && Objects.equals(izenburua, other.izenburua)
                && Objects.equals(sorreradata, other.sorreradata);
    }
}
