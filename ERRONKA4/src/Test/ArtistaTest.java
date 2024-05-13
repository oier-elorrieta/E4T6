package Test;

import Modelo.Artista;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ArtistaTest {
	
	private Artista artista;
	
	@Before
	public void setUp() {
		int id = 1;
		String izena = "JuanMagan";
		String irudia = "Irudi"; 
		artista = new Artista(id, izena, irudia);
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, artista.getId());
	}

	@Test
	public void testSetId() {
		artista.setId(2);
		assertEquals(2, artista.getId());
	}

	@Test
	public void testGetIzenArtistikoa() {
		assertEquals("JuanMagan", artista.getIzenArtistikoa());
	}

	@Test
	public void testSetIzenArtistikoa() {
		artista.setIzenArtistikoa("Hendrix");
		assertEquals("Hendrix", artista.getIzenArtistikoa());
	}

	@Test
	public void testGetIrudia() {
		assertEquals("Irudi", artista.getIrudia());
	}

	@Test
	public void testSetIrudia() {
		String newIrudia = "NewIrudi";
		artista.setIrudia(newIrudia);
		assertEquals(newIrudia, artista.getIrudia());
	}
	
	@Test
	public void testToString() {
		String expectedString = "Artista [id=1, IzenArtistikoa=JuanMagan, Irudia=Irudi]";
		assertEquals(expectedString, artista.toString());
	}	
}
