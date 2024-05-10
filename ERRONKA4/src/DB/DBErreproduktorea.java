package DB;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBErreproduktorea {

    // Audio guztien zerrenda atera
    public static List<String> MediaLortu() {
        List<String> AudioLista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Connection conn = Konexioa.konektatu();

            // SQL-ren audio lista atera gero konparatu ahal izateko
            String query = "SELECT Izena FROM Audioa";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Emaitzak rekorritu eta audioekin konparatu
            while (resultSet.next()) {
                AudioLista.add(resultSet.getString("Izena"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return AudioLista;
    }

    public static File[] AudioMediaAtera() {
        // SQL-ko izenen zerrenda lortu
        List<String> mediaIzenak = MediaLortu();

        // File objetuen array
        List<File> Artxiboak = new ArrayList<>();

        // Beste karpeta batean daudenez eta izena ez denez berdina, bidea sortu behar da eskuz
        for (String mediaIzena : mediaIzenak) {
            String path = "media/" + mediaIzena + ".wav";
            File file = new File(path);
            if (file.exists()) {
                Artxiboak.add(file);
            } else {
                System.err.println("El archivo no existe: " + path);
            }
        }

        // File-en lista array bihurtu
        File[] audioFiles = Artxiboak.toArray(new File[0]);

        return audioFiles;
    }
    
    public static Map<String, File> obtenerCancionesConArchivos() {
        // Abesti lista lortu datubasetik
        List<String> AbestiIzenak = MediaLortu();

       // Audioen fitxategiak lortu
        File[] AudioFitxategiak = AudioMediaAtera();

        // Crear un HashMap para mapear las canciones con sus archivos de audio
        Map<String, File> IzenEtaFitxategi = new HashMap<>();

        // Verificar que el tamaño de ambas listas sea el mismo
        if (AbestiIzenak.size() == AudioFitxategiak.length) {
            // Asociar cada canción con su respectivo archivo de audio
            for (int i = 0; i < AbestiIzenak.size(); i++) {
                String AbestiIzena = AbestiIzenak.get(i);
                File AudioFitxategi = AudioFitxategiak[i];

                // Verificar si la canción ya está enlazada con otro archivo de audio
                if (IzenEtaFitxategi.containsKey(AbestiIzena)) {
                    System.out.println(AbestiIzena + " audio fitxategiarekin bat dago");
                } else {
                    // Asociar la canción con su archivo de audio
                	IzenEtaFitxategi.put(AbestiIzena, AudioFitxategi);
                }
            }
        } else {
            System.out.println("Abesti kantitatea eta audioen fitxategia EZ da berdina");
        }

        return IzenEtaFitxategi;
    }
    
    
}
