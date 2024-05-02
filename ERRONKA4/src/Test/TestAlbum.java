package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modelo.Album;

public class TestAlbum {

    private Album album;
    private ArrayList<Album> abestiak;

    @Before
    public void setUp() {
        int id = 1;
        String izenburua = "2023-ko oberenak";
        int urtea = 2023;
        String generoa = "Urbano";
        abestiak = new ArrayList<>();
        album = new Album(id, izenburua, urtea, generoa, abestiak);
    }

    @Test
    public void testGetId() {
        assertEquals(1, album.getId());
    }

    @Test
    public void testSetId() {
        album.setId(2);
        assertEquals(2, album.getId());
    }

    @Test
    public void testGetIzenburua() {
        assertEquals("2023-ko oberenak", album.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        album.setIzenburua("Entzunenak");
        assertEquals("Entzunenak", album.getIzenburua());
    }

    @Test
    public void testGetUrtea() {
        assertEquals(2023, album.getUrtea());
    }

    @Test
    public void testSetUrtea() {
        album.setUrtea(2024);
        assertEquals(2024, album.getUrtea());
    }

    @Test
    public void testGetGeneroa() {
        assertEquals("Urbano", album.getGeneroa());
    }

    @Test
    public void testSetGeneroa() {
        album.setGeneroa("Pop");
        assertEquals("Pop", album.getGeneroa());
    }

    @Test
    public void testGetAbestiak() {
        assertNotNull(album.getAbestiak());
        assertEquals(0, album.getAbestiak().size());
    }

    @Test
    public void testSetAbestiak() {
        ArrayList<Album> Abestiak2 = new ArrayList<>();
        Abestiak2.add(new Album(2, "Entzunenak", 2024, "Pop", new ArrayList<>()));
        album.setAbestiak(Abestiak2);
        assertEquals(Abestiak2, album.getAbestiak());
    }
    
    @Test
    public void testEquals() {

        Album album1 = new Album(1, "Best Album", 2024, "Rock", null);
        Album album2 = new Album(1, "Best Album", 2024, "Rock", null);

        assertTrue(album1.equals(album2));
    }

    @Test
    public void testToString() {
        String Esperado = "Album [id=1, izenburua=2023-ko oberenak, urtea=2023, generoa=Urbano, Abestiak=[]]";
        assertEquals(Esperado, album.toString());
    }
}