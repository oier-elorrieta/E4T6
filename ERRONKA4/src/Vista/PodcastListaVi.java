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



public class PodcastListaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    
    public PodcastListaVi(String cboxPodcasterAukera) {
    	
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
        
        int IDPodcaster = DBPodcast.PodcasterID(cboxPodcasterAukera);
        System.out.println(IDPodcaster);
        
        ArrayList<Integer> IDAudio = DBPodcast.IDAudio(IDPodcaster); 
        System.out.println(IDAudio);
        
        List<String> podcastak = DBPodcast.PodcastAtera(IDAudio);
        for (String Izena : podcastak) {
            PodcastZerrendaCBox.addItem(Izena);     
        }    
        
       PodcastZerrendaCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
       
      
               
            }
        }); 
        
     
        
    }
}