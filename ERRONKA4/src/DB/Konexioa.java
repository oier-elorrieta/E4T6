package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Datu basearekin konexioa egiten du
 */
public class Konexioa {
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/db_spoty";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection konexioa;
    
    
    /**
     * Datu basearekin konexioa egiten du
     *
     * @return konexioa lortu da
     */
    public static Connection konektatu() {
        try {
            if (konexioa == null || konexioa.isClosed()) {
                konexioa = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (SQLException e) {
            System.out.println("Errorea datu-basearekin konexioa egiten: " + e.getMessage());
        }
        return konexioa;
    }
    
    
    /**
     * Datu basearekin konexioa ixten du
     *
     * @param konexioa koenxioa ixtea lortu da
     */
        public static void itxiKonexioa(Connection konexioa) {
            try {
                if (konexioa != null && !konexioa.isClosed()) {
                    konexioa.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
}