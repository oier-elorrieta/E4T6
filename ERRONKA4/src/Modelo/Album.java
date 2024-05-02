
package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Album {
    protected int id;
    protected String izenburua;
    protected int urtea;
    protected String generoa;
    protected ArrayList<Album> Abestiak;
    
    /**
     * Albumaren konstruktorea.
     * 
     * @param id Albumaren identifikadorea
     * @param izenburua Albumaren izenburua
     * @param urtea Albumaren urtea
     * @param generoa Albumaren generoa
     * @param abestiak Albumaren abestiak
     */
    public Album(int id, String izenburua, int urtea, String generoa, ArrayList<Album> abestiak) {
        super();
        this.id = id;
        this.izenburua = izenburua;
        this.urtea = urtea;
        this.generoa = generoa;
        Abestiak = abestiak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzenburua() {
        return izenburua;
    }

    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }

    public int getUrtea() {
        return urtea;
    }

    public void setUrtea(int urtea) {
        this.urtea = urtea;
    }

    public String getGeneroa() {
        return generoa;
    }

    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }

    public ArrayList<Album> getAbestiak() {
        return Abestiak;
    }

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