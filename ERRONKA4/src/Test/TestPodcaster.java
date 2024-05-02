package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import Modelo.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestPodcaster {

    private Podcaster podcaster;
    private ArrayList<Podcaster> podkasterrak;

    @Before
    public void setUp() {
        int id = 1;
        String izena = "Alberto";
        String irudia = "Alberto.jpg";
        String deskribapena = "Alberter";
        podkasterrak = new ArrayList<>();
        podcaster = new Podcaster(id, izena, irudia, deskribapena, podkasterrak);
    }

    @Test
    public void testConstructorAndGetters() {
        assertNotNull(podcaster);
        assertEquals(1, podcaster.getId());
        assertEquals("Alberto", podcaster.getIzena());
        assertEquals("Alberto.jpg", podcaster.getIrudia());
        assertEquals("Alberter", podcaster.getDeskribapena());
        assertNotNull(podcaster.getPodkasterrak());
        assertEquals(0, podcaster.getPodkasterrak().size());
    }

    @Test
    public void testSetters() {
        ArrayList<Podcaster> Podkaster2 = new ArrayList<>();
        Podkaster2.add(new Podcaster(2, "Paco", "Paco.jpg", "Podcaster", new ArrayList<>()));
        podcaster.setPodkasterrak(Podkaster2);

        assertEquals(Podkaster2, podcaster.getPodkasterrak());
    }

    @Test
    public void testToString() {
        String expectedString = "Podcaster [podkasterrak=[], id=1, izena=Paco, irudia=Paco.jpg, deskribapena=Podcaster]";
        assertEquals(expectedString, podcaster.toString());
    }
}