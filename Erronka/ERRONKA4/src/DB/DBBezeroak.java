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
	            
	            // Establecer los valores de los parámetros
	            stmt.setString(1, Erabiltzailea);
	            stmt.setString(2, Pasahitza);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {
	                return true; // Si encuentra un usuario con estas credenciales, devuelve true
	            } else {
	                throw new SQLException("Credenciales incorrectas");
	            }
	        } catch (SQLException e) {
	            System.err.println("Error de base de datos: " + e.getMessage());
	            JOptionPane.showMessageDialog(null, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        
	        return false; // Si no encuentra un usuario con estas credenciales, devuelve false
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
	    
	    public static String getDataGaur() {
	        LocalDate dataGaur = LocalDate.now();
	        
	        //Data Stringera aldatzen du
	        String sdataGaur = dataGaur.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	           
	        return sdataGaur;
	   }
	    
	    public static void premium(Bezeroa nb) {
	    	
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

	        }
	    }
	    
	    public static List<String> MusicaDescubritu() {
	        List<String> emaitza = new ArrayList<>();

	        try {
	            Connection connection = konektatu();

	            if (connection != null) {
	                String kontsulta = "SELECT * FROM musikaria";

	                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);

	                ResultSet resultSet = preparedStatement.executeQuery();

	                // Procesar los resultados de la consulta y agregarlos al ArrayList
	                while (resultSet.next()) {
	                    // Suponiendo que la columna que deseas obtener se llama 'nombre_columna'
	                    emaitza.add(resultSet.getString("IzenArtistikoa"));
	                }

	                resultSet.close();
	                preparedStatement.close();
	                connection.close();
	            }

	        } catch (SQLException e) {
	            // Manejo de excepciones
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

	                // Procesar los resultados de la consulta y agregarlos al ArrayList
	                while (resultSet.next()) {
	                    // Suponiendo que la columna que deseas obtener se llama 'nombre_columna'
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
	        
	    
	   
	

