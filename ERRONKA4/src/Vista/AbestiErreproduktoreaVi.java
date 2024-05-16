package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DB.DBErreproduktorea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AbestiErreproduktoreaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private int artistId;
    private int currentSongIndex;
    private int maxSongIndex;
    private boolean erreproduzitzen = false;
    private boolean isPremium; // Bezero mota gordetzeko
    private static Clip clip;
    private int kont = 0;

    public AbestiErreproduktoreaVi(String erabiltzailea, int cboxAbestia, String cboxAbestiaIzena, int cBoxArtistaList) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        artistId = cBoxArtistaList;
        currentSongIndex = 0; // Lehenengo abestian hasteko
        maxSongIndex = 3; // Abeslari bakoitzaren kanta maximoa

        JButton menuaBtn = new JButton("Menua");
        menuaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String entzutenDenAbestia = DBErreproduktorea.erreproduzitzenDagoenAbestia(cBoxArtistaList, currentSongIndex + 1);
               
                List<String> playlists = DBErreproduktorea.playListakLortu();
                if (playlists.isEmpty()) {
                    System.out.println("Ez dago playlist-ik aurkitu.");
                    return;
                }
                String selectedPlaylist = (String) JOptionPane.showInputDialog(null,
                        "Aukeratu playlist-a:",
                        "Playlist-ak",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        playlists.toArray(),
                        playlists.get(0));

                if (selectedPlaylist != null) {
                    DBErreproduktorea.aktualizatuPlayList(selectedPlaylist, cboxAbestia); // cboxAbestia aldagaia erreproduzitzenDagoenAbestia aldagaia ordez
                } else {
                    System.out.println("Playlist-a ez da aukeratu.");
                }
            }
        });
        menuaBtn.setBounds(10, 168, 89, 23);
        contentPane.add(menuaBtn);
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
        gustokoaBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            String gustokoaPlaylist = "Gustokoak"; 

            DBErreproduktorea.gustokoakPlayList( cboxAbestia); 
            	    }

            	});

        textField = new JTextField();
        textField.setBounds(13, 202, 411, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton profilaBtn = new JButton(erabiltzailea);
        profilaBtn.setBounds(345, 11, 89, 23);
        contentPane.add(profilaBtn);
        
        JLabel abestiIzenaLbl = new JLabel("");
        abestiIzenaLbl.setBounds(10, 143, 414, 14);
        contentPane.add(abestiIzenaLbl);
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
                    DBErreproduktorea.abestiaEntzun(artistId, currentSongIndex + 1);
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
                if (isPremium) {
                    currentSongIndex = DBErreproduktorea.hurrengoOrdenatua(currentSongIndex);
                } else {
                	kont++;
                	if(kont == 2) {
                	IragarkiaVi iragarkiFrame = new IragarkiaVi();
                	iragarkiFrame.setVisible(true);
                	erreproduzitzen = false;
                	}else {
                	}
                    currentSongIndex = DBErreproduktorea.hurrengoRandom();
                
                }
                DBErreproduktorea.abestiaEntzun(artistId, currentSongIndex);
                erreproduzitzen = true;
            }
        });

        atzeraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isPremium) {
                    currentSongIndex = (currentSongIndex - 1 + maxSongIndex) % maxSongIndex;
                    if (currentSongIndex == 0) {
                        currentSongIndex = maxSongIndex;
                    }
                } else {  
                	
                    currentSongIndex = DBErreproduktorea.hurrengoRandom();
                }
                DBErreproduktorea.abestiaEntzun(artistId, currentSongIndex);
                erreproduzitzen = true;
            }
        });
    }
}
