package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import DB.*;

public class TestDBMenua {

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
    public void testMusikaDescubritu() {
        List<String> expected = obtenerResultadoEsperado("SELECT IzenArtistikoa FROM musikaria");
        List<String> actual = DBArtista.MusikaDescubritu();

        // Hau gpt esan dit, erantzunak ordenatzeko da. Egiten duena: goranzkako ordena hartzen dute 
        Collections.sort(expected);
        Collections.sort(actual);

        assertEquals(expected, actual);
    }

    @Test
    public void testMusikariarenAlbumak() {
        int comboboxaukera = 1;
        List<String> expected = obtenerResultadoEsperado("SELECT Izenburua FROM album WHERE IDMusikaria = " + comboboxaukera);
        List<String> actual = DBArtista.MusikariarenAlbumak(comboboxaukera);

        // Ordenar los resultados antes de comparar
        Collections.sort(expected);
        Collections.sort(actual);

        assertEquals(expected, actual);
    }

    private List<String> obtenerResultadoEsperado(String query) {
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            List<String> resultadoEsperado = new ArrayList<>();
            while (rs.next()) {
                resultadoEsperado.add(rs.getString(1));
            }
            return resultadoEsperado;

        } catch (SQLException e) {
            // Mensaje de error más descriptivo
            System.err.println("Error al obtener el resultado esperado: " + e.getMessage());
            return null;
        }
    }
}