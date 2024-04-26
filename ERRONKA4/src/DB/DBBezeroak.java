package DB;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	import Modelo.Bezeroa;

	/**
	 * Erabilgarriak klaseak datu-basearekin konexioa ezartzeko eta erabiltzaile autentifikazioa egiaztatzeko metodoak biltzen ditu.
	 */
	public class DBBezeroak {

	    private static final String URL = "jdbc:mysql://127.0.0.1:3307/db_spoty";
	    private static final String USER = "root";
	    private static final String PASS = "";
	    
	    private static Connection konexioa;

	    /**
	     * Datu-basearekin konexioa sortu.
	     * 
	     * @return Konexio objektua.
	     */
	    public static Connection konektatu() {
	        try {
	            // Konexioa sortu, oraindik ez badago
	            if (konexioa == null || konexioa.isClosed()) {
	                konexioa = DriverManager.getConnection(URL, USER, PASS);
	            }
	        } catch (SQLException e) {
	            System.out.println("Errorea datu-basearekin konexioa egiten: " + e.getMessage());
	        }
	        return konexioa;
	    }
	    

	    /**
	     * Erabiltzaile autentifikazioa egiaztatu.
	     * 
	     * @param Erabiltzailea Erabiltzaile izena.
	     * @param Pasahitza Pasahitza.
	     * @return Autentifikazioa egiaztatu den edo ez.
	     */
	    public static boolean isLoginOk(String Erabiltzailea, String Pasahitza) {
	        try(Connection conn = konektatu();
	             PreparedStatement stmt = conn.prepareStatement("SELECT Erabiltzailea, Pasahitza FROM bezeroa WHERE Erabiltzailea = ? AND Pasahitza = ?")) {
	            
	           
	            stmt.setString(1, Erabiltzailea);
	            stmt.setString(2, Pasahitza);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                return true; 
	            } else {
	                throw new SQLException("Credenciales incorrectas");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error de base de datos: " + e.getMessage());
	            JOptionPane.showMessageDialog(null, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        return false; 
	    }
	    	
	    public static void BezeroaGorde(Bezeroa nb) {
	    	
	    try {

	        Connection connection = konektatu();

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
    	    try (Connection conn = konektatu();
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

	            Connection connection = konektatu();

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
	    
	    public static List<String> MusikaDescubritu() {
	        List<String> emaitza = new ArrayList<>();

	        try {
	            Connection connection = konektatu();

	            if (connection != null) {
	                String kontsulta = "SELECT * FROM musikaria";

	                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);

	                ResultSet resultSet = preparedStatement.executeQuery();

	              
	                while (resultSet.next()) {
	                   
	                    emaitza.add(resultSet.getString("IzenArtistikoa"));
	                }

	                resultSet.close();
	                preparedStatement.close();
	                connection.close();
	            }

	        } catch (SQLException e) {
	           
	            System.out.println("Errorea bezeroa datu-baseari eranstean: " + e.getMessage());
	        }

	        return emaitza;
	    }
	    
	    public static List<String> MusikariarenAlbumak(int comboboxaukera) {
	        List<String> emaitza = new ArrayList<>();

	        try {
	            Connection connection = konektatu();

	            if (connection != null) {
	                String kontsulta = "SELECT Izenburua, Eguna FROM album where IDMusikaria = " + comboboxaukera ;

	                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);

	                ResultSet resultSet = preparedStatement.executeQuery();

	               
	                while (resultSet.next()) {
	                 
	                    emaitza.add(resultSet.getString("Izenburua"));
	                    
	                }

	                resultSet.close();
	                preparedStatement.close();
	                connection.close();
	            }

	        } catch (SQLException e) {
	           
	            System.out.println("Errorea bezeroa datu-baseari eranstean: " + e.getMessage());
	        }

	        return emaitza;
	    }
	    
	    
	       
	            
	    }
	        
	    
	   
	

