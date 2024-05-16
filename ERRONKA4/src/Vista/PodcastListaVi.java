package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import DB.DBPodcast;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;



public class PodcastListaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int cboxPodcastAukera;
    private String cboxPodcastAukeraIzena;

   
    public PodcastListaVi(String erabiltzailea, int cboxPodcasterAukera) {
   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
       
        JLabel DiskaZerLbl = new JLabel("Podcast Zerrenda");
        DiskaZerLbl.setFont(new Font("Tahoma", Font.PLAIN, 30));
        DiskaZerLbl.setBounds(101, 11, 248, 39);
        contentPane.add(DiskaZerLbl);
       
        JComboBox<String> PodcastZerrendaCBox = new JComboBox<>();
        PodcastZerrendaCBox.setBounds(73, 61, 290, 62);
        contentPane.add(PodcastZerrendaCBox);
       
        JButton AtzeraBotoia = new JButton("Atzera");
        AtzeraBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            PodcasterrakVi menuaframe= new PodcasterrakVi(erabiltzailea);
                menuaframe.setVisible(true);
                setVisible(false);
            }
        });
        AtzeraBotoia.setBounds(23, 227, 89, 23);
        contentPane.add(AtzeraBotoia);
       

        ArrayList<Integer> IDAudio = DBPodcast.IDAudio(cboxPodcasterAukera);
        System.out.println(IDAudio);
       
        List<String> podcastak = DBPodcast.PodcastAtera(IDAudio);
        for (String podcast : podcastak) {
            PodcastZerrendaCBox.addItem(podcast);    
        }    
         
       PodcastZerrendaCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            cboxPodcastAukera = PodcastZerrendaCBox.getSelectedIndex();
            cboxPodcastAukeraIzena = PodcastZerrendaCBox.getSelectedItem().toString();

                 PodcastErreproduktoreaVi podcastErreprodukzioaFrame = new PodcastErreproduktoreaVi(erabiltzailea, cboxPodcasterAukera, cboxPodcastAukeraIzena, cboxPodcastAukera + 1);
                 podcastErreprodukzioaFrame.setVisible(true);
                 dispose();
             }
         });
       
     
               

       
     
       
    }
}
