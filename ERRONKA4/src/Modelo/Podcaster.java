package Modelo;

import java.util.ArrayList; // Import ArrayList from java.util
import java.util.Objects;

public class Podcaster {

    protected ArrayList<Podcaster> podcasterrak;

	public Podcaster(ArrayList<Podcaster> podcasterrak) {

		this.podcasterrak = podcasterrak;
	}

	public ArrayList<Podcaster> getPodcasterrak() {
		return podcasterrak;
	}

	public void setPodcasterrak(ArrayList<Podcaster> podcasterrak) {
		this.podcasterrak = podcasterrak;
	}

	@Override
	public String toString() {
		return "Podcaster [podcasterrak=" + podcasterrak + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(podcasterrak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Podcaster other = (Podcaster) obj;
		return Objects.equals(podcasterrak, other.podcasterrak);
	}
    
	
}
