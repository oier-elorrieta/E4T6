package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Modelo.Bezeroa;

public class DBErregistroa {
    
    /**
     * Bezero berri bat datu-basean gorde.
     * 
     * @param nb Gorde nahi den bezeroa
     */
    public static void BezeroaGorde(Bezeroa nb) {
        try {
            Connection connection = Konexioa.konektatu();
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
    
    /**
     * Bezeroaren identifikadorea lortu datu-basean.
     * 
     * @param nb Bezeroa non dagoen jakiteko erabiltzen den bezero objektua
     * @return Bezeroaren identifikadorea
     */
    public static int idBezeroLortu(Bezeroa nb) {
        int idBezeroa = -1;
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("SELECT IDBezeroa FROM bezeroa WHERE Erabiltzailea = ?")) {
            stmt.setString(1, nb.getErabiltzailea());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idBezeroa = rs.getInt("IDBezeroa");
            } else {
                throw new SQLException("Kredentzial okerrak");
            }
        } catch (SQLException e) {
            System.err.println("Errorea datu basearekin " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Errorea datu basearekin " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idBezeroa;
    }
    
    /**
     * Gaurko data lortu eta string moduan itzultzen du.
     * 
     * @return Gaurko data string moduan
     */
    public static String getDataGaur() {
        LocalDate dataGaur = LocalDate.now();
        //Data Stringera aldatzen du
        String sdataGaur = dataGaur.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return sdataGaur;
    }
    
    /**
     * Premium erabiltzailea bihurtu eta datu-basean gorde.
     * 
     * @param idBezeroa Premium bihurtu nahi den bezeroaren identifikadorea
     * @param data Premium bihurtu den data
     */
    public static void PremiumDataGorde(int idBezeroa, String data) {
        try {
            Connection connection = Konexioa.konektatu();
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
}