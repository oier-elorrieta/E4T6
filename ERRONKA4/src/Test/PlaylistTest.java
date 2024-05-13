package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eraikitzailea.Playlist;

public class PlaylistTest {

    private Playlist playlist;

    @Before
    public void setUp() {
        int id = 1;
        String izenburua = "Rock Playlist";
        String sorreradata = "2024-04-18";
        playlist = new Playlist(id, izenburua, sorreradata);
    }

    @Test
    public void testGetId() {
        assertEquals(1, playlist.getId());
    }

    @Test
    public void testSetId() {
        playlist.setId(2);
        assertEquals(2, playlist.getId());
    }

    @Test
    public void testGetIzenburua() {
        assertEquals("Rock Playlist", playlist.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        playlist.setIzenburua("Pop Playlist");
        assertEquals("Pop Playlist", playlist.getIzenburua());
    }

    @Test
    public void testGetSorreradata() {
        assertEquals("2024-04-18", playlist.getSorreradata());
    }

    @Test
    public void testSetSorreradata() {
        playlist.setSorreradata("2022-10-15");
        assertEquals("2022-10-15", playlist.getSorreradata());
    }

    @Test
    public void testToString() {
        String expectedString = "Playlist [id=1, izenburua=Rock Playlist, sorreradata=2024-04-18]";
        assertEquals(expectedString, playlist.toString());
    }
}
