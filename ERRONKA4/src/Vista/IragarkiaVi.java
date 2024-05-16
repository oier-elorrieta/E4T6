package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class IragarkiaVi extends JFrame {
    private JPanel contentPane;

    public IragarkiaVi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Reproducir el archivo camaron.wav mientras la ventana está abierta
        playCamaron();
    }

    // Método para reproducir el archivo camaron.wav
    private void playCamaron() {
        try {
            File camaronFile = new File("src/MediaM/camaron.wav");
            if (camaronFile.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(camaronFile));
                clip.start();
            } else {
                System.out.println("camaron.wav ez da aurkitu");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Errora camaron.wav: erreproduzitzean" );
        }
    }
}
