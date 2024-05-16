package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modelo.Artista;

public class PTestArtista {

    private Artista artista1;
    private Artista artista2;

    @Before
    public void setUp() throws Exception {
        // Creamos dos objetos Artista para utilizar en las pruebas
        artista1 = new Artista(1, "Artista 1", "imagen1.jpg", "Artista 1 deskribapena");
        artista2 = new Artista(2, "Artista 2", "imagen2.jpg", "Artista 2 deskribapena");
    }

    @After
    public void tearDown() throws Exception {
        // Limpiamos los objetos Artista después de cada prueba
        artista1 = null;
        artista2 = null;
    }

    @Test
    public void testGetId() {
        assertEquals(1, artista1.getId());
        assertEquals(2, artista2.getId());
    }

    @Test
    public void testSetId() {
        artista1.setId(10);
        assertEquals(10, artista1.getId());
    }

    @Test
    public void testGetIzena() {
        assertEquals("Artista 1", artista1.getIzena());
        assertEquals("Artista 2", artista2.getIzena());
    }

    @Test
    public void testSetIzena() {
        artista1.setIzena("New Artista 1");
        assertEquals("New Artista 1", artista1.getIzena());
    }

    @Test
    public void testGetIrudia() {
        assertEquals("imagen1.jpg", artista1.getIrudia());
        assertEquals("imagen2.jpg", artista2.getIrudia());
    }

    @Test
    public void testSetIrudia() {
        artista1.setIrudia("newImage.jpg");
        assertEquals("newImage.jpg", artista1.getIrudia());
    }

    @Test
    public void testGetDeskribapena() {
        assertEquals("Artista 1 deskribapena", artista1.getDeskribapena());
        assertEquals("Artista 2 deskribapena", artista2.getDeskribapena());
    }

    @Test
    public void testSetDeskribapena() {
        artista1.setDeskribapena("New Artista 1 deskribapena");
        assertEquals("New Artista 1 deskribapena", artista1.getDeskribapena());
    }

    @Test
    public void testEqualsObject() {
        Artista artista1Copy = new Artista(1, "Artista 1", "imagen1.jpg", "Artista 1 deskribapena");

        // Los objetos artista1 y artista1Copy deben ser iguales
        assertEquals(artista1, artista1Copy);

        // Los objetos artista1 y artista2 deben ser diferentes
        assertNotEquals(artista1, artista2);
    }

    @Test
    public void testHashCode() {
        Artista artista1Copy = new Artista(1, "Artista 1", "imagen1.jpg", "Artista 1 deskribapena");

        // Los objetos artista1 y artista1Copy deben tener el mismo hashCode
        assertEquals(artista1.hashCode(), artista1Copy.hashCode());

        // Los objetos artista1 y artista2 deben tener diferentes hashCode
        assertNotEquals(artista1.hashCode(), artista2.hashCode());
    }

    @Test
    public void testToString() {
        String expected = "Artista [id=1, izena=Artista 1, irudia=imagen1.jpg, deskribapena=Artista 1 deskribapena]";
        assertEquals(expected, artista1.toString());
    }

}
