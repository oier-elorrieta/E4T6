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



/**
 * DBArtista klaseak musika-artistekin datu-basean metodoak ditu
 */
public class DBArtista{
	
	

    /**
     *Musikarien Izenen zerrenda bat lortzen du
     * @return artisten izenen zerrenda
     */
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
    
	
	/**
     *Albumen tituluen zerrenda bat lortzen du, artista zehatz batena
     * @param cboxArtista nahi dugun albumaren musikariaren ID
     * @return musikariaren albumen izenen zerrenda
     */
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
    
    
    /**
     *Musikari baten deskripzioa ateratzen du (zerrenda bat, arttista guztiak sartu ahal izateko)
     *
     * @param cboxArtista informazioa nahi dugun artistaren ID-a
     * @return Zerrenda bat deskripzioekin
     */
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

  
    /**
     * Album baten audio kantitatea
     * @param albumaukeraCbox Nahi dugun albumaren  ID atera informazioa jakitekko
     * @return Audio kantitatea albumaren barruan
     */
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
    
    
    /**
     * Abestien izenen eta iraupenaren zerrenda bat lortzen du
     *
     * @param Album nahi dugun albumaren izena lortu
     * @return albumen kanten izenak eta iraupenen zerrenda bat
     */
    public static ArrayList<String> AbestiakAtera(String Album) {
        ArrayList<String> emaitza = new ArrayList<String>();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Izena, Iraupena FROM abestiDiskak where Izenburua = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setString(1, Album);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String izena = resultSet.getString("Izena");
                    String iraupenaStr = resultSet.getString("Iraupena");

                    
                    String[] partes = iraupenaStr.split(":");
                    int horas = Integer.parseInt(partes[0]);
                    int minutos = Integer.parseInt(partes[1]);
                    int segundos = Integer.parseInt(partes[2]);

                    
                    int iraupenaSegundos = horas * 3600 + minutos * 60 + segundos;

                    
                    minutos = iraupenaSegundos / 60;
                    segundos = iraupenaSegundos % 60;

                    
                    String tiempoFormateado = String.format("%02d:%02d", minutos, segundos);

                    
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


    
    /**
     * Album zehatz bateko informazioa lortzen du
     *
     * @param Album Informazioa lortu nahi dugun albumaren izena
     * @return Textu kate bat albumaren informazioarekin
     */
    public static String albumarenInformazioa(String Albuma) {
        StringBuilder emaitza = new StringBuilder();
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "SELECT Eguna, Generoa, Audioa, Iraupena FROM albumDeskribapena where Izenburua = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                preparedStatement.setString(1, Albuma);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    emaitza.append("Eguna: ").append(resultSet.getDate("Eguna")).append(", ");
                    emaitza.append("Generoa: ").append(resultSet.getString("Generoa")).append(", ");
                    emaitza.append("Audioa: ").append(resultSet.getInt("Audioa")).append(", ");
                    emaitza.append("Iraupena: ").append(resultSet.getTime("Iraupena")).append("\n");
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea musikariak ateratzean " + e.getMessage());
        }
        return emaitza.toString();
    }
    
    
    
    
    
}