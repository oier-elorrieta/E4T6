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

        String audioIzena ="Media/" + id + ".wav"; 
       // String path = "media/" + audioIzena;
        File Fitxa = new File(audioIzena);
        if (Fitxa.exists()) {
            playEmon(Fitxa);
        } else {
            System.out.println(audioIzena + "' ez da aurkitu");
        }

    }

    public static void playEmon(File audioFitxa) {
        try {
            if (audioFitxa.exists()) {
                Desktop.getDesktop().open(audioFitxa);
            } else {
                System.out.println("Audio fitxategia ez da existitzen");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage()+ "Audioa erreprodukziorakoan ");
        }
    }
    }


/*
public static void audioEntzun(int id) {
    // getProperty erabiltzen da jakin ahal izateko orain erabiltzen hari garen direktorioa
    String directorioActual = System.getProperty("user.dir");

    // Erabiltzen hari garen direktorioaren bidea, Media karpeta eta bilatu nahi dugun media artxiboa konbinatzen ditugu
    String audioIzena = directorioActual + File.separator + "Media" + File.separator + id + ".wav";

    // Crear el objeto File con la ruta completa del archivo de audio
    File archivo = new File(audioIzena);
    
    if (archivo.exists()) {
        playEmon(archivo);
    } else {
        System.out.println("El archivo de audio '" + audioIzena + "' no se encontró.");
    }
}

*/
