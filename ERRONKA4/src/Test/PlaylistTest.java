package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Modelo.Album;
import Modelo.Playlist;

public class PlaylistTest {

    private Playlist playlist;

    @Before
    public void setUp() {
        int id = 1;
        String izenburua = "Kotxerako";
        String sorreradata = "2024-04-18";
        playlist = new Playlist(id, izenburua, sorreradata, null);
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
        assertEquals("Kotxerako", playlist.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
        playlist.setIzenburua("Dutxarako");
        assertEquals("Dutxarako", playlist.getIzenburua());
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
    public void testEquals() {
        Playlist playlist1 = new Playlist(1, "Kotxerako", "2024-04-18", null);
        Playlist playlist2 = new Playlist(1, "Kotxerako", "2024-04-18", null);
        assertTrue(playlist1.equals(playlist2));
    }

    @Test
    public void testToString() {
        ArrayList<Album> abestiak = new ArrayList<>();
        abestiak.add(new Album(1, "Album 1", 2024, "Rock", null));
        abestiak.add(new Album(2, "Album 2", 2025, "Pop", null));

        Playlist playlistWithAlbums = new Playlist(1, "Kotxerako", "2024-04-18", abestiak);
        String expectedString = "Playlist [id=1, izenburua=Kotxerako, sorreradata=2024-04-18, Abestiak=[Album [id=1, izenburua=Album 1, urtea=2024, generoa=Rock, Abestiak=null], Album [id=2, izenburua=Album 2, urtea=2025, generoa=Pop, Abestiak=null]]]";
        assertEquals(expectedString, playlistWithAlbums.toString());
    }
}
