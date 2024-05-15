package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DB.DBArtista;

public class AlbumVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int cboxAbestia;
    private String cboxAbestiaIzena;
    private JTextField textField_1;

    public AlbumVi(String cboxDiska, String erabiltzailea, int cBoxArtistaList) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel abestiaklbl = new JLabel("Abestiak");
        abestiaklbl.setBounds(62, 42, 46, 14);
        contentPane.add(abestiaklbl);

        JButton atzeraBtn = new JButton("Atzera");
        atzeraBtn.setBounds(10, 227, 89, 23);
        contentPane.add(atzeraBtn);
        atzeraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArtistaVi artistakframe = new ArtistaVi(1, erabiltzailea);
                artistakframe.setVisible(true);
                dispose();
            }
        });

        JComboBox<String> abestiakCBox = new JComboBox<String>();
        abestiakCBox.setBounds(10, 77, 146, 36);
        contentPane.add(abestiakCBox);

        textField_1 = new JTextField();
        textField_1.setBounds(159, 60, 265, 94);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        String Deskribapena = DBArtista.albumarenInformazioa(cboxDiska);
        textField_1.setText(Deskribapena);

        List<String> abestiak = DBArtista.AbestiakAtera(cboxDiska);
        for (String abestia : abestiak) {
            abestiakCBox.addItem(abestia);
        }

        abestiakCBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cboxAbestia = abestiakCBox.getSelectedIndex();
                cboxAbestiaIzena = abestiakCBox.getSelectedItem().toString();
                AbestiErreproduktoreaVi ErreprodukzioaFrame = new AbestiErreproduktoreaVi(erabiltzailea, cboxAbestia, cboxAbestiaIzena, cBoxArtistaList);
                ErreprodukzioaFrame.setVisible(true);
                dispose();
            }
        });

        JLabel deskribapenaLbl = new JLabel("Deskribapena");
        deskribapenaLbl.setBounds(277, 42, 79, 14);
        contentPane.add(deskribapenaLbl);

        JButton erabiltzaileaBtn = new JButton(erabiltzailea);
        erabiltzaileaBtn.setBounds(321, 11, 89, 23);
        contentPane.add(erabiltzaileaBtn);
       
        JPanel imgAlbum = new JPanel();
        imgAlbum.setBounds(255, 165, 101, 85);
        contentPane.add(imgAlbum);
        erabiltzaileaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
            }
        });
    }
}

	
