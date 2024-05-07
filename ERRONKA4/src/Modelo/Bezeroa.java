
package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 * Bezeroa klaseak eratzen duen Bezeroa objektua.
 */
public class Bezeroa {
    protected int id;
    protected String izena;
    protected String abizena;
    protected String hizkuntza;
    protected String erabiltzailea;
    protected String pasahitza;
    protected Date jaiotzedata;
    protected Date erregistrodata;
    protected Date premiummuga;
    protected boolean premium;
    
    public Bezeroa(String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
			Date jaiotzedata, Date erregistrodata) {
	
		
		this.izena = izena;
		this.abizena = abizena;
		this.hizkuntza = hizkuntza;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.jaiotzedata = jaiotzedata;
		this.erregistrodata = erregistrodata;
		
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
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	public String getHizkuntza() {
		return hizkuntza;
	}
	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}
	public String getErabiltzailea() {
		return erabiltzailea;
	}
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	public Date getJaiotzedata() {
		return jaiotzedata;
	}
	public void setJaiotzedata(Date jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
	}
	public Date getErregistrodata() {
		return erregistrodata;
	}
	public void setErregistrodata(Date erregistrodata) {
		this.erregistrodata = erregistrodata;
	}
	public Date getPremiummuga() {
		return premiummuga;
	}
	public void setPremiummuga(Date premiummuga) {
		this.premiummuga = premiummuga;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}


	@Override
	public String toString() {
		return "Bezeroa [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza
				+ ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", jaiotzedata=" + jaiotzedata
				+ ", erregistrodata=" + erregistrodata + ", premiummuga=" + premiummuga + ", premium=" + premium + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(abizena, erabiltzailea, erregistrodata, hizkuntza, id, izena, jaiotzedata, pasahitza,
				premium, premiummuga);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bezeroa other = (Bezeroa) obj;
		return Objects.equals(abizena, other.abizena) && Objects.equals(erabiltzailea, other.erabiltzailea)
				&& Objects.equals(erregistrodata, other.erregistrodata) && Objects.equals(hizkuntza, other.hizkuntza)
				&& id == other.id && Objects.equals(izena, other.izena)
				&& Objects.equals(jaiotzedata, other.jaiotzedata) && Objects.equals(pasahitza, other.pasahitza)
				&& premium == other.premium && Objects.equals(premiummuga, other.premiummuga);
	}
    
    
}