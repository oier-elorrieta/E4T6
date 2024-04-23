package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBBezeroak;
import Modelo.Bezeroa;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Erregistroa extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField IzenaTextField;
    private JTextField ErabiltzaileaTextField;
    private JTextField PasahitzaTextField;
    private JTextField KonfirmTextField;
    private JTextField JaiotzeDataTextField;
    private JTextField ErregistroDataTextField;
    private JTextField PremiumMugaTextField;
    private JTextField AbizenakTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Erregistroa frame = new Erregistroa();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Erregistroa() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton AtzeraBtn = new JButton("Atzera");
        AtzeraBtn.setBounds(10, 227, 103, 23);
        contentPane.add(AtzeraBtn);
        AtzeraBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogIn loginframe = new LogIn();
                loginframe.setVisible(true);
                setVisible(false);
            }
        });

        JLabel Izenalbl = new JLabel("Izena:");
        Izenalbl.setBounds(34, 11, 46, 14);
        contentPane.add(Izenalbl);

        // Other JLabels and JTextFields go here...

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"ES", "EU", "EN", "FR", "DE", "CA", "GA", "AR"}));
        comboBox.setBounds(90, 186, 139, 30);
        contentPane.add(comboBox);

        JButton EditatuBtn = new JButton("Editatu");
        EditatuBtn.setBounds(153, 227, 103, 23);
        contentPane.add(EditatuBtn);
        EditatuBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String izena = IzenaTextField.getText();
                String abizena = AbizenakTextField.getText();
                String erabiltzailea = ErabiltzaileaTextField.getText();
                String pasahitza = PasahitzaTextField.getText();
                String jaiotzeDataString = JaiotzeDataTextField.getText();
                String erregistroDataString = ErregistroDataTextField.getText();
                String hizkuntza = (String) comboBox.getSelectedItem();
                if (hizkuntza != null) {
                    System.out.println("Opción seleccionada: " + hizkuntza);
                } else {
                    System.out.println("Ninguna opción seleccionada.");
                }

                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date jaiotzeUtilDate = null;
                java.util.Date erregistroUtilDate = null;
                try {
                    jaiotzeUtilDate = sdf.parse(jaiotzeDataString);
                    erregistroUtilDate = sdf.parse(erregistroDataString);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                java.sql.Date jaiotzeDate = new java.sql.Date(jaiotzeUtilDate.getTime());
                java.sql.Date erregistroDate = new java.sql.Date(erregistroUtilDate.getTime());

                Bezeroa nb = new Bezeroa(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzeDate, erregistroDate);
                DBBezeroak.BezeroaGorde(nb);

                JButton ErosPremBtn = new JButton("Erosi Premium");
                ErosPremBtn.setBounds(286, 227, 124, 23);
                contentPane.add(ErosPremBtn);
                ErosPremBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Action for ErosPremBtn
                    }
                });
            }
        });
    }
}