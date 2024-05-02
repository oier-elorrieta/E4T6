package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Modelo.FreeBezero;

import java.sql.Date;

public class TestFreeBezero {

    private FreeBezero freeBezero;

    @Before
    public void setUp() {
        String izena = "Jon";
        String abizena = "Snow";
        String hizkuntza = "eu";
        String erabiltzailea = "jsnow";
        String pasahitza = "winterIsComing";
        Date jaiotzedata = Date.valueOf("1989-07-21");
        Date erregistrodata = Date.valueOf("2024-04-18");
        freeBezero = new FreeBezero(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata);
    }

    @Test
    public void testGetIzena() {
        assertEquals("Jon", freeBezero.getIzena());
    }

    @Test
    public void testSetIzena() {
        freeBezero.setIzena("Arya");
        assertEquals("Arya", freeBezero.getIzena());
    }

    @Test
    public void testGetAbizena() {
        assertEquals("Snow", freeBezero.getAbizena());
    }

    @Test
    public void testSetAbizena() {
        freeBezero.setAbizena("Stark");
        assertEquals("Stark", freeBezero.getAbizena());
    }

    @Test
    public void testGetHizkuntza() {
        assertEquals("eu", freeBezero.getHizkuntza());
    }

    @Test
    public void testSetHizkuntza() {
        freeBezero.setHizkuntza("en");
        assertEquals("en", freeBezero.getHizkuntza());
    }

    @Test
    public void testGetErabiltzailea() {
        assertEquals("jsnow", freeBezero.getErabiltzailea());
    }

    @Test
    public void testSetErabiltzailea() {
        freeBezero.setErabiltzailea("aryastark");
        assertEquals("aryastark", freeBezero.getErabiltzailea());
    }

    @Test
    public void testGetPasahitza() {
        assertEquals("winterIsComing", freeBezero.getPasahitza());
    }

    @Test
    public void testSetPasahitza() {
        freeBezero.setPasahitza("valarMorghulis");
        assertEquals("valarMorghulis", freeBezero.getPasahitza());
    }

    @Test
    public void testGetJaiotzedata() {
        assertEquals(Date.valueOf("1989-07-21"), freeBezero.getJaiotzedata());
    }

    @Test
    public void testSetJaiotzedata() {
        freeBezero.setJaiotzedata(Date.valueOf("1990-01-01"));
        assertEquals(Date.valueOf("1990-01-01"), freeBezero.getJaiotzedata());
    }

    @Test
    public void testGetErregistrodata() {
        assertEquals(Date.valueOf("2024-04-18"), freeBezero.getErregistrodata());
    }

    @Test
    public void testSetErregistrodata() {
        freeBezero.setErregistrodata(Date.valueOf("2025-01-01"));
        assertEquals(Date.valueOf("2025-01-01"), freeBezero.getErregistrodata());
    }
}