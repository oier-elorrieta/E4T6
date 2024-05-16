package DB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Artistekin egiten diren operazioak kudeatzen ditu
 */
public class DBMusikaKudeatzailea {

	
	/**
     * Artista berri bat txertatxen du datu basean
     *
     * @param IzenArtistikoa Artista berriaren izena
     * @param Ezaugarria Artistaren ezaugarriak
     * @param Deskribapena Artistaren deskribapena
     * @return Artista berriaren ID-a edo -1 txarto txertatu bada
     */
	public static int artistaSortu(String IzenArtistikoa, String Ezaugarria, String Deskribapena) {
		
	        int artistID = -1;

	        try (Connection conn  = Konexioa.konektatu()) {

	            String sql = "INSERT INTO musikaria (IzenArtistikoa, Ezaugarria, Deskribapena) VALUES (?, ?, ?)";


	            PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	            statement.setString(1, IzenArtistikoa);
	            statement.setString(2, Ezaugarria);
	            statement.setString(3, Deskribapena);

	           
	            int rowsInserted = statement.executeUpdate();

	           
	            if (rowsInserted > 0) {
	                
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
	
