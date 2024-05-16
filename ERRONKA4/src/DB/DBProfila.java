package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.Bezeroa;
import Salbuespenak.ProfilaSalbuespena;


/**
 * Bezeroaren perfila eta datubasearekiko harremanak kudeatu
 */
public class DBProfila {
	
	/**
     * Erabiltzailearen informazioa hartzen du datu basetik
     *
     * @param erabiltzailea Hartuko den erabiltzailearen izena
     * @return  Bezero objetu bat zein erabiltzailea den, edo null bezerorik agertu baden
     */
public static Bezeroa bezeroaLortu(String erabiltzailea) {
   Bezeroa bezeroa = null;
   try (Connection conn = Konexioa.konektatu();
        PreparedStatement stmt = conn.prepareStatement("SELECT Izena, Abizena, Erabiltzailea, Hizkuntza, Pasahitza, Jaiotze_data, Erregistro_data FROM bezeroa WHERE Erabiltzailea = ?")) {
       // Interrogazioa prestatu
       stmt.setString(1, erabiltzailea);
       
       // Konsulta exekutatu
       ResultSet rs = stmt.executeQuery();
       
       // Emaitza bat badago...
       if (rs.next()) {
           // Daturen zatiak eskuratu
           String izena = rs.getString("Izena");
           String abizena = rs.getString("Abizena");
           String hizkuntza = rs.getString("Hizkuntza");
           String user = rs.getString("Erabiltzailea");
           String pasahitza = rs.getString("Pasahitza");
           java.sql.Date jaiotzeData = rs.getDate("Jaiotze_data");
           java.sql.Date erregistroData = rs.getDate("Erregistro_data");

           // Data nulua edo zeroa bada, ezarri balio lehenetsia
           if (jaiotzeData == null || jaiotzeData.toLocalDate().equals(LocalDate.of(2000, 6, 7))) {
               jaiotzeData = java.sql.Date.valueOf(LocalDate.now());
           }
           if (erregistroData == null || erregistroData.toLocalDate().equals(LocalDate.of(2000, 6, 7))) {
               erregistroData = java.sql.Date.valueOf(LocalDate.now());
           }

           // Bezero objektua sortu
           bezeroa = new Bezeroa(izena, abizena, user, hizkuntza, pasahitza, jaiotzeData, erregistroData);
       } else {
           // Erabiltzailea ez dagoen kasua
           // Objektu nulua itzuli bezeroa ez dagoela adierazteko
           return bezeroa;
       }
   } catch (SQLException e) {
       // SQL errorea
       System.err.println("Datu-basearen errorea: " + e.getMessage());
       JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
   }
   return bezeroa;
}
   

/**
 * Bezeroaren informazioa eguneratzen du datu basean
 *
 * @param bezeroa bezeroaren datuak eguneraturik
 * @param lehenengoBezeroa Bezeroaren lehenengo izena eguneratu baino lehen
 * @throws ProfilaSalbuespena Erroren bat agertzen bada bezeroa eguneratzekoan
 */
public static void aktualizatuBezeroa(Bezeroa bezeroa, String lehenengoBezeroa) throws ProfilaSalbuespena {
    // Egiaztatu eremua beteta dagoela
    if (bezeroa.getIzena().isEmpty() || bezeroa.getAbizena().isEmpty() ||
        bezeroa.getPasahitza().isEmpty() || bezeroa.getJaiotzedata() == null || bezeroa.getErregistrodata() == null) {
        JOptionPane.showMessageDialog(null, "Mesedez, bete eremua beti bete.", "Eremuak bete behar dira", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    try (Connection conn = Konexioa.konektatu();
         PreparedStatement stmt = conn.prepareStatement("UPDATE bezeroa SET Izena = ?, Abizena = ?, Erabiltzailea = ?, Hizkuntza = ?, Pasahitza = ?, Jaiotze_data = ?, Erregistro_data = ? WHERE Erabiltzailea = ?")) {
        
        stmt.setString(1, bezeroa.getIzena());
        stmt.setString(2, bezeroa.getAbizena());
        stmt.setString(3, bezeroa.getIzena());
        stmt.setString(4, bezeroa.getHizkuntza());      
        stmt.setString(5, bezeroa.getPasahitza());
        stmt.setDate(6, bezeroa.getJaiotzedata());
        stmt.setDate(7, bezeroa.getErregistrodata());
        stmt.setString(8, lehenengoBezeroa);

        int erregistroakAldatutakoak = stmt.executeUpdate();
        if (erregistroakAldatutakoak == 0) {
            throw new ProfilaSalbuespena(); // Excepción arrojada
        }
    } catch (SQLException e) {
        System.err.println("Datu-basearen errorea: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Datu-basearen errorea: " + e.getMessage(), "Errorea", JOptionPane.ERROR_MESSAGE);
    }
}

/**
 * Bi objetu bezero konparatu ea berdinak diren
 *
 * @param bez1 Lehen Bezero objetua
 * @param bez2 Bigarren Bezero objetua
 * @return true berdinak badira, false berdinak ez badira
 */
public static boolean bezKomparaketa(Bezeroa bez1, Bezeroa bez2) {
boolean da = false;

if(bez1.equals(bez2)){
da =  true;
}

return da;
}
}
