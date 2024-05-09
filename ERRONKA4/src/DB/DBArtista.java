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
	
	public static List<String> MusikaDescubritu() {
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
    
    public static List<String> MusikariarenAlbumak(int comboboxaukera) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
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
            System.out.println("Errorea albumak ateratzean " + e.getMessage());
        }
        return emaitza;
    }
    
    public static List<String> MusikariarenInformazioa(int comboboxaukera) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Deskribapena FROM musikaria where IDMusikaria = " + comboboxaukera ;
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

    public static List<byte[]> MusikariarenArgazkia(int comboboxaukera) {
        List<byte[]> emaitza = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT MusikIrudia FROM musikaria WHERE IDMusikaria = ?";
                preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setInt(1, comboboxaukera);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String base64Image = resultSet.getString("MusikIrudia");
                    byte[] imageData = Base64.getDecoder().decode(base64Image);
                    emaitza.add(imageData);
                }
            }
        } catch (SQLException e) {
            System.out.println("Errorea albumak ateratzean: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Errorea recursoak itxi aldera: " + e.getMessage());
            }
        }

        return emaitza;
    }
    
    public static void kargatuArgazkia(int comboboxaukera, JLabel lblArgazkia) {
        List<byte[]> emaitza = MusikariarenArgazkia(comboboxaukera);
        if (!emaitza.isEmpty()) {
            byte[] imageData = emaitza.get(0); 
            ImageIcon imageIcon = new ImageIcon(imageData);
            lblArgazkia.setIcon(imageIcon);
        } else {
           
            lblArgazkia.setIcon(null); 
            lblArgazkia.setText("Ez da argazkirik aurkitu");
        }
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
    
    
    public static List<String> AbestiakAtera(int IDAudio) {
        List<String> emaitza = new ArrayList<>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Izena, Iraupena FROM audioa WHERE IDAudio = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setInt(1, IDAudio);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String izena = resultSet.getString("Izena");
                    Time iraupena = resultSet.getTime("Iraupena");
                    
                    // Convertir la duración a minutos
                    long duracionSegundos = iraupena.getTime() / 1000;
                    long minutos = duracionSegundos / 60;
                    long segundos = duracionSegundos % 60;
                    
                    emaitza.add(izena + ", " + minutos + " minutu " + segundos + " segundo");
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
    
    
}