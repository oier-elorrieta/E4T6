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


/**
 * DBErreproduktorea Audioak erreproduzitzeko eta playlist-ak kudeatzeko metodoak ditu
 */
public class DBErreproduktorea {

    private static Clip clip;
    private static final int askenAbesti = 3; // Abeslari bakoitzaren kanta maximoa
    private static int azkenAbesti = -1; // Azken abestiaren indexa gordetzeko (-1 ipintzen dugu jakiteko oraindik abestirik ez dela erreproduzitu)
    
    /**
     * Reproduce una canción de un artista dado su ID y el índice de la canción. Artista baten abestia erreproduzitzen du haren ID eta abestiaren ID-ak kontuan harturik
     *
     * @param idArtista artistaren ID-a
     * @param abestiIndex abestiaren aurkibidea
     */
    public static void abestiaEntzun(int idArtista, int abestiIndex) {
        String audioIzena = "src/MediaM/" + idArtista + "_" + abestiIndex + ".wav";
        entzun(audioIzena);
    }
    
    
    /**
     *  hari den audioaren izena hartzen du
     *
     * @param idArtista artistaren ID-a
     * @param abestiIndex abestiaren aurkibidea
     * @return audioaren fitxategiaren izena
     */
    public static String erreproduzitzenDagoenAbestia(int idArtista, int abestiIndex) {
        String audioIzena = "src/MediaM/" + idArtista + "_" + abestiIndex + ".wav";
        return audioIzena;

    }
    
    /**
     * Podkast erreproduzitzen du podkaster ID eta podkast ID kontuan harturikk
     *
     * @param idPodcaster podkasterraren ID-a
     * @param idPodcast podkastaren ID-a
     */
    public static void podcastEntzun(int idPodcaster, int idPodcast) {
        String audioIzena = "src/MediaP/" + idPodcaster + "_" + idPodcast + ".wav";
        entzun(audioIzena);
    }
    
    /**
     * "camaron.wav". erreproduzitzen du.
     */
        public static void playCamaron() {
            try {
                File camaronFile = new File("src/MediaM/camaron.wav");
                if (camaronFile.exists()) {
                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(camaronFile));

                    clip.addLineListener(new LineListener() {
                        public void update(LineEvent event) {
                            if (event.getType() == LineEvent.Type.STOP) {

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
    

        /**
         *  Audioa erreproduzitzen du beraren izenarekin (fitxategietan begiratzen)
         *
         * @param audioIzena audioaren fitxategiaren izena
         */
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
    
    /**
     * Hurrengo abestiaren aurkibidea lortzen du ausazko moduan
     *
     * @return hurrengo abestiaren aurkibidea
     */
    public static int hurrengoRandom() {
        int hurrengoko;
        do {
            hurrengoko = (int)(Math.random() * askenAbesti) + 1;
        } while (hurrengoko == azkenAbesti);

        azkenAbesti = hurrengoko;
        return hurrengoko;
    }

    /**
     * Hurrengo abestiaren aurkibidea lortzen du baina modu ordenatuan
     *
     * @param currentIndex momentu onetako abestiaren aurkibidea
     * @return hurrengo abestiaren aurkibidea
     */
    public static int hurrengoOrdenatua(int currentIndex) {
        return (currentIndex % askenAbesti) + 1;
    }

    /**
     * Abestia gelditu eta erreproduzitu
     */
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

    /**
     * Audioak hasieratik erreproduzitzen da.
     */
    public static void replay() {
        if (clip != null) {
            clip.setFramePosition(0); // Hasierara joan
            clip.start();
        }
    }

    /**
     * Hartutako audioaren fitxategia erreproduzitzen du
     *
     * @param audioFitxa audioaren fitxategia
     */
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
    
    
    /**
     * Bezero mota llortzen du, beraren ID-aren arabera (FREE edo Premium)
     *
     * @param cboxAbestia audioaren ID-a
     * @return bezero mota
     */
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
    
    /**
     * Playlist guztiak lortzen ditu
     *
     * @return zerrenda bat playlist-en izenekin
     */
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

    /**
     *  Playlist-ak eguneratzen du abesti berriekin
     *
     * @param aukeratutakoPlayList playlist-aren izena
     * @param erreproduzitzenDagoenAbestia gehituko den abestiaren id-a
     */
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
