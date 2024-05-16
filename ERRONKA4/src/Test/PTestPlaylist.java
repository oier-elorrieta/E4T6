package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modelo.Album;
import Modelo.Playlist;

public class PTestPlaylist {

    private Playlist playlist1;
    private Playlist playlist2;

    @Before
    public void setUp() throws Exception {
        // Creamos dos objetos Playlist para utilizar en las pruebas
        ArrayList<Album> abestiak1 = new ArrayList<>();
        ArrayList<Album> abestiak2 = new ArrayList<>();
        playlist1 = new Playlist(1, "Playlist 1", "2022-01-01", abestiak1);
        playlist2 = new Playlist(2, "Playlist 2", "2022-02-01", abestiak2);
    }

    @After
    public void tearDown() throws Exception {
        // Limpiamos los objetos Playlist después de cada prueba
        playlist1 = null;
        playlist2 = null;
    }

    @Test
    public void testGetId() {
        assertEquals(1, playlist1.getId());
        assertEquals(2, playlist2.getId());
    }

    @Test
    public void testSetId() {
        playlist1.setId(10);
        assertEquals(10, playlist1.getId());
    }

    @Test
    public void testGetIzenburua() {
        assertEquals("Playlist 1", playlist1.getIzenburua());
        assertEquals("Playlist 2", playlist2.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        playlist1.setIzenburua("New Playlist 1");
        assertEquals("New Playlist 1", playlist1.getIzenburua());
    }

    @Test
    public void testGetSorreradata() {
        assertEquals("2022-01-01", playlist1.getSorreradata());
        assertEquals("2022-02-01", playlist2.getSorreradata());
    }

    @Test
    public void testSetSorreradata() {
        playlist1.setSorreradata("2023-01-01");
        assertEquals("2023-01-01", playlist1.getSorreradata());
    }

    @Test
    public void testGetAbestiak() {
        assertEquals(new ArrayList<Album>(), playlist1.getAbestiak());
    }

    @Test
    public void testSetAbestiak() {
        ArrayList<Album> abestiak = new ArrayList<>();
        Album album = new Album(1, "Album 1", 2022, "Generoa", null);
        abestiak.add(album);
        playlist1.setAbestiak(abestiak);
        assertEquals(abestiak, playlist1.getAbestiak());
    }

    @Test
    public void testEqualsObject() {
        Playlist playlist1Copy = new Playlist(1, "Playlist 1", "2022-01-01", new ArrayList<Album>());

        // Los objetos playlist1 y playlist1Copy deben ser iguales
        assertEquals(playlist1, playlist1Copy);

        // Los objetos playlist1 y playlist2 deben ser diferentes
        assertNotEquals(playlist1, playlist2);
    }

    @Test
    public void testHashCode() {
        Playlist playlist1Copy = new Playlist(1, "Playlist 1", "2022-01-01", new ArrayList<Album>());

        // Los objetos playlist1 y playlist1Copy deben tener el mismo hashCode
        assertEquals(playlist1.hashCode(), playlist1Copy.hashCode());

        // Los objetos playlist1 y playlist2 deben tener diferentes hashCode
        assertNotEquals(playlist1.hashCode(), playlist2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Playlist [id=1, izenburua=Playlist 1, sorreradata=2022-01-01, Abestiak=[]]";
        assertEquals(expected, playlist1.toString());
    }

}
