package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Modelo.Audio;

public class PTestAudio {

    private Audio audio;

    @Before
    public void setUp() {
        int id = 1;
        String izena = "Jaime";
        String erreprodukzioak = "Formatua";
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
        assertEquals("Formatua", audio.getErreprodukzioak());
    }
    
    @Test
    public void  TestsetErreprodukzioak() {
        audio.setErreprodukzioak("NewFormatua");
        assertEquals("NewFormatua", audio.getErreprodukzioak());
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
        String expectedString = "Audio [id=1, izena=Jaime, erreprodukzioak=Formatua, iraupena=1.35]";
        assertEquals(expectedString, audio.toString());
    }
}