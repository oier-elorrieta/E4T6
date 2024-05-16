package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

import Modelo.Abestia;

public class PTestAbestia {

    private Abestia abestia1;
    private Abestia abestia2;
    private Abestia abestia3;
    private Abestia abestia;

    @Before
    public void setUp() {
        abestia = new Abestia(1, "Natural Mystic", "Bob Marley", 3.0);

        // Nuevas pruebas
        abestia1 = new Abestia(1, "Abestia1", "Erreprodukzioak1", 3.5);
        abestia2 = new Abestia(2, "Abestia2", "Erreprodukzioak2", 4.2);
        abestia3 = new Abestia(1, "Abestia1", "Erreprodukzioak1", 3.5);
    }

    @Test
    public void testGetEzaugarria() {
        abestia.setEzaugarria("Reggae");
        assertEquals("Reggae", abestia.getEzaugarria());
    }

    @Test
    public void testSetEzaugarria() {
        abestia.setEzaugarria("Pop");
        assertEquals("Pop", abestia.getEzaugarria());
    }

    @Test
    public void testToString() {
        abestia.setEzaugarria("Pop");
        String expectedString = "Abestia [ezaugarria=Pop]";
        assertEquals(expectedString, abestia.toString());
    }

    @Test
    public void testHashCode() {
        abestia.setEzaugarria("Rock");
        assertEquals(Objects.hash("Rock"), abestia.hashCode());
    }

    @Test
    public void testEquals() {
        Abestia beste1 = new Abestia(1, "Natural Mystic", "Bob Marley", 3.0);
        beste1.setEzaugarria("Rock");
        abestia.setEzaugarria("Rock");
        assertEquals(beste1, abestia);
    }


    @Test
    public void testEqualsNull() {
        assertFalse(abestia1.equals(null));
    }

    @Test
    public void testEqualsKlasedesberdin() {
        assertFalse(abestia1.equals("Zeozer"));
    }

    @Test
    public void testEqualsObjetudesberdinak() {
        assertFalse(abestia1.equals(abestia2));
    }

    @Test
    public void testEqualsObjetuberdinak() {
        assertTrue(abestia1.equals(abestia3));
    }
}