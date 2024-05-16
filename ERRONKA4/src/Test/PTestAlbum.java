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

public class PTestAlbum {

    private Album album1;
    private Album album2;

    @Before
    public void setUp() throws Exception {
        // Creamos dos objetos Album para utilizar en las pruebas
        ArrayList<Album> abestiak = new ArrayList<>();
        abestiak.add(new Album(1, "Abesti 1", 2022, "Rock", null));
        abestiak.add(new Album(2, "Abesti 2", 2023, "Pop", null));

        album1 = new Album(1, "Album 1", 2021, "Rock", abestiak);
        album2 = new Album(2, "Album 2", 2020, "Pop", null);
    }

    @After
    public void tearDown() throws Exception {
        // Limpiamos los objetos Album después de cada prueba
        album1 = null;
        album2 = null;
    }

    @Test
    public void testGetId() {
        assertEquals(1, album1.getId());
        assertEquals(2, album2.getId());
    }

    @Test
    public void testSetId() {
        album1.setId(10);
        assertEquals(10, album1.getId());
    }

    @Test
    public void testGetIzenburua() {
        assertEquals("Album 1", album1.getIzenburua());
        assertEquals("Album 2", album2.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        album1.setIzenburua("New Album 1");
        assertEquals("New Album 1", album1.getIzenburua());
    }

    @Test
    public void testGetUrtea() {
        assertEquals(2021, album1.getUrtea());
        assertEquals(2020, album2.getUrtea());
    }

    @Test
    public void testSetUrtea() {
        album1.setUrtea(2025);
        assertEquals(2025, album1.getUrtea());
    }

    @Test
    public void testGetGeneroa() {
        assertEquals("Rock", album1.getGeneroa());
        assertEquals("Pop", album2.getGeneroa());
    }

    @Test
    public void testSetGeneroa() {
        album1.setGeneroa("Hip Hop");
        assertEquals("Hip Hop", album1.getGeneroa());
    }

    @Test
    public void testGetAbestiak() {
        ArrayList<Album> abestiak = album1.getAbestiak();
        assertEquals(2, abestiak.size());
        assertEquals("Abesti 1", abestiak.get(0).getIzenburua());
        assertEquals("Abesti 2", abestiak.get(1).getIzenburua());
    }

    @Test
    public void testSetAbestiak() {
        ArrayList<Album> abestiak = new ArrayList<>();
        abestiak.add(new Album(3, "Abesti 3", 2025, "Pop", null));
        album2.setAbestiak(abestiak);
        assertEquals(1, album2.getAbestiak().size());
        assertEquals("Abesti 3", album2.getAbestiak().get(0).getIzenburua());
    }

    @Test
    public void testEqualsObject() {
        Album album1Copy = new Album(1, "Album 1", 2021, "Rock", null);

        // Los objetos album1 y album1Copy deben ser iguales
        assertEquals(album1, album1Copy);

        // Los objetos album1 y album2 deben ser diferentes
        assertNotEquals(album1, album2);
    }

    @Test
    public void testHashCode() {
        Album album1Copy = new Album(1, "Album 1", 2021, "Rock", null);

        // Los objetos album1 y album1Copy deben tener el mismo hashCode
        assertEquals(album1.hashCode(), album1Copy.hashCode());

        // Los objetos album1 y album2 deben tener diferentes hashCode
        assertNotEquals(album1.hashCode(), album2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Album [id=1, izenburua=Album 1, urtea=2021, generoa=Rock, Abestiak=[Album [id=1, izenburua=Abesti 1, urtea=2022, generoa=Rock, Abestiak=null], Album [id=2, izenburua=Abesti 2, urtea=2023, generoa=Pop, Abestiak=null]]]";
        assertEquals(expected, album1.toString());
    }

}
