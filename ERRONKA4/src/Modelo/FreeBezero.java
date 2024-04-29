package Modelo;

import java.sql.Date;

public class FreeBezero extends Bezeroa {

	public FreeBezero(String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
			Date jaiotzedata, Date erregistrodata) {
		super(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FreeBezero [id=" + id + ", izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza
				+ ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", jaiotzedata=" + jaiotzedata
				+ ", erregistrodata=" + erregistrodata + ", premiummuga=" + premiummuga + ", premium=" + premium
				+ ", getId()=" + getId() + ", getIzena()=" + getIzena() + ", getAbizena()=" + getAbizena()
				+ ", getHizkuntza()=" + getHizkuntza() + ", getErabiltzailea()=" + getErabiltzailea()
				+ ", getPasahitza()=" + getPasahitza() + ", getJaiotzedata()=" + getJaiotzedata()
				+ ", getErregistrodata()=" + getErregistrodata() + ", isPremium()=" + isPremium() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
