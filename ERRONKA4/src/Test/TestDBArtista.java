package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DB.DBArtista;

public class TestDBArtista {

    @Before
    public void setUp() throws Exception {
        // Puedes realizar alguna inicialización si es necesario antes de cada test
    }

    @After
    public void tearDown() throws Exception {
        // Puedes limpiar recursos después de cada test si es necesario
    }

    @Test
    public void testMusikariakDescubritu() {
        List<String> musikariak = DBArtista.MusikariakDescubritu();
        // Asegúrate de que la lista no sea nula y tenga algunos elementos
        assertEquals(false, musikariak.isEmpty());
    }

    @Test
    public void testMusikariarenAlbumak() {
        int cboxArtista = 1; // Aquí necesitas el ID de un artista válido
        List<String> albumak = DBArtista.MusikariarenAlbumak(cboxArtista);
        // Asegúrate de que la lista no sea nula y tenga algunos elementos
        assertEquals(false, albumak.isEmpty());
    }

    @Test
    public void testMusikariarenInformazioa() {
        int cboxArtista = 1; // Aquí necesitas el ID de un artista válido
        List<String> informazioa = DBArtista.MusikariarenInformazioa(cboxArtista);
        // Asegúrate de que la lista no sea nula y tenga algunos elementos
        assertEquals(false, informazioa.isEmpty());
    }

    @Test
    public void testIDAudio() {
        int albumaukeraCbox = 1; // Aquí necesitas el ID de un álbum válido
        int rowCount = DBArtista.IDAudio(albumaukeraCbox);
        // Asegúrate de que la cuenta sea mayor que cero si hay registros disponibles
        assertEquals(true, rowCount > 0);
    }

    @Test
    public void testAbestiakAtera() {
        String album = "Album Name"; // Aquí necesitas el nombre de un álbum válido
        ArrayList<String> abestiak = DBArtista.AbestiakAtera(album);
        // Asegúrate de que la lista no sea nula y tenga algunos elementos
        assertEquals(false, abestiak.isEmpty());
    }

    @Test
    public void testAlbumarenInformazioa() {
        String albuma = "Album Name"; // Aquí necesitas el nombre de un álbum válido
        String informazioa = DBArtista.albumarenInformazioa(albuma);
        // Asegúrate de que la cadena no sea nula ni esté vacía
        assertEquals(false, informazioa.isEmpty());
    }
}
