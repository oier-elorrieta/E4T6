package Modelo;

import java.util.Objects;

/**
 * Artista klaseak eratzen duen Artista objektua.
 */
public class Artista {
    protected int id;
    protected String izena;
    protected String irudia;
    protected String deskribapena;
	public Artista(int id, String izena, String irudia, String deskribapena) {
		super();
		this.id = id;
		this.izena = izena;
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getIrudia() {
		return irudia;
	}
	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	@Override
	public String toString() {
		return "Artista [id=" + id + ", izena=" + izena + ", irudia=" + irudia + ", deskribapena=" + deskribapena + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deskribapena, id, irudia, izena);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(deskribapena, other.deskribapena) && id == other.id
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izena, other.izena);
	}
    
   

}