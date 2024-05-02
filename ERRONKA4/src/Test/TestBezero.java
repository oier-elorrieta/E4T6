package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import Modelo.Bezeroa;

public class TestBezero {

    private Bezeroa bezeroa;

    @Before
    public void setUp() {
        // Se ejecuta antes de cada prueba
        int id = 1;
        String izena = "Pedro";
        String abizena = "Picapiedra";
        String hizkuntza = "eu";
        String erabiltzailea = "Picapi";
        String pasahitza = "secreto";
        Date jaiotzedata = Date.valueOf("2000-01-01");
        Date erregistrodata = Date.valueOf("2024-04-17");
        Date premiummuga = Date.valueOf("2024-12-31");
        boolean premium = true;
        bezeroa = new Bezeroa(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
        bezeroa.setPremiummuga(premiummuga);
        bezeroa.setPremium(premium);
    }

    @Test
    public void testGetId() {
        assertEquals(1, bezeroa.getId());
    }

    @Test
    public void testSetId() {
        bezeroa.setId(2);
        assertEquals(2, bezeroa.getId());
    }

    @Test
    public void testGetIzena() {
        assertEquals("Pedro", bezeroa.getIzena());
    }

    @Test
    public void testSetIzena() {
        bezeroa.setIzena("Poio");
        assertEquals("Poio", bezeroa.getIzena());
    }

    @Test
    public void testGetAbizena() {
        assertEquals("Picapiedra", bezeroa.getAbizena());
    }

    @Test
    public void testSetAbizena() {
        bezeroa.setAbizena("Sanchez");
        assertEquals("Sanchez", bezeroa.getAbizena());
    }

    @Test
    public void testGetHizkuntza() {
        assertEquals("eu", bezeroa.getHizkuntza());
    }

    @Test
    public void testSetHizkuntza() {
        bezeroa.setHizkuntza("es");
        assertEquals("es", bezeroa.getHizkuntza());
    }

    @Test
    public void testGetErabiltzailea() {
        assertEquals("Picapi", bezeroa.getErabiltzailea());
    }

    @Test
    public void testSetErabiltzailea() {
        bezeroa.setErabiltzailea("PedroPoio");
        assertEquals("PedroPoio", bezeroa.getErabiltzailea());
    }

    @Test
    public void testGetPasahitza() {
        assertEquals("secreto", bezeroa.getPasahitza());
    }

    @Test
    public void testSetPasahitza() {
        bezeroa.setPasahitza("123cuatro");
        assertEquals("123cuatro", bezeroa.getPasahitza());
    }

    @Test
    public void testGetJaiotzedata() {
        assertEquals(Date.valueOf("2000-01-01"), bezeroa.getJaiotzedata());
    }

    @Test
    public void testSetJaiotzedata() {
        bezeroa.setJaiotzedata(Date.valueOf("1990-12-31"));
        assertEquals(Date.valueOf("1990-12-31"), bezeroa.getJaiotzedata());
    }

    @Test
    public void testGetErregistrodata() {
        assertEquals(Date.valueOf("2024-04-17"), bezeroa.getErregistrodata());
    }

    @Test
    public void testSetErregistrodata() {
        bezeroa.setErregistrodata(Date.valueOf("2025-01-01"));
        assertEquals(Date.valueOf("2025-01-01"), bezeroa.getErregistrodata());
    }
    
    @Test
    public void testIsPremium() {
        assertTrue(bezeroa.isPremium());
    }

    @Test
    public void testSetPremium() {
        bezeroa.setPremium(false);
        assertFalse(bezeroa.isPremium());
    }
    
    @Test
    public void testGetPremiummuga() {
        assertEquals(Date.valueOf("2025-01-01"), bezeroa.getPremiummuga());
    }

    @Test
    public void testSetPremiummuga() {
        Date PremiumData = Date.valueOf("2026-01-01");
        bezeroa.setPremiummuga(PremiumData);
        assertEquals(PremiumData, bezeroa.getPremiummuga());
    }
    
    @Test
    public void testToString() {
        String expectedString = "Bezeroa [id=1, izena=Pedro, abizena=Picapiedra, hizkuntza=eu, erabiltzailea=Picapi, pasahitza=secreto, jaiotzedata=2000-01-01, erregistrodata=2024-04-17]";
        assertEquals(expectedString, bezeroa.toString());
    }
    
    
    
}