package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Modelo.Bezeroa;
import Salbuespenak.ErregistroSalbuespena;


/**
 * Bezeroen registroen kudeatzen duten metodoak ditu
 */
public class DBErregistroa {
	
	/**
     * Bezeroaren informazioa gordetzen du datu basean
     *
     * @param nb Bezero objetua zein bezeroaren informazioa daukan 
     * @throws ErregistroSalbuespena arazorenbat ateratzen baldin bada bezeroa datu basean gordetzerakoan
     */
	 public static void BezeroaGorde(Bezeroa nb) throws ErregistroSalbuespena {
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
	            // Salbuespena bota
	            throw new ErregistroSalbuespena();
	        }
	    }
	
	 
	 /**
	     *  Album zehatz batetik informazioa lortzen du
	     *
	     * @param Album informazioa lortu nahi dugun albumaren izena
	     * @return textu kate bat albumaren informazioarekin
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
                throw new SQLException("Credenciales incorrectas");
            }
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idBezeroa;
    }
    
    /**
     *  Gaurko data formatu onetan: yyyy-MM-dd.
     *
     * @return textu kate bat gaurko datarekin
     */
    public static String getDataGaur() {
        LocalDate dataGaur = LocalDate.now();
        //Data Stringera aldatzen du
        String sdataGaur = dataGaur.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        return sdataGaur;
    }
    
    /**
     * Premiumaren amaieraren data gordetzen du (bezero espezifiko batena)
     *
     * @param idBezeroa bezeroaren id-a
     * @param data      premium-aren amaiera
     */
    public static void PremiumDataGorde(int idBezeroa, String data) {
        try {
            Connection connection = Konexioa.konektatu();
            if (connection != null) {
                String kontsulta = "INSERT INTO Premium (IDBezeroa, Iraungitze_data) VALUES (?, ?)";
                PreparedStatement PreparedStatement = connection.prepareStatement(kontsulta);
                PreparedStatement.setInt(1, idBezeroa);
                PreparedStatement.setString(2, data);
                PreparedStatement.execute();;
                PreparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Errorea bezeroa datu-baseari eranstean: " + e.getMessage());
        }
    }
}