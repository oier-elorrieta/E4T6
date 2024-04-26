package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Musikaria {
	 protected ArrayList<Musikaria> Album;
	 protected Ezaugarriak ezaugarriak;
	 protected enum Ezaugarriak {
	        bakarlaria,
	        taldea
	  }
	public Musikaria(ArrayList<Musikaria> album, Ezaugarriak ezaugarriak) {
		super();
		Album = album;
		this.ezaugarriak = ezaugarriak;
	}
	public ArrayList<Musikaria> getAlbum() {
		return Album;
	}
	public void setAlbum(ArrayList<Musikaria> album) {
		Album = album;
	}
	public Ezaugarriak getEzaugarriak() {
		return ezaugarriak;
	}
	public void setEzaugarriak(Ezaugarriak ezaugarriak) {
		this.ezaugarriak = ezaugarriak;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Album, ezaugarriak);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musikaria other = (Musikaria) obj;
		return Objects.equals(Album, other.Album) && ezaugarriak == other.ezaugarriak;
	}
	 
	 
}
