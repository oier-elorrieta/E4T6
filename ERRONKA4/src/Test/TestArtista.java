package Test;

import Modelo.Artista;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestArtista {
	
	private Artista artista;
	
	@Before
	public void setUp() {
		int id = 1;
		String izena = "JuanMagan";
		String irudia = "Irudi"; 
		String deskribapena = "Deskribapena";
		artista = new Artista(id, izena, irudia, deskribapena);
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
	public void testGetIzena() {
		assertEquals("JuanMagan", artista.getIzena());
	}

	@Test
	public void testSetIzena() {
		artista.setIzena("Hendrix");
		assertEquals("Hendrix", artista.getIzena());
	}

	@Test
	public void testGetIrudia() {
		assertEquals("Irudi", artista.getIrudia());
	}

	@Test
	public void testSetIrudia() {
	    artista.setIrudia("Irudia");
	    assertEquals("Irudia", artista.getIrudia());
	}
	
	@Test
	public void testEquals() {
	
	    Artista artista1 = new Artista(1, "JuanMagan", "Irudi", "Deskribapena");
	    Artista artista2 = new Artista(1, "JuanMagan", "Irudi", "Deskribapena");
	    

	    assertTrue(artista1.equals(artista2));
	}
	
	@Test
	public void testToString() {
		String expectedString = "Artista [id=1, izena=JuanMagan, irudia=Irudi, deskribapena=Deskribapena]";
		assertEquals(expectedString, artista.toString());
	}	
}