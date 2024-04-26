package Vista;


import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBMenua;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ArtistaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> DeskribCBox;

    public ArtistaVi(int cboxaukera) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel DiskaZerLbl = new JLabel("Diska Zerrenda");
        DiskaZerLbl.setBounds(70, 28, 90, 14);
        contentPane.add(DiskaZerLbl);
        
        
        JLabel InformazioaLbl = new JLabel("Deskribapena");
        InformazioaLbl.setBounds(290, 28, 68, 14);
        contentPane.add(InformazioaLbl);
        
        JComboBox<String> diskaZerrendaCBox = new JComboBox<>();
        diskaZerrendaCBox.setBounds(10, 53, 205, 22);
        contentPane.add(diskaZerrendaCBox);
        
        List<String> albumak = DBMenua.MusikariarenAlbumak(cboxaukera);
        for (String artista : albumak) {
            diskaZerrendaCBox.addItem(artista); 
        }
        
        DeskribCBox = new JComboBox();
        DeskribCBox.setBounds(225, 53, 199, 22);
        contentPane.add(DeskribCBox);
    }
}