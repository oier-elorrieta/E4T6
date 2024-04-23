package Vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import DB.DBBezeroak;
import javax.swing.DefaultComboBoxModel;

public class ArtistaList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int comboboxaukera;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArtistaList frame = new ArtistaList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ArtistaList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
        comboBox.setBounds(51, 79, 346, 44);
        contentPane.add(comboBox);
        
        List<String> musikariak = DBBezeroak.MusicaDescubritu();
        for (String artista : musikariak) {
            comboBox.addItem(artista); 
        }
        
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int comboxaukera = comboBox.getSelectedIndex();
           
                Artista artistaframe= new Artista(comboxaukera);
                artistaframe.setVisible(true);
                setVisible(false);
                
            }
            
            
        }); 

        JButton AtzeraBotoia = new JButton("Atzera");
        AtzeraBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menua menuaframe= new Menua();
                menuaframe.setVisible(true);
                setVisible(false);
            }
        });
        AtzeraBotoia.setBounds(23, 227, 89, 23);
        contentPane.add(AtzeraBotoia);
        
        JButton AurreraBotoia = new JButton("Aurrera");
        AurreraBotoia.setBounds(335, 227, 89, 23);
        contentPane.add(AurreraBotoia);

        AurreraBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Artista artistaframe = new Artista(0);
                artistaframe.setVisible(true);
                setVisible(false);
            }
        });
        
        JLabel Izenburua = new JLabel("Aukeratu Musikaria");
        Izenburua.setFont(new Font("Tahoma", Font.PLAIN, 40));
        Izenburua.setBounds(51, 11, 346, 57);
        contentPane.add(Izenburua);
    }
}