package DB;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class DBErreproduktorea {
    
     private static Clip clip;

        public static void audioEntzun(int idArtista, int idAbestia) {
            String audioIzena = "src/Media/" + idArtista + "_" + idAbestia + ".wav";
            File fitxa = new File(audioIzena);

            if (fitxa.exists()) {
                // // Abestirenbat momentu berdinean entzuten bada gelditzen da
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                }
                // Abesti berriaren erreprodukzioa hasten da
                playEmon(fitxa);
            } else {
                System.out.println(audioIzena + " ez da aurkitu");
            }
        }

       
        public static void playEtaPausa() {
            if (clip != null) {
                if (clip.isRunning()) {
                    clip.stop(); // Erreprodukzioa pausatzen du erreproduzitzen baldin ba zegoen
                } else {
                    int posizioa = clip.getFramePosition();
                    clip.setFramePosition(posizioa); //abestia gelditzeko zegoen puntuan
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


        private static void playEmon(File audioFitxa) {
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
    }