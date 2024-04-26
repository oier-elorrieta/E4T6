package Vista;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DB.DBBezeroak;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Artista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox_1;

    public Artista(int cboxaukera) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel DiskaZerLbl = new JLabel("Diska Zerrenda");
        DiskaZerLbl.setBounds(62, 28, 90, 14);
        contentPane.add(DiskaZerLbl);
        
        
        JLabel InformazioaLbl = new JLabel("Informazioa");
        InformazioaLbl.setBounds(279, 28, 68, 14);
        contentPane.add(InformazioaLbl);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(10, 53, 205, 22);
        contentPane.add(comboBox);
        
        List<String> albumak = DBBezeroak.MusikariarenAlbumak(cboxaukera);
        for (String artista : albumak) {
            comboBox.addItem(artista); 
        }
        
        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(225, 53, 199, 22);
        contentPane.add(comboBox_1);
    }
}