package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import Modelo.Premium;

public class PTestPremium {

    private Premium premium;

    @Before
    public void setUp() {
        String izena = "Andoni";
        String abizena = "Salsi";
        String hizkuntza = "eu";
        String erabiltzailea = "Ando";
        String pasahitza = "Sidua";
        Date jaiotzedata = Date.valueOf("1995-03-14");
        Date erregistrodata = Date.valueOf("2024-04-18");
        Date iraungitzedata = Date.valueOf("2025-12-31");
        premium = new Premium(0, izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzedata, erregistrodata, iraungitzedata);
    }

    @Test
    public void testGetIraungitzedata() {
        assertEquals(Date.valueOf("2025-12-31"), premium.getIraungitzedata());
    }

    @Test
    public void testSetIraungitzedata() {
        premium.setIraungitzedata(Date.valueOf("2026-01-01"));
        assertEquals(Date.valueOf("2026-01-01"), premium.getIraungitzedata());
    }

    @Test
    public void testToString() {
        String expectedString = "Premium [iraungitzedata=2025-12-31, id=0, izena=Daenerys, abizena=Targaryen, hizkuntza=eu, erabiltzailea=dany, pasahitza=fireAndBlood, jaiotzedata=1995-03-14, erregistrodata=2024-04-18, premiummuga=null, premium=false]";
        assertEquals(expectedString, premium.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(Date.valueOf("2025-12-31").hashCode(), premium.hashCode());
    }

    @Test
    public void testEquals() {
        Premium samePremium = new Premium(0, "Andoni", "Salsi", "eu", "Ando", "Sidua", Date.valueOf("1995-03-14"), Date.valueOf("2024-04-18"), Date.valueOf("2025-12-31"));
        assertTrue(premium.equals(samePremium));
        
        Premium differentPremium = new Premium(0, "Aitor", "Mentxaka", "es", "Mentxi", "Erandio1234", Date.valueOf("1998-09-21"), Date.valueOf("2024-04-18"), Date.valueOf("2025-12-31"));
        assertFalse(premium.equals(differentPremium));
    }
}