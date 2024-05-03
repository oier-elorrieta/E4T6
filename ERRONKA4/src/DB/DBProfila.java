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
    
    public static String bezInfTxertatu(String erabiltzailea) {
        String erabiltzaileIzena = null;
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("SELECT Erabiltzailea FROM bezeroa WHERE Erabiltzailea = " + erabiltzailea)) {
            stmt.setString(1, erabiltzailea);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                erabiltzaileIzena = rs.getString("Erabiltzailea");
            } else {
                throw new SQLException("Erabiltzailea ez da aurkitu");
            }
        } catch (SQLException e) {
            System.err.println("Datu-basearen errorea: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        return erabiltzaileIzena;
    }
    
    

}
