package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Modelo.Audio;

		public class AudioTest {

	@Before
	public void setUp() {
		// Se ejecuta antes de cada prueba
		int id = 1;
		String izena = "Jaime";
		int erreprodukzioak = 1;
		double iraupena = 1.35d;
		audio = new Audio(id, izena, erreprodukzioak, iraupena);
	}
	
	@Test
	public void TestgetId() {
		assertEquals(1,audio.getId());
	}
	
	@Test
	public void TestsetId() {
		audio.setId(123);
		assertEquals(123, audio.getId());
	}
	
	@Test
	public void TestgetIzena() {
		assertEquals("Jaime", audio.getIzena());
	}
	
	@Test
	public void TestsetIzena() {
		audio.setIzena("Pedro");
		assertEquals("Pedro", audio.getIzena());
	}
	
	@Test
	public void TestgetErreprodukzioak() {
		assertEquals(1, audio.getErreprodukzioak());
	}
	
	@Test
	public void  TestsetErreprodukzioak() {
		audio.setErreprodukzioak(1000);
		assertEquals(1000, audio.getErreprodukzioak());
	}
	
	@Test 
	public void TestgetIraupena() {
		assertEquals(1.35d , audio.getIraupena(), 0.01);
	}
	
	@Test
	public void TestsetIraupena() {
		audio.setIraupena(1.45d);
		assertEquals(1.45d , audio.getIraupena(), 0.01);
	}
	
	@Test
	public void TesttoString() {
		String expectedString = "Audio [id=1, izena=Jaime, erreprodukzioak=1, iraupena=1.35]";
		   assertEquals(expectedString, audio.toString());
	}
}
