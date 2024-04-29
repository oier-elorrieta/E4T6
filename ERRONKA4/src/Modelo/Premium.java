package Modelo;

import java.sql.Date;
import java.util.Objects;

public class Premium extends Bezeroa{

	protected Date iraungitzedata;
	
	public Premium(int id, String izena, String abizena, String hizkuntza, String erabiltzailea, String pasahitza,
			Date jaiotzedata, Date erregistrodata, Date iraungitzedata) {
		super(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
		// TODO Auto-generated constructor stub
		this.iraungitzedata = iraungitzedata;
	}

	public Date getIraungitzedata() {
		return iraungitzedata;
	}

	public void setIraungitzedata(Date iraungitzedata) {
		this.iraungitzedata = iraungitzedata;
	}

	@Override
	public String toString() {
		return "Premium [iraungitzedata=" + iraungitzedata + ", izena=" + izena + ", abizena=" + abizena
				+ ", hizkuntza=" + hizkuntza + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza
				+ ", jaiotzedata=" + jaiotzedata + ", erregistrodata=" + erregistrodata + ", premiummuga=" + premiummuga
				+ ", premium=" + premium + "]";
	}
	
	
	
}




