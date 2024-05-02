package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modelo.Musikaria;

public class MusikariaTest {

    private Musikaria musikaria;
    private ArrayList<Musikaria> album;

    @Before
    public void setUp() {
        int id = 1;
        String izena = "Bob Marley";
        String irudia = "bob_marley.jpg";
        String deskribapena = "Reggae legend";
        album = new ArrayList<>();
        Musikaria.Ezaugarriak ezaugarriak = Musikaria.Ezaugarriak.TALDEA;
        musikaria = new Musikaria(id, izena, irudia, deskribapena, album, ezaugarriak);
    }

    @Test
    public void testGetAlbum() {
        assertNotNull(musikaria.getAlbum());
    }

    @Test
    public void testSetAlbum() {
        ArrayList<Musikaria> newAlbum = new ArrayList<>();
        newAlbum.add(new Musikaria(2, "Queen", "queen.jpg", "Rock legends", new ArrayList<Musikaria>(), Musikaria.Ezaugarriak.TALDEA));
        musikaria.setAlbum(newAlbum);
        assertEquals(newAlbum, musikaria.getAlbum());
    }

    @Test
    public void testGetEzaugarriak() {
        assertEquals(Musikaria.Ezaugarriak.TALDEA, musikaria.getEzaugarriak());
    }

    @Test
    public void testSetEzaugarriak() {
        musikaria.setEzaugarriak(Musikaria.Ezaugarriak.BAKALRRIA);
        assertEquals(Musikaria.Ezaugarriak.BAKALRRIA, musikaria.getEzaugarriak());
    }

    @Test
    public void testToString() {
        String expectedString = "Musikaria [album=[], ezaugarriak=TALDEA, id=1, izena=Bob Marley, irudia=bob_marley.jpg, deskribapena=Reggae legend]";
        assertEquals(expectedString, musikaria.toString());
    }
}
