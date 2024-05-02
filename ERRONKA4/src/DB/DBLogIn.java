package DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBLogIn {
    
    /**
     * Erabiltzailea sartutako kredentzialak datu-basean daudenak diren egiaztatzen du.
     * 
     * @param Erabiltzailea Erabiltzailearen izena
     * @param Pasahitza Erabiltzailearen pasahitza
     * @return Sartutako kredentzialak zuzenak badira, true itzultzen du. Bestela, false.
     */
    public static boolean isLoginOk(String Erabiltzailea, String Pasahitza) {
        try(Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("SELECT Erabiltzailea, Pasahitza FROM bezeroa WHERE Erabiltzailea = ? AND Pasahitza = ?")) {
            stmt.setString(1, Erabiltzailea);
            stmt.setString(2, Pasahitza);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                throw new SQLException("Kredentzial okerrak");
            }
        } catch (SQLException e) {
            System.err.println("Errorea datubasearekin " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Errorea datu basearekin " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}