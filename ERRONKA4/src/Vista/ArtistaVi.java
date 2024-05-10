package Vista;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.DBArtista;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ArtistaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int cboxArtista;

    
    public ArtistaVi(int cboxArtistaList) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel DiskaZerLbl = new JLabel("Diska Zerrenda");
        DiskaZerLbl.setBounds(38, 11, 90, 14);
        contentPane.add(DiskaZerLbl);
        
        
        JLabel informazioalbl = new JLabel("Informazioa");
        informazioalbl.setBounds(261, 11, 68, 14);
        contentPane.add(informazioalbl);
        
        JComboBox<String> diskaZerrendaCBox = new JComboBox<>();
        diskaZerrendaCBox.setBounds(10, 36, 128, 22);
        contentPane.add(diskaZerrendaCBox);
        
        
        List<String> albumak = DBArtista.MusikariarenAlbumak(cboxArtistaList);
        for (String album : albumak) {
            diskaZerrendaCBox.addItem(album);     
        }    
        
       
       diskaZerrendaCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           cboxArtista = diskaZerrendaCBox.getSelectedIndex();
           
               AlbumVi albumViFrame= new AlbumVi(cboxArtista);
               albumViFrame.setVisible(true);
               dispose();
                
               
            }
        }); 
        
        
        JTextArea InformazioaTextArea = new JTextArea();
        InformazioaTextArea.setTabSize(5);
        InformazioaTextArea.setLineWrap(true);
        InformazioaTextArea.setWrapStyleWord(true);
        InformazioaTextArea.setEditable(false);
        InformazioaTextArea.setBounds(159, 35, 265, 94);
        contentPane.add(InformazioaTextArea);
        
        JLabel argazkiaJLbl = new JLabel("");
        argazkiaJLbl.setBounds(159, 140, 265, 110);
        contentPane.add(argazkiaJLbl);
        
      
        
        List<String> Deskribapenak = DBArtista.MusikariarenInformazioa(cboxArtistaList);
        for (String deskribapena : Deskribapenak) {
            InformazioaTextArea.setText(deskribapena);    
       }
       
    }
}