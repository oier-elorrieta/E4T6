package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Album klaseak albumak kudeatzeko egitura eskaintzen du.
 */
public class Album {
    protected int id;
    protected String izenburua;
    protected int urtea;
    protected String generoa;
    protected ArrayList<Album> Abestiak;

    /**
     * Album klasearen eraikitzailea.
     * @param id Albumaren IDa.
     * @param izenburua Albumaren izenburua.
     * @param urtea Albumaren urtea.
     * @param generoa Albumaren generoa.
     * @param abestiak Albumaren abestiak.
     */
    public Album(int id, String izenburua, int urtea, String generoa, ArrayList<Album> abestiak) {
        super();
        this.id = id;
        this.izenburua = izenburua;
        this.urtea = urtea;
        this.generoa = generoa;
        Abestiak = abestiak;
    }

    /**
     * IDaren getter metodoa.
     * @return Albumaren IDa.
     */
    public int getId() {
        return id;
    }

    /**
     * IDaren setter metodoa.
     * @param id Albumaren IDa.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Izenburuaren getter metodoa.
     * @return Albumaren izenburua.
     */
    public String getIzenburua() {
        return izenburua;
    }

    /**
     * Izenburuaren setter metodoa.
     * @param izenburua Albumaren izenburua.
     */
    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }

    /**
     * Urtearen getter metodoa.
     * @return Albumaren urtea.
     */
    public int getUrtea() {
        return urtea;
    }

    /**
     * Urtearen setter metodoa.
     * @param urtea Albumaren urtea.
     */
    public void setUrtea(int urtea) {
        this.urtea = urtea;
    }

    /**
     * Generoaren getter metodoa.
     * @return Albumaren generoa.
     */
    public String getGeneroa() {
        return generoa;
    }

    /**
     * Generoaren setter metodoa.
     * @param generoa Albumaren generoa.
     */
    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }

    /**
     * Abestiak ArrayList-aren getter metodoa.
     * @return Albumaren abestiak.
     */
    public ArrayList<Album> getAbestiak() {
        return Abestiak;
    }

    /**
     * Abestiak ArrayList-aren setter metodoa.
     * @param abestiak Albumaren abestiak.
     */
    public void setAbestiak(ArrayList<Album> abestiak) {
        Abestiak = abestiak;
    }

    @Override
    public String toString() {
        return "Album [id=" + id + ", izenburua=" + izenburua + ", urtea=" + urtea + ", generoa=" + generoa
                + ", Abestiak=" + Abestiak + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(Abestiak, generoa, id, izenburua, urtea);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Album other = (Album) obj;
        return Objects.equals(Abestiak, other.Abestiak) && Objects.equals(generoa, other.generoa) && id == other.id
                && Objects.equals(izenburua, other.izenburua) && urtea == other.urtea;
    }
}
