package DB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JOptionPane;

public class DBErreproduktorea {

    private static Clip clip;
    private static final int askenAbesti = 3; // Abeslari bakoitzaren kanta maximoa
    private static int azkenAbesti = -1; // Azken abestiaren indexa gordetzeko (-1 ipintzen dugu jakiteko oraindik abestirik ez dela erreproduzitu)
    
    // Abestia erreproduzitzeko metodoa
    public static void abestiaEntzun(int idArtista, int abestiIndex) {
        String audioIzena = "src/MediaM/" + idArtista + "_" + abestiIndex + ".wav";
        entzun(audioIzena);
    }
    
    public static String erreproduzitzenDagoenAbestia(int idArtista, int abestiIndex) {
        String audioIzena = "src/MediaM/" + idArtista + "_" + abestiIndex + ".wav";
        return audioIzena;

    }
    
    public static void podcastEntzun(int idPodcaster, int idPodcast) {
        String audioIzena = "src/MediaP/" + idPodcaster + "_" + idPodcast + ".wav";
        entzun(audioIzena);
    }
    
   
        public static void playCamaron() {
            try {
                File camaronFile = new File("src/MediaM/camaron.wav");
                if (camaronFile.exists()) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(camaronFile));

                    // Agregar un LineListener para detectar cuando el audio termina de reproducirse
                    clip.addLineListener(new LineListener() {
                        public void update(LineEvent event) {
                            if (event.getType() == LineEvent.Type.STOP) {
                                // Aquí puedes llamar a un método para cambiar de frame
                                // Por ejemplo:
                                // cambiarDeFrame();
                                System.out.println("Audio terminado. Cambiar de frame aquí.");
                            }
                        }
                    });

                    clip.start();
                    
                    
                    
                    
                } else {
                    System.out.println("camaron.wav ez da aurkitu");
                }
            } catch (Exception e) {
                System.out.println("Errora camaron.wav: erreproduzitzean" + e.getMessage());
            }
        }
    


    public static void entzun(String audioIzena) {
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
    
  //Menua Botoia

    public static  List<String>playListakLortu() {
            List<String> emaitza = new ArrayList<>();
            try {
                Connection connection = Konexioa.konektatu();
                if (connection != null) {
                    String kontsulta = "SELECT * FROM Playlist";
                    PreparedStatement preparedStatement = connection.prepareStatement(kontsulta);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        emaitza.add(resultSet.getString("Izenburua"));
                    }
                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Errorea musikariak ateratzean: " + e.getMessage());
            }
            return emaitza;
    	}
    public static void aktualizatuPlayList(String aukeratutakoPlayList, int erreproduzitzenDagoenAbestia) {

        try (Connection conn = Konexioa.konektatu();

             PreparedStatement stmt = conn.prepareStatement("INSERT INTO PLaylist_Abestiak (IDList, IDAudio) VALUES ((SELECT IDList FROM Playlist WHERE Izenburua = ?), ?)")) {

            stmt.setString(1, aukeratutakoPlayList); // Aukeratutako zerrendaren izena

            stmt.setInt(2, erreproduzitzenDagoenAbestia); // Gehitu nahi den abestiaren IDa

            int erregistroakAldatutakoak = stmt.executeUpdate();

            if (erregistroakAldatutakoak == 0) {

                throw new SQLException("Errorea playlist-a gehitzean: Erregistroa ezin da aldatu");

            } else {

                System.out.println("Playlist-a gehitu da.");

            }

        } catch (SQLException e) {

            System.err.println("Datu-basearen errorea: " + e.getMessage());

            JOptionPane.showMessageDialog(null, "Datu-basearen errorea: Abesti hau jada playlist-ean gehitu da", "Errorea", JOptionPane.ERROR_MESSAGE);        }

    }
    
    
    
  //Gustoko botoia

    public static void gustokoakPlayList(int erreproduzitzenDagoenAbestia) {
        try (Connection conn = Konexioa.konektatu();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Gustukoak (IDBezeroa, IDAudio) VALUES (?, ?)")) {
            // IDBezeroa hardkodetzen dugu, gustokoaLista -ra bakoitzak bakarrik bere audioak gehitu ahal izateko
            stmt.setInt(1, 1); // IDBezeroa
            stmt.setInt(2, erreproduzitzenDagoenAbestia); // Gehitu nahi den abestiaren IDa
            int erregistroakAldatutakoak = stmt.executeUpdate();
            if (erregistroakAldatutakoak == 0) {
                throw new SQLException("Errorea playlist-a gehitzean: Erregistroa ezin da aldatu");
            } else {
                System.out.println("Playlist-a gehitu da.");
            }
        } catch (SQLException e) {
            System.err.println("Datu-basearen errorea: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Datu-basearen errorea: Abesti hau jada gustokoak-listan gehitu da", "Errorea", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    
}
