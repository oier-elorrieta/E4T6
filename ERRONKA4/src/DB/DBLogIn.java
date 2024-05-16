package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Salbuespenak paketea sartu
import Salbuespenak.LogInSalbuespena;

/**
 * Login-aren logika kudeatzen du
 *  Datu-baseari konektatzen da ea erabiltzaileen kredentzialak benetazkoak diren ala ez.
 */
public class DBLogIn {

	/**
     *  Metodo honek LogInSalbuespena salbuespena bota dezakeela adierazi dugu
     * 
     * @param Erabiltzailea erabiltzailearen izena
     * @param Pasahitza 
     * @return true sesioa zabaldu ahal izan bada, false ezin izan baden.
     * @throws LogInSalbuespena Kredentzialak zuzenak ez badira
     */
    public static boolean isLoginOk(String Erabiltzailea, String Pasahitza) throws LogInSalbuespena {
        try(Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("SELECT Erabiltzailea, Pasahitza FROM bezeroa WHERE Erabiltzailea = ? AND Pasahitza = ?")) {
            // ? marka batzuk setString metodoarekin bete
            stmt.setString(1, Erabiltzailea);
            stmt.setString(2, Pasahitza);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true; // Balio true itzultzen duela adierazi dugu
            } else {
                throw new LogInSalbuespena(); // Salbuespena bota
            }
        } catch (SQLException e) {
            System.err.println("Datu-basearen errorea: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
        }
        return false; // Bestela, false itzuliko du
    }
}