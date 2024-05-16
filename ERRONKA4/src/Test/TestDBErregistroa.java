package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DB.DBErregistroa;
import DB.Konexioa;
import Modelo.Bezeroa;
import Salbuespenak.ErregistroSalbuespena;

public class TestDBErregistroa {
    private static Connection connection;
    private Bezeroa bezeroa;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Datubasearekin konexioa hasi
        connection = Konexioa.konektatu();
    }

    @AfterClass
    public static void Konexioaitxio() throws Exception {
        // Metodo honek egiten duena, konexioa ixtea da gero eta froga guztiak exekutatzen diren
        connection.close();
    }

    @Before
    public void setUp() throws Exception {
        
        bezeroa = new Bezeroa("Eminem", "Slim Shady", "ingelesa", "Marshall", "Mathers",
                java.sql.Date.valueOf(LocalDate.parse("1980-01-01")),
                java.sql.Date.valueOf(LocalDate.now()));
    }

    @Test
    public void testBezeroaGorde() {
        // Bezero bat sartu ahal den datubasean
        try {
			DBErregistroa.BezeroaGorde(bezeroa);
		} catch (ErregistroSalbuespena e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Ia bezeroa benetan txertatu den
        int idBezeroa = DBErregistroa.idBezeroLortu(bezeroa);
        assertTrue(idBezeroa > 0);
    }

    @Test
    public void testIdBezeroLortu() {
        // Bezero berri bat txertatu funtzioa frogatzeko
        try {
			DBErregistroa.BezeroaGorde(bezeroa);
		} catch (ErregistroSalbuespena e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Bezeroaren ID-a lortu
        int idBezeroa = DBErregistroa.idBezeroLortu(bezeroa);

        // ID-a 0 baino handiagoa dela
        assertTrue(idBezeroa > 0);
    }

    @Test
    public void testGetDataGaur() {
        // Gaurko data String bezala
        String dataGaur = DBErregistroa.getDataGaur();
        String expectedDataGaur = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Hartutako data garuko datarekin bat egiten duela
        assertEquals(expectedDataGaur, dataGaur);
    }

    @Test
    public void testPremiumDataGorde() {

        try {
			DBErregistroa.BezeroaGorde(bezeroa);
		} catch (ErregistroSalbuespena e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Bezeroaren ID-a atera (auto increment denez beti egin behar da)
        int idBezeroa = DBErregistroa.idBezeroLortu(bezeroa);

        // Premium amaiera data
        String data = "2024-12-31";
        DBErregistroa.PremiumDataGorde(idBezeroa, data);

        // Ikusi ea premium amaiera data ondo txertatu den
        try (PreparedStatement stmt = connection.prepareStatement("SELECT Iraungitze_data FROM Premium WHERE IDBezeroa = ?")) {
            stmt.setInt(1, idBezeroa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String iraungitzeData = rs.getString("Iraungitze_data");
                assertEquals(data, iraungitzeData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}