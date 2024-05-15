package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import DB.DBErregistroa;
import DB.DBProfila;
import Modelo.Bezeroa;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProfilaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField izenaTextField;
    private JTextField erabiltzaileaTextField;
    private JTextField pasahitzaTextField;
    private JTextField konfirmatuTextField;
    private JTextField jaiotzeDataTextField;
    private JTextField erregistroDataTextField;
    private JTextField premiumMugaTextField;
    private JTextField abizenaTextField;

    public ProfilaVi(String Erabiltzailea) {
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
                LogInVi loginframe = new LogInVi();
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
        comboBox.setBounds(100, 184, 139, 30);
        contentPane.add(comboBox);

        JLabel erabiltzaileaLbl = new JLabel("Erabiltzailea:");
        erabiltzaileaLbl.setBounds(34, 36, 67, 14);
        contentPane.add(erabiltzaileaLbl);
        
        JLabel pasahitzaLbl = new JLabel("Pasahitza");
        pasahitzaLbl.setBounds(34, 59, 46, 14);
        contentPane.add(pasahitzaLbl);
        
        JLabel konfirmatuLbl = new JLabel("Konfirmatu:");
        konfirmatuLbl.setBounds(34, 84, 67, 14);
        contentPane.add(konfirmatuLbl);
        
        JLabel jaiotzeDataLbl = new JLabel("Jaiotze data:");
        jaiotzeDataLbl.setBounds(34, 109, 72, 14);
        contentPane.add(jaiotzeDataLbl);
        
        JLabel erregistroalbl = new JLabel("Erregistro data:");
        erregistroalbl.setBounds(34, 134, 79, 14);
        contentPane.add(erregistroalbl);
        
        JLabel premiumugalbl = new JLabel("Premium muga:");
        premiumugalbl.setBounds(34, 159, 79, 14);
        contentPane.add(premiumugalbl);
        
        JLabel hizkuntzaLbl = new JLabel("Hizkuntza:");
        hizkuntzaLbl.setBounds(34, 186, 67, 14);
        contentPane.add(hizkuntzaLbl);
        
        izenaTextField = new JTextField();
        izenaTextField.setBounds(72, 8, 134, 20);
        contentPane.add(izenaTextField);
        izenaTextField.setColumns(10);
        
        erabiltzaileaTextField = new JTextField();
        erabiltzaileaTextField.setColumns(10);
        erabiltzaileaTextField.setBounds(100, 33, 106, 20);
        contentPane.add(erabiltzaileaTextField);
        
        erabiltzaileaTextField.setEditable(false);
        
        pasahitzaTextField = new JTextField();
        pasahitzaTextField.setColumns(10);
        pasahitzaTextField.setBounds(90, 56, 116, 20);
        contentPane.add(pasahitzaTextField);
        
        konfirmatuTextField = new JTextField();
        konfirmatuTextField.setColumns(10);
        konfirmatuTextField.setBounds(100, 81, 106, 20);
        contentPane.add(konfirmatuTextField);
        
        jaiotzeDataTextField = new JTextField();
        jaiotzeDataTextField.setColumns(10);
        jaiotzeDataTextField.setBounds(100, 106, 106, 20);
        contentPane.add(jaiotzeDataTextField);
        
        erregistroDataTextField = new JTextField();
        erregistroDataTextField.setColumns(10);
        erregistroDataTextField.setBounds(110, 131, 96, 20);
        contentPane.add(erregistroDataTextField);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date egunerakoData = new Date();
        erregistroDataTextField.setText(sdf.format(egunerakoData));
        
        premiumMugaTextField = new JTextField();
        premiumMugaTextField.setColumns(10);
        premiumMugaTextField.setBounds(120, 153, 86, 20);
        contentPane.add(premiumMugaTextField);
        
        abizenaTextField = new JTextField();
        abizenaTextField.setColumns(10);
        abizenaTextField.setBounds(289, 8, 135, 20);
        contentPane.add(abizenaTextField);
        
        JLabel abizenaLbl = new JLabel("Abizena:");
        abizenaLbl.setBounds(233, 11, 46, 14);
        contentPane.add(abizenaLbl);
        
        
        //Bezeroen informazioa erakusteko
        Bezeroa bezeroa = DBProfila.bezeroaLortu(Erabiltzailea);
            izenaTextField.setText(bezeroa.getIzena());
            abizenaTextField.setText(bezeroa.getAbizena());
            erabiltzaileaTextField.setText(bezeroa.getErabiltzailea());
            pasahitzaTextField.setText(bezeroa.getPasahitza());
            jaiotzeDataTextField.setText(bezeroa.getJaiotzedata().toString()); 
            erregistroDataTextField.setText(bezeroa.getErregistrodata().toString());
            premiumMugaTextField.setText(""); 
            
            
           
            
        JButton editatuGordeBtn = new JButton("Aldaketak Gorde");
        editatuGordeBtn.setBounds(123, 227, 156, 23);
        contentPane.add(editatuGordeBtn);
        editatuGordeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	
                String izena = izenaTextField.getText();
                String abizena = abizenaTextField.getText();
                String erabiltzailea = erabiltzaileaTextField.getText();
                String pasahitza = pasahitzaTextField.getText();
                String jaiotzeDataString = jaiotzeDataTextField.getText();
                String erregistroDataString = erregistroDataTextField.getText();
                String hizkuntza = (String) comboBox.getSelectedItem();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date jaiotzeUtilDate = null;
                Date erregistroUtilDate = null;
                try {
                    jaiotzeUtilDate = sdf.parse(jaiotzeDataString);
                    erregistroUtilDate = sdf.parse(erregistroDataString);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                java.sql.Date jaiotzeDate = new java.sql.Date(jaiotzeUtilDate.getTime());
                java.sql.Date erregistroDate = new java.sql.Date(erregistroUtilDate.getTime());

                Bezeroa nb = new Bezeroa(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzeDate, erregistroDate);

                if(DBProfila.bezKomparaketa(bezeroa, nb) == false){ 
                	DBProfila.aktualizatuBezeroa(nb, Erabiltzailea);         
        }
            }
        });

        JButton ErosPremBtn = new JButton("Erosi Premium");
        ErosPremBtn.setBounds(286, 227, 124, 23);
        contentPane.add(ErosPremBtn);
        ErosPremBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String izena = izenaTextField.getText();
                String abizena = abizenaTextField.getText();
                String erabiltzailea = erabiltzaileaTextField.getText();
                String pasahitza = pasahitzaTextField.getText();
                String jaiotzeDataString = jaiotzeDataTextField.getText();
                String erregistroDataString = erregistroDataTextField.getText();
                String hizkuntza = (String) comboBox.getSelectedItem();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                Date jaiotzeUtilDate = null;
                Date erregistroUtilDate = null;
                try {
                    jaiotzeUtilDate = sdf.parse(jaiotzeDataString);
                    erregistroUtilDate = sdf.parse(erregistroDataString);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                java.sql.Date jaiotzeDate = new java.sql.Date(jaiotzeUtilDate.getTime());
                java.sql.Date erregistroDate = new java.sql.Date(erregistroUtilDate.getTime());

                Bezeroa nb = new Bezeroa(izena, abizena, hizkuntza, erabiltzailea, pasahitza, jaiotzeDate, erregistroDate);
                DBErregistroa.BezeroaGorde(nb);

                try {
                    erregistroUtilDate = sdf.parse(erregistroDataTextField.getText());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                // Calendar objektua sortu eta erregistroData-ren data ezarri
                Calendar cal = Calendar.getInstance();
                cal.setTime(erregistroDate);

                // erregistroData-ren data bati urte bat gehitu
                cal.add(Calendar.YEAR, 1);

                // premiumMugaData-ren data erregistroData-ren data bati urte bat gehituta lortu
                java.util.Date premiumMugaDate = cal.getTime();

                // Bi hiztegi erabiliz iraungitako data testu-kate bihurtu nahi dugu
                String premiumMugaDataString = sdf.format(premiumMugaDate);

                // premiumMugaTextField-en testu-kate hori ezarri
                premiumMugaTextField.setText(premiumMugaDataString);

                DBErregistroa.PremiumDataGorde(DBErregistroa.idBezeroLortu(nb),premiumMugaDataString);
            }
        });
    }
}