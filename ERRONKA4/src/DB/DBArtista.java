package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DBArtista{
	
	/**
	 * Datu-basean dauden musikari guztiak itzultzen ditu.
	 * 
	 * @return Musikarien izen artistikoak lista moduan
	 */
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
    
    /**
     * Aukeratutako musikariaren album guztiak itzultzen ditu.
     * 
     * @param comboboxaukera Musikariaren identifikadorea
     * @return Albumen izenburuak lista moduan
     */
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
    
    /**
     * Aukeratutako musikariaren informazioa itzultzen du.
     * 
     * @param comboboxaukera Musikariaren identifikadorea
     * @return Musikariaren deskribapena
     */
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

    /**
     * Aukeratutako albumaren audio kopurua itzultzen du.
     * 
     * @param albumaukeraCbox Albumaren identifikadorea
     * @return Audio kopurua
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
     * Aukeratutako audioaren informazioa itzultzen du, minuto eta segundoetan.
     * 
     * @param IDAudio Audioaren identifikadorea
     * @return Audioaren izena eta iraupena
     */
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
                    
                    // Minutuetara pasa
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
