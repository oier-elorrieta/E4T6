package Vista;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import DB.DBArtista;
import DB.DBPodcast;
import Modelo.Podcast;


public class PodcasterrakVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int cBoxPodcasterAukera;

    public PodcasterrakVi(String erabiltzailea){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> PodcasterraCBox = new JComboBox<>();
        PodcasterraCBox.setModel(new DefaultComboBoxModel(new String[] {""}));
        PodcasterraCBox.setBounds(51, 79, 346, 44);
        contentPane.add(PodcasterraCBox);
        
        List<String> Podcasterrak = DBPodcast.PodcasterrakDescubritu();
        for (String podcasterra : Podcasterrak) {
            PodcasterraCBox.addItem(podcasterra); 
        }
        
        PodcasterraCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cBoxPodcasterAukera = PodcasterraCBox.getSelectedIndex();
                PodcastListaVi podcastFrame= new PodcastListaVi(erabiltzailea, cBoxPodcasterAukera);
                podcastFrame.setVisible(true);
                
                dispose();
            }
        }); 

        JButton AtzeraBotoia = new JButton("Atzera");
        AtzeraBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuaVi menuaframe= new MenuaVi(erabiltzailea);
                menuaframe.setVisible(true);
                setVisible(false);
            }
        });
        AtzeraBotoia.setBounds(23, 227, 89, 23);
        contentPane.add(AtzeraBotoia);
        
     
        JLabel Izenburua = new JLabel("Aukeratu Podcasterra");
        Izenburua.setFont(new Font("Tahoma", Font.PLAIN, 40));
        Izenburua.setBounds(36, 11, 388, 57);
        contentPane.add(Izenburua);
    }
}