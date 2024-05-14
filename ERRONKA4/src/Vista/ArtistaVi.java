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
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ArtistaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String cboxDiska;

    public ArtistaVi(int cBoxArtistaList, String erabiltzailea) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel DiskaZerLbl = new JLabel("Diska Zerrenda");
        DiskaZerLbl.setBounds(44, 40, 90, 14);
        contentPane.add(DiskaZerLbl);

        JLabel informazioalbl = new JLabel("Informazioa");
        informazioalbl.setBounds(263, 40, 68, 14);
        contentPane.add(informazioalbl);

        JComboBox<String> diskaZerrendaCBox = new JComboBox<>();
        diskaZerrendaCBox.setBounds(21, 71, 128, 22);
        contentPane.add(diskaZerrendaCBox);

        List<String> albumak = DBArtista.MusikariarenAlbumak(cBoxArtistaList);
        for (String album : albumak) {
            diskaZerrendaCBox.addItem(album);
        }

        diskaZerrendaCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cboxDiska = diskaZerrendaCBox.getSelectedItem().toString();
                AlbumVi albumViFrame= new AlbumVi(cboxDiska, erabiltzailea, cBoxArtistaList);
                albumViFrame.setVisible(true);
                dispose();
            }
        });

        JTextArea InformazioaTextArea = new JTextArea();
        InformazioaTextArea.setTabSize(5);
        InformazioaTextArea.setLineWrap(true);
        InformazioaTextArea.setWrapStyleWord(true);
        InformazioaTextArea.setEditable(false);
        InformazioaTextArea.setBounds(159, 60, 265, 94);
        contentPane.add(InformazioaTextArea);

        System.out.println(cBoxArtistaList);
        List<String> Deskribapenak = DBArtista.MusikariarenInformazioa(cBoxArtistaList);
        for (String deskribapena : Deskribapenak) {
            InformazioaTextArea.setText(deskribapena);
        }
        
        JButton atzeraBtn = new JButton("Atzera");
        atzeraBtn.setBounds(10, 227, 89, 23);
        contentPane.add(atzeraBtn);
        atzeraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArtistaListVi artistakframe= new ArtistaListVi(erabiltzailea);
                artistakframe.setVisible(true);
                setVisible(false);
            }
        });

        JButton erabiltzaileaBtn = new JButton(erabiltzailea);
        erabiltzaileaBtn.setBounds(322, 11, 89, 23);
        contentPane.add(erabiltzaileaBtn);

        erabiltzaileaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
            }
        });

        
    }
}