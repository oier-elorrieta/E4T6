package DB;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBErreproduktorea {


    
    public static void audioEntzun(int id) {
        String audioIzena ="Media/" + id + ".wav"; // Suponiendo que los archivos se llamen audio1.wav, audio2.wav, etc.
       // String path = "media/" + audioIzena;
        File archivo = new File(audioIzena);
        if (archivo.exists()) {
            playEmon(archivo);
        } else {
            System.out.println("El archivo de audio '" + audioIzena + "' no se encontró.");
        }
    }

    public static void playEmon(File audioFitxa) {
        try {
            if (audioFitxa.exists()) {
                Desktop.getDesktop().open(audioFitxa);
            } else {
                System.out.println("El archivo de audio no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
    
}
