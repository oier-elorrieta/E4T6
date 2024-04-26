package Modelo;

import java.sql.Date;
import java.util.Objects;

public class Premium {
	protected Date iraungitzedata;

	public Premium(Date iraungitzedata) {
		
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
		return "Premium [iraungitzedata=" + iraungitzedata + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(iraungitzedata);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premium other = (Premium) obj;
		return Objects.equals(iraungitzedata, other.iraungitzedata);
	}
	
	
}
