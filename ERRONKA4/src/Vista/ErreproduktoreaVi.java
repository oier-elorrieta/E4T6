package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.DBErreproduktorea;

public class ErreproduktoreaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private int artistId;
    private int currentSongIndex;
    private int maxSongIndex;
    private boolean erreproduzitzen = false;

    public ErreproduktoreaVi(String erabiltzailea, int cboxAbestia, int cBoxArtistaList) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        artistId = cBoxArtistaList;
        currentSongIndex = 0; // Lehehengo abestian hasteko
        maxSongIndex = 3; // Abeslari bakotzairen kanta ajustatuta

        JButton menuaBtn = new JButton("Menua");
        menuaBtn.setBounds(10, 168, 89, 23);
        contentPane.add(menuaBtn);

        JButton atzeraBtn = new JButton("<");
        atzeraBtn.setBounds(109, 168, 41, 23);
        contentPane.add(atzeraBtn);

        JButton playBtn = new JButton("Play");
        playBtn.setBounds(170, 168, 89, 23);
        contentPane.add(playBtn);

        JButton aurreraBtn = new JButton(">");
        aurreraBtn.setBounds(284, 168, 41, 23);
        contentPane.add(aurreraBtn);

        JButton gustokoaBtn = new JButton("Gustokoa");
        gustokoaBtn.setBounds(335, 168, 89, 23);
        contentPane.add(gustokoaBtn);

        textField = new JTextField();
        textField.setBounds(13, 202, 411, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton profilaBtn = new JButton(erabiltzailea);
        profilaBtn.setBounds(345, 11, 89, 23);
        contentPane.add(profilaBtn);
        profilaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
            }
        });

        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!erreproduzitzen) {
                     playBtn.setText("Pause");    
                    DBErreproduktorea.audioEntzun(artistId, currentSongIndex + 1);
                    erreproduzitzen = true;
                } else {
                    erreproduzitzen = false;
                    playBtn.setText("Play");
                    DBErreproduktorea.playEtaPausa();
                }
            }
        });
   
        
        aurreraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSongIndex = (currentSongIndex + 1) % maxSongIndex;//Hemen egiten dena, abestia +1, horrela hurrengo abestia ipiniko da erreproduktorean, gainera maxSongIndex erabiltzen dugu ipini ahal EZ izateko hurrengo abestia existitzen ez baldin bada
                DBErreproduktorea.audioEntzun(artistId, currentSongIndex + 1);
                erreproduzitzen = true;
                
            }
        });
        
        atzeraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentSongIndex = (currentSongIndex - 1 + maxSongIndex) % maxSongIndex; //Hurrengo abestiaren berdina baina alderantziz
                DBErreproduktorea.audioEntzun(artistId, currentSongIndex + 1);
            }
        });
    }
}