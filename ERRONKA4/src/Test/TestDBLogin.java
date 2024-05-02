package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DB.DBLogIn;
import DB.Konexioa;

public class TestDBLogin {

    private static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        connection = Konexioa.konektatu();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        connection.close();
    }

    @Test
    public void testIsLoginOkKredeniztialakOndo() throws SQLException {
        String erabiltzailea = "a";
        String pasahitza = "a";

        // Erabiltzailea sortu frogak egiteko
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO bezeroa (Erabiltzailea, Pasahitza) VALUES (?, ?)")) {
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);
            stmt.executeUpdate();
        }

        // Login-a frogatu kredentzial zuzenekin
        assertTrue(DBLogIn.isLoginOk(erabiltzailea, pasahitza));
    }

    @Test
    public void testIsLoginOkIncorrectCredentials() {
        String erabiltzailea = "a";
        String pasahitza = "b";

        // Login-a frogatu kredentzial EZ zuzenekin
        assertFalse(DBLogIn.isLoginOk(erabiltzailea, pasahitza));
    }

}