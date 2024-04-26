package Modelo;

import java.util.Objects;

public class Abestia extends Audio{
	
	public Abestia(int id, String izena, String erreprodukzioak, double iraupena) {
		super(id, izena, erreprodukzioak, iraupena);
		// TODO Auto-generated constructor stub
	}

	protected String ezaugarria;

	

	public String getEzaugarria() {
		return ezaugarria;
	}

	public void setEzaugarria(String ezaugarria) {
		this.ezaugarria = ezaugarria;
	}

	@Override
	public String toString() {
		return "Abestia [ezaugarria=" + ezaugarria + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ezaugarria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abestia other = (Abestia) obj;
		return Objects.equals(ezaugarria, other.ezaugarria);
	}
	
	
}
