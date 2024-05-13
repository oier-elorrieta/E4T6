import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class DBErreproduktorea {

    private static Process currentProcess; // Erabiltzen da prozezua jarraitu ahal izateko, horrela gelditu eta hasi egin ahalko da.

    public static void audioEntzun(int id) {
        String audioIzena = "Media/" + id + ".wav";
        File Fitxa = new File(audioIzena);
        if (Fitxa.exists()) {
            playEmon(Fitxa);
        } else {
            System.out.println("El archivo de audio '" + audioIzena + "' no se encontró.");
        }
    }

    public static void playEmon(File audioFitxa) {
        try {
            if (audioFitxa.exists()) {
                currentProcess = Desktop.getDesktop().open(audioFitxa);
            } else {
                System.out.println("El archivo de audio no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }

    public static void audioPausa() {
        if (currentProcess != null) {
            currentProcess.destroy(); // Erreprodukzio prozezua gelditzen du
        }
    }

    public static void Hasi(int id) {
    	audioPausa(); // Audioa gelditzen du
        audioEntzun(id); // Berriro hasten da
    }
}


/* private static MediaPlayer mediaPlayer;

    public static void audioEntzun(int id) {
        String audioIzena = "Media/" + id + ".wav";
        Media media = new Media(new File(audioIzena).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static void audioPausa() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public static void Hasi(int id) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        audioEntzun(id);
    }
}*/
