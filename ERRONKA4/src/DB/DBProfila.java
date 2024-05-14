package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.Bezeroa;

public class DBProfila {
	public static Bezeroa bezeroaLortu(String erabiltzailea) {
	    Bezeroa bezeroa = null;
	    try (Connection conn = Konexioa.konektatu();
	         PreparedStatement stmt = conn.prepareStatement("SELECT Izena, Abizena, Erabiltzailea, Hizkuntza, Pasahitza, Jaiotze_data, Erregistro_data FROM bezeroa WHERE Erabiltzailea = ?")) {
	        stmt.setString(1, erabiltzailea);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            String izena = rs.getString("Izena");
	            String abizena = rs.getString("Abizena");
	            String user = rs.getString("Erabiltzailea"); 
	            String hizkuntza = rs.getString("Hizkuntza");
	            String pasahitza = rs.getString("Pasahitza");
	            java.sql.Date jaiotzeData = rs.getDate("Jaiotze_data");
	            java.sql.Date erregistroData = rs.getDate("Erregistro_data");
	            

	            bezeroa = new Bezeroa(izena, abizena, hizkuntza, user, pasahitza, jaiotzeData, erregistroData);
	         
	        } else {
	            throw new SQLException("Erabiltzailea ez da aurkitu");
	        }
	    } catch (SQLException e) {
	        System.err.println("Datu-basearen errorea: " + e.getMessage());
	        JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
	    }
	    return bezeroa;
	}
    
    
	public static void aktualizatuBezeroa(Bezeroa bezeroa, String lehenengoBezeroa) {
	    // Egiaztatu eremua beteta dagoela
	    if (bezeroa.getIzena().isEmpty() || bezeroa.getAbizena().isEmpty() || bezeroa.getErabiltzailea().isEmpty() ||
	        bezeroa.getPasahitza().isEmpty() || bezeroa.getJaiotzedata() == null || bezeroa.getErregistrodata() == null) {
	        JOptionPane.showMessageDialog(null, "Mesedez, bete eremua beti bete.", "Eremuak bete behar dira", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    try (Connection conn = Konexioa.konektatu();
	         PreparedStatement stmt = conn.prepareStatement("UPDATE bezeroa SET Izena = ?, Abizena = ?, Hizkuntza = ?, Pasahitza = ?, Jaiotze_data = ?, Erregistro_data = ? WHERE Erabiltzailea = " + lehenengoBezeroa)) {
	        
	        stmt.setString(1, bezeroa.getIzena());
	        stmt.setString(2, bezeroa.getAbizena());
	        stmt.setString(3, bezeroa.getHizkuntza());       
	        stmt.setString(4, bezeroa.getPasahitza());
	        stmt.setDate(5, bezeroa.getJaiotzedata());
	        stmt.setDate(6, bezeroa.getErregistrodata());
	        stmt.setString(7, bezeroa.getErabiltzailea());

	        int erregistroakAldatutakoak = stmt.executeUpdate();
	        if (erregistroakAldatutakoak == 0) {
	            throw new SQLException("Erabiltzaile izena ezin da aldatu");
	        }
	    } catch (SQLException e) {
	        System.err.println("Datu-basearen errorea: " + e.getMessage());
	        JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static boolean bezKomparaketa(Bezeroa bez1, Bezeroa bez2) {
		boolean da = false;
		
		if(bez1.equals(bez2)){
			da =  true;
		}
		
		return da;
	}
}
