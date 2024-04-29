package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Modelo.Bezeroa;

public class DBErregistroa {
	 public static void BezeroaGorde(Bezeroa nb) {
	    	
		    try {

		        Connection connection = Konexioa.konektatu();

		        if (connection != null) {	
		        	
		        	
		       String kontsulta = "INSERT INTO bezeroa (Izena, Abizena, Hizkuntza, Erabiltzailea, Pasahitza, Jaiotze_data, Erregistro_data) VALUES (?, ?, ?, ?, ?, ?, ?)";

		  
		            PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);

		            preparedStatement.setString(1, nb.getIzena());
		            preparedStatement.setString(2, nb.getAbizena());
		            preparedStatement.setString(3, nb.getHizkuntza());
		            preparedStatement.setString(4, nb.getErabiltzailea());		            
		            preparedStatement.setString(5, nb.getPasahitza());		         
		            preparedStatement.setDate(6, new java.sql.Date(nb.getJaiotzedata().getTime()));		           
		            preparedStatement.setDate(7, new java.sql.Date(nb.getErregistrodata().getTime()));
		            
		            int eragindakoErrenkadak = preparedStatement.executeUpdate();
		            
		            if (eragindakoErrenkadak > 0) {

		                System.out.println("Bezeroa zuzen gehitu da datu-basera.");

		            } else {

		                System.out.println("Errorea: Ezin izan da bezeroa datu-basera gehitu.");
		            }

		            preparedStatement.close();

		            connection.close();

		        }

		    } catch (SQLException e) {

		        System.out.println("Errorea bezeroa datu-baseari eranstean: " + e.getMessage());

		    }} 
		    
		    public static int idBezeroLortu(Bezeroa nb) {
	    	    int idBezeroa = -1;
	    	    try (Connection conn = Konexioa.konektatu();
	    	         PreparedStatement stmt = conn.prepareStatement("SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = ?")) {

	    	        // Establecer los valores de los parámetros
	    	        stmt.setString(1, nb.getErabiltzailea());

	    	        ResultSet rs = stmt.executeQuery();

	    	        if (rs.next()) {
	    	            idBezeroa = rs.getInt("IDBezeroa"); 
	    	        } else {
	    	            throw new SQLException("Credenciales incorrectas");
	    	        }
	    	    } catch (SQLException e) {
	    	        System.err.println("Error de base de datos: " + e.getMessage());
	    	        JOptionPane.showMessageDialog(null, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    	    }

	    	    return idBezeroa;
	    	}
	    
		    
		    public static String getDataGaur() {
		        LocalDate dataGaur = LocalDate.now();
		        
		        //Data Stringera aldatzen du
		        String sdataGaur = dataGaur.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
		           
		        return sdataGaur;
		   }
		    
		    public static void PremiumDataGorde(int idBezeroa, String data) {
		    	
		        try {

		            Connection connection = Konexioa.konektatu();

		            if (connection != null) {	
		            
		                String kontsulta = "INSERT INTO Premium (IDBezeroa, Iraungitze_data) VALUES (?, ?)";
		            
		      
		                PreparedStatement PreparedStatement = connection.prepareStatement(kontsulta);

		                PreparedStatement.setInt(1, idBezeroa);
		                PreparedStatement.setString(2, data);

		            
		                int eragindakoErrenkadak = PreparedStatement.executeUpdate();
		                
		                if (eragindakoErrenkadak > 0) {

		                    System.out.println("Data zuzen txertatu da");

		                } else {

		                    System.out.println("Errorea: Ezin izan da bezeroa datu-basera gehitu.");
		                }

		                PreparedStatement.close();

		                connection.close();

		            }

		        } catch (SQLException e) {

		            System.out.println("Errorea bezeroa datu-baseari eranstean: " + e.getMessage());

		        }
		    }
}
