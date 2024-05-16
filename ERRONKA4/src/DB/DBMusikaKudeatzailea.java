package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBMusikaKudeatzailea {

	public static int artistaSortu(String IzenArtistikoa, String Ezaugarria, String Deskribapena) {
		
	        int artistID = -1;

	        try (Connection conn  = Konexioa.konektatu()) {
	            // Consulta SQL para insertar un nuevo artista en la tabla musikaria
	            String sql = "INSERT INTO musikaria (IzenArtistikoa, Ezaugarria, Deskribapena) VALUES (?, ?, ?)";

	            // Preparamos la declaración SQL con parámetros
	            PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	            statement.setString(1, IzenArtistikoa);
	            statement.setString(2, Ezaugarria);
	            statement.setString(3, Deskribapena);

	            // Ejecutamos la inserción
	            int rowsInserted = statement.executeUpdate();

	            // Obtenemos el ID del nuevo artista insertado
	            if (rowsInserted > 0) {
	                // Obtenemos las claves generadas automáticamente
	                var rs = statement.getGeneratedKeys();
	                if (rs.next()) {
	                    artistID = rs.getInt(1);
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return artistID;
	    }

	   
	}
	
