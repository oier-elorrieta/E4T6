package Modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Playlist klaseak eratzen duen Playlista objektua.
 */
public class Playlist {
    protected int id;
    protected String izenburua;
    protected String sorreradata;
	protected ArrayList<Album> Abestiak;
	
	public Playlist(int id, String izenburua, String sorreradata, ArrayList<Album> abestiak) {
		this.id = id;
		this.izenburua = izenburua;
		this.sorreradata = sorreradata;
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

	public String getSorreradata() {
		return sorreradata;
	}

	public void setSorreradata(String sorreradata) {
		this.sorreradata = sorreradata;
	}

	public ArrayList<Album> getAbestiak() {
		return Abestiak;
	}

	public void setAbestiak(ArrayList<Album> abestiak) {
		Abestiak = abestiak;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", izenburua=" + izenburua + ", sorreradata=" + sorreradata + ", Abestiak="
				+ Abestiak + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Abestiak, id, izenburua, sorreradata);
	}

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
