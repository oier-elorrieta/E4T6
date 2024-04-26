package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DB.DBBezeroak;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldErabiltzailea;
    private JTextField textFieldPasahitza;

    public LogIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textFieldErabiltzailea = new JTextField();
        textFieldErabiltzailea.setBounds(183, 60, 155, 20);
        contentPane.add(textFieldErabiltzailea);
        textFieldErabiltzailea.setColumns(10);
        
        textFieldPasahitza = new JTextField();
        textFieldPasahitza.setBounds(183, 122, 155, 20);
        contentPane.add(textFieldPasahitza);
        textFieldPasahitza.setColumns(10);
        
        JLabel Erabiltzailealbl = new JLabel("Erabiltzailea:");
        Erabiltzailealbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Erabiltzailealbl.setBounds(36, 63, 89, 14);
        contentPane.add(Erabiltzailealbl);
        
        JLabel Pasahitzalbl = new JLabel("Pasahitza:");
        Pasahitzalbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Pasahitzalbl.setBounds(36, 125, 96, 14);
        contentPane.add(Pasahitzalbl);
        
        JLabel Izenburualbl = new JLabel("Log-In");
        Izenburualbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Izenburualbl.setBounds(187, 11, 70, 20);
        contentPane.add(Izenburualbl);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bezero", "Admin"}));
        comboBox.setBounds(140, 171, 129, 22);
        contentPane.add(comboBox);
        
        JButton LogInBotoia = new JButton("LogIn");
        LogInBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Erabiltzailea = textFieldErabiltzailea.getText();
                String Pasahitza = textFieldPasahitza.getText();
                
                boolean isloginok = DBBezeroak.isLoginOk(Erabiltzailea, Pasahitza);
        
                if(isloginok) {
                    Menua menua = new Menua();
                    menua.setVisible(true);
                }
            }
        });
                    
        LogInBotoia.setBounds(60, 214, 89, 23);
        contentPane.add(LogInBotoia);
        
        JButton ErregistratuBotoia = new JButton("Erregistratu");
        ErregistratuBotoia.setBounds(270, 214, 103, 23);
        contentPane.add(ErregistratuBotoia);
        
        ErregistratuBotoia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Erregistroa erregistroaFrame = new Erregistroa();
                erregistroaFrame.setVisible(true);
                setVisible(false);
            }
        });
    }
}