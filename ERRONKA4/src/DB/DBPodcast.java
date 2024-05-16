package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Podkasten eta datu baseko operazioak kudeatzen ditu
 */
public class DBPodcast{
	
	
	/**
     * Recupera una lista de nombres de podcasters desde la base de datos. Podkasterren zerrenda bat lortzen du datu basetik
     *
     * @return Podkasterren izenen zerrenda
     */
	public static List<String> PodcasterrakDescubritu() {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT IzenArtistikoa FROM Podcasterra";
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
            System.out.println("Errorea Podcasterra ateratzean: " + e.getMessage());
        }
        return emaitza;
    }
	

	 /**
     * Podkaster baten audioen ID zerrenda bat lortzen du
     *
     * @param cboxPodcasterAukeraCbox Podkasterren ID-a
     * @return Audioen ID zerrenda
     */
	public static ArrayList<Integer> IDAudio(int cboxPodcasterAukeraCbox) {
	    ArrayList<Integer> id = new ArrayList<>();
	    try {
	        Connection connection = Konexioa.konektatu();
	        if (connection != null) {
	            String kontsulta = "SELECT IDAudio FROM  audioa join Podcast using (IDAudio) join Podcasterra using (IDPodcaster) WHERE IDPodcaster = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
	            preparedStatement.setInt(1, cboxPodcasterAukeraCbox);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                id.add(resultSet.getInt("IDAudio"));
	            }
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        }
	    } catch (SQLException e) {
	        System.out.println("Errorea IDAudioa ateratzean " + e.getMessage());
	    }
	    return id;
	}
	
	/**
     * Recupera una lista de nombres y duraciones de podcasts a partir de una lista de IDs de audios. Audioen ID-etatik podkasten
     *
     * @param iDAudio Una lista de IDs de audios.
     * @return Una lista de descripciones de podcasts, que incluyen el nombre y la duración.
     */
	 public static List<String> PodcastAtera(ArrayList<Integer> iDAudio) {
		    List<String> emaitza = new ArrayList<>();
		    try {
		        Connection connection = Konexioa.konektatu();
		        if (connection != null) {
		            String kontsulta = "SELECT Izena, Iraupena FROM Audioa WHERE IDAudio = ?";
		            PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);

		            for (Integer id : iDAudio) {
		                preparedStatement.setInt(1, id);
		                ResultSet resultSet = preparedStatement.executeQuery();
		                while (resultSet.next()) {
		                    String izena = resultSet.getString("Izena");
		                    Time iraupena = resultSet.getTime("Iraupena");

		                    long duracionSegundos = iraupena.getTime() / 1000;
		                    long minutos = duracionSegundos / 60;
		                    long segundos = duracionSegundos % 60;

		                    emaitza.add(izena + ", " + minutos + " minutu " + segundos + " segundo");
		                }
		                resultSet.close();
		            }
		            preparedStatement.close();
		            connection.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("Errorea Podcast-ak ateratzean " + e.getMessage());
		    }
		    return emaitza;
		}
	
	
    
}