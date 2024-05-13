package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DBArtista{
	
	public static List<String> MusikariakDescubritu() {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
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
            System.out.println("Errorea musikariak ateratzean: " + e.getMessage());
        }
        return emaitza;
	}
    
    public static List<String> MusikariarenAlbumak(int cboxArtista) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Izenburua, Eguna FROM album where IDMusikaria = " + cboxArtista ;
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
            System.out.println("Errorea albumak ateratzean " + e.getMessage());
        }
        return emaitza;
    }
    
    public static List<String> MusikariarenInformazioa(int cboxArtista) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Deskribapena FROM musikaria where IDMusikaria = " + cboxArtista;
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    emaitza.add(resultSet.getString("Deskribapena"));
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea musikariak ateratzean " + e.getMessage());
        }
        return emaitza;
    }

  
    
    public static int IDAudio(int albumaukeraCbox) {
        int rowCount = 0; 
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT IDAudio FROM abestia where IDAlbum = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setInt(1, albumaukeraCbox); 
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    rowCount++; 
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea IDAudioa ateratzean " + e.getMessage());
        }
        return rowCount;
    }
    
    public static List<String> AbestiakAtera(int IDAlbum) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Izena, Iraupena FROM audioa JOIN abestia USING (IDAudio) JOIN album USING (IDAlbum) WHERE IDAlbum = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setInt(1, IDAlbum);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String izena = resultSet.getString("Izena");
                    String iraupenaStr = resultSet.getString("Iraupena");

                    // Dividimos el tiempo en partes: horas, minutos y segundos
                    String[] partes = iraupenaStr.split(":");
                    int horas = Integer.parseInt(partes[0]);
                    int minutos = Integer.parseInt(partes[1]);
                    int segundos = Integer.parseInt(partes[2]);

                    // Convertimos todo a segundos
                    int iraupenaSegundos = horas * 3600 + minutos * 60 + segundos;

                    // Calculamos los minutos y segundos
                    minutos = iraupenaSegundos / 60;
                    segundos = iraupenaSegundos % 60;

                    // Formateamos el tiempo en minutos:segundos
                    String tiempoFormateado = String.format("%02d:%02d", minutos, segundos);

                    // Agregamos el nombre de la canción y el tiempo formateado a la lista de resultados
                    emaitza.add(izena + " - " + tiempoFormateado);
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea abestiak ateratzean " + e.getMessage());
        }
        return emaitza;
    }


    
    public static List<String> albumarenInformazioa(int idAlbum) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Eguna, Generoa FROM musikaria where IDMusikaria = " + idAlbum ;
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    emaitza.add(resultSet.getString("Deskribapena"));
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea musikariak ateratzean " + e.getMessage());
        }
        return emaitza;
    }
    
    
    
}