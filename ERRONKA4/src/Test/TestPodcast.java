package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Modelo.Podcast;

public class TestPodcast {

    private Podcast podcast;

    @Before
    public void setUp() {
        String kolaboratzaileak = "John Cena";
        podcast = new Podcast(kolaboratzaileak);
    }

    @Test
    public void testGetKolaboratzaileak() {
        assertEquals("John Cena", podcast.getKolaboratzaileak());
    }

    @Test
    public void testSetKolaboratzaileak() {
        podcast.setKolaboratzaileak("Will Smith");
        assertEquals("Will Smith", podcast.getKolaboratzaileak());
    }

    @Test
    public void testToString() {
        String expectedString = "Podcast [kolaboratzaileak=John Cena]";
        assertEquals(expectedString, podcast.toString());
    }

    @Test
    public void testHashCode() {
        Podcast bestebat = new Podcast("John Cena");
        assertEquals(podcast.hashCode(), bestebat.hashCode());
    }

    @Test
    public void testEquals() {
        Podcast Podcast1 = new Podcast("John Cena");
        Podcast Podcast2 = new Podcast("Will Smith");

        assertTrue(podcast.equals(Podcast1));
        assertFalse(podcast.equals(Podcast2));
        assertFalse(podcast.equals(null));
        assertFalse(podcast.equals("John Cena"));
    }

    @Test
    public void testEqualsItself() {
        assertTrue(podcast.equals(podcast));
    }

    @Test
    public void testEqualsDifferentType() {
        assertFalse(podcast.equals(new Object()));
    }

    @Test
    public void testEqualsWithNullField() {
        Podcast nullPodcast = new Podcast(null);
        assertFalse(podcast.equals(nullPodcast));
    }

    @Test
    public void testNotEquals() {
        Podcast other = new Podcast("Jane Smith");
        assertNotEquals(podcast, other);
    }

    @Test
    public void testNotEqualsNull() {
        assertNotEquals(podcast, null);
    }

    @Test
    public void testNotEqualsDifferentType() {
        assertNotEquals(podcast, new Object());
    }

}