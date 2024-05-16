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


public class MusikariaKudeatuVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int cBoxArtistaList;

    public MusikariaKudeatuVi(String erabiltzailea) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> musikariCBox = new JComboBox<>();
        musikariCBox.setModel(new DefaultComboBoxModel(new String[] {""}));
        musikariCBox.setBounds(51, 79, 346, 44);
        contentPane.add(musikariCBox);
        
        List<String> musikariak = DBArtista.MusikariakDescubritu();
        for (String artista : musikariak) {
            musikariCBox.addItem(artista); 
        }
        
        musikariCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               cBoxArtistaList = musikariCBox.getSelectedIndex();
           
                ArtistaVi artistaframe= new ArtistaVi(cBoxArtistaList, erabiltzailea);
                artistaframe.setVisible(true);
                
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
        
        JButton erabiltzailebtn = new JButton(erabiltzailea);
        erabiltzailebtn.setBounds(335, 227, 89, 23);
        contentPane.add(erabiltzailebtn);
        erabiltzailebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    	ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
		    	
		    }
		});
        
        JLabel Izenburua = new JLabel("Aukeratu Musikaria");
        Izenburua.setFont(new Font("Tahoma", Font.PLAIN, 40));
        Izenburua.setBounds(51, 11, 346, 57);
        contentPane.add(Izenburua);
    }
}