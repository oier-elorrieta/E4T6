package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DB.Konexioa;

public class TestKonexioa {

    private static Connection connection;

    @BeforeClass
    public static void setUpBeforeClassHasi() throws Exception {
        // Konexioa hasi
        connection = Konexioa.konektatu();
    }

    @AfterClass
    public static void tearDownAfterClassItxi() throws Exception {
        // konexioa itxi
        Konexioa.itxiKonexioa(connection);
    }

    @Test
    public void testKonektatu() {
        // Konexioa null ez dela konprobatzea
        assertNotNull("Datu basearen konexioa ez da null izan behar", connection);
    }

    @Test
    public void testKonektatuErrorea() {
        // Konexioa itxi
        Konexioa.itxiKonexioa(null);

        // Konexioa egiten sailatu baina ezin izango da, konexioa itxita dagoelako
        Connection konexioa = Konexioa.konektatu();

        // Konexioa null izan behar da
        assertNull("Konexio null bat espero da konexia ez denean lortzen", konexioa);
    }
}