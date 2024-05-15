package DB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class DBErreproduktorea {

    private static Clip clip;
    private static final int askenAbesti = 3; // Abeslari bakoitzaren kanta maximoa
    private static int azkenAbesti = -1; // Azken abestiaren indexa gordetzeko (-1 ipintzen dugu jakiteko oraindik abestirik ez dela erreproduzitu)
    
    // Abestia erreproduzitzeko metodoa
    public static void abestiaEntzun(int idArtista, int abestiIndex) {
        String audioIzena = "src/MediaM/" + idArtista + "_" + abestiIndex + ".wav";
        entzun(audioIzena);
    }
    
    public static void podcastEntzun(int idPodcaster, int idPodcast) {
        String audioIzena = "src/MediaP/" + idPodcaster + "_" + idPodcast + ".wav";
        entzun(audioIzena);
    }

    private static void entzun(String audioIzena) {
        File fitxa = new File(audioIzena);
        if (fitxa.exists()) {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            playEmon(fitxa);
        } else {
            System.out.println(audioIzena + " ez da aurkitu");
        }
    }
    // Hurrengo abestiaren indexa lortzeko metodoa Free erabiltzaileentzat (aleatorioa)
    public static int hurrengoRandom() {
        int hurrengoko;
        do {
            hurrengoko = (int)(Math.random() * askenAbesti) + 1;
        } while (hurrengoko == azkenAbesti);

        azkenAbesti = hurrengoko;
        return hurrengoko;
    }

    // Hurrengo abestiaren indexa lortzeko metodoa Premium erabiltzaileentzat (ordenatua)
    public static int hurrengoOrdenatua(int currentIndex) {
        return (currentIndex % askenAbesti) + 1;
    }

    // Play eta pause funtzioa
    public static void playEtaPausa() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop(); // Erreprodukzioa pausatzen du erreproduzitzen baldin ba zegoen
            } else {
                int posizioa = clip.getFramePosition();
                clip.setFramePosition(posizioa); // Abestia gelditzeko zegoen puntuan
                clip.start(); // Erreprodukzioa hasten du geldirik baldin ba zegoen
            }
        }
    }

    // Abestia hasieratik erreproduzitzeko
    public static void replay() {
        if (clip != null) {
            clip.setFramePosition(0); // Hasierara joan
            clip.start();
        }
    }

    // Abestia erreproduzitzeko metodoa
    public static void playEmon(File audioFitxa) {
        try {
            if (audioFitxa.exists()) {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(audioFitxa));
                clip.start();
            } else {
                System.out.println("Audio fitxategia ez da existitzen");
            }
        } catch (Exception e) {
            System.out.println("Errorea audioa erreprodukziorakoan: " + e.getMessage());
        }
    }
    
    
    //Premium den edo normal ateratzeko
    public static String bezeroMota(int cboxAbestia) {
        String mota = null;

        try (Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("SELECT mota FROM audio WHERE IDAudio = ?")) {
            
            stmt.setInt(1, cboxAbestia);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                mota = rs.getString("mota");
            }
        } catch (SQLException e) {
            System.err.println("Datu-basearen errorea: " + e.getMessage());
        }
        
        return mota;
    }
    
}
