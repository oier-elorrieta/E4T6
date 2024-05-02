package Modelo;

import java.util.Objects;

public class Podcast {
	protected String kolaboratzaileak;

	public Podcast(String kolaboratzaileak) {
	 
		this.kolaboratzaileak = kolaboratzaileak;
	}

	public String getKolaboratzaileak() {
		return kolaboratzaileak;
	}

	public void setKolaboratzaileak(String kolaboratzaileak) {
		this.kolaboratzaileak = kolaboratzaileak;
	}

	@Override
	public String toString() {
		return "Podcast [kolaboratzaileak=" + kolaboratzaileak + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(kolaboratzaileak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Podcast other = (Podcast) obj;
		return Objects.equals(kolaboratzaileak, other.kolaboratzaileak);
	}
	
	
	
}
