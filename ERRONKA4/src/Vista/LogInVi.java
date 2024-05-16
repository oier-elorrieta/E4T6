package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBLogIn;
import Salbuespenak.LogInSalbuespena;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldErabiltzailea;
    private JTextField textFieldPasahitza;
    private int cboxAukera;

    public LogInVi() {
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
        
        JComboBox bezEdoAdminCbox = new JComboBox();
        bezEdoAdminCbox.setModel(new DefaultComboBoxModel(new String[] {"Bezero", "Admin"}));
        bezEdoAdminCbox.setBounds(140, 171, 129, 22);
        contentPane.add(bezEdoAdminCbox);
        
        bezEdoAdminCbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
            	cboxAukera =  bezEdoAdminCbox.getSelectedIndex();
                
                
            }
        });
        
        JButton LogInBotoia = new JButton("LogIn");
        LogInBotoia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String erabiltzailea = textFieldErabiltzailea.getText();
                String pasahitza = textFieldPasahitza.getText();
                
                boolean isLoginOk = false;
				try {
					isLoginOk = DBLogIn.isLoginOk(erabiltzailea, pasahitza);
				} catch (LogInSalbuespena e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                	if(isLoginOk == true) {
                    if(cboxAukera == 0 ) {
                	MenuaVi menua = new MenuaVi(erabiltzailea);
                    menua.setVisible(true);
                    }else if(cboxAukera == 1){
                    	AdminMenuaVi adminMenuaFrame = new AdminMenuaVi(erabiltzailea);
                        adminMenuaFrame.setVisible(true);
                    }
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
                ErregistroaVi erregistroaFrame = new ErregistroaVi();
                erregistroaFrame.setVisible(true);
                setVisible(false);
            }
        });
    }
}