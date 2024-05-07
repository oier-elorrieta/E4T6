package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DBPodcast{
	
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
	
	public static int PodcasterID(String Podcasterra) {
	    int id = -1;
	  
	    try {
	        Connection connection = Konexioa.konektatu();
	        if (connection != null) {
	            String kontsulta = "SELECT IDPodcaster FROM Podcasterra WHERE IzenArtistikoa = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
	            preparedStatement.setString(1, Podcasterra); 
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                id = resultSet.getInt("IDPodcaster"); 
	            }
	            resultSet.close();
	            preparedStatement.close();
	            connection.close();
	        }
	    } catch (SQLException e) {
	        System.out.println("Errorea Podcasterraren ID-a ateratzean: " + e.getMessage());
	    }
	    return id;
	}
	
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