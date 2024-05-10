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

    // Audio guztien zerrenda atera
    public static List<String> IdLortu() {
        List<String> IdLista = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Connection conn = Konexioa.konektatu();

            // SQL-ren audio lista atera gero konparatu ahal izateko
            String query = "SELECT IDAudio FROM Audioa";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Emaitzak rekorritu eta audioekin konparatu
            while (resultSet.next()) {
                IdLista.add(resultSet.getString("Izena"));
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

        return IdLista;
    }

    public static File[] AudioMediaAtera() {
        // SQL-ko izenen zerrenda lortu
        List<String> Idak = IdLortu();

        // File objetuen array
        List<File> Artxiboak = new ArrayList<>();

        // Beste karpeta batean daudenez eta izena ez denez berdina, bidea sortu behar da eskuz
        for (String Id : Idak) {
            String path = "media/" + Id + ".wav";
            File file = new File(path);
            if (file.exists()) {
                Artxiboak.add(file);
            } else {
                System.err.println(path + "fitxategia ez da agertzen: ");
            }
        }

        // File-en lista array bihurtu
        File[] audioFiles = Artxiboak.toArray(new File[0]);

        return audioFiles;
    }

    public static void playEmon(File archivoAudio) {
        try {
            // Verificar que el archivo de audio exista
            if (archivoAudio.exists()) {
                Desktop.getDesktop().open(archivoAudio);
            } else {
                System.err.println("El archivo de audio no existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
}
