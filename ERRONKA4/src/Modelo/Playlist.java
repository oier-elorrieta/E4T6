package Modelo;

/**
 * Playlist klaseak eratzen duen Playlista objektua.
 */
public class Playlist {
    protected int id;
    protected String izenburua;
    protected String sorreradata;
    
    /**
     * Playlista objetua sortzen du ID, izenburu eta sortze-data zehaztuak erabiliz.
     * 
     * @param id Playlistaren identifikazioa.
     * @param izenburua Playlistaren izenburua.
     * @param sorreradata Playlistaren sortze-data.
     */
    public Playlist(int id, String izenburua, String sorreradata) {
        this.id = id;
        this.izenburua = izenburua;
        this.sorreradata = sorreradata;
    }

    /**
     * Playlista identifikazioa itzultzen du.
     * 
     * @return Playlist identifikazioa.
     */
    public int getId() {
        return id;
    }

    /**
     * Playlista identifikazioa ezartzen du.
     * 
     * @param id Ezarri behar den Playlista identifikazioa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Playlista izenburua itzultzen du.
     * 
     * @return Playlista izenburua.
     */
    public String getIzenburua() {
        return izenburua;
    }

    /**
     * Playlista izenburua ezartzen du.
     * 
     * @param izenburua Ezarri behar den Playlista izenburua.
     */
    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }

    /**
     * Playlista sortze-data itzultzen du.
     * 
     * @return Playlista sortze-data.
     */
    public String getSorreradata() {
        return sorreradata;
    }

    /**
     * Playlista sortze-data ezartzen du.
     * 
     * @param sorreradata Ezarri behar den Playlista sortze-data.
     */
    public void setSorreradata(String sorreradata) {
        this.sorreradata = sorreradata;
    }

    /**
     * Playlista-aren string errepresentazioa itzultzen du.
     * 
     * @return Playlista-aren string errepresentazioa.
     */
    @Override
    public String toString() {
        return "Playlist [id=" + id + ", izenburua=" + izenburua + ", sorreradata=" + sorreradata + "]";
    }

}
