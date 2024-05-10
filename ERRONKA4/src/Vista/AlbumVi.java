package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBArtista;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlbumVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	public AlbumVi(int cboxArtista, String erabiltzailea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel abestiaklbl = new JLabel("Abestiak");
		abestiaklbl.setBounds(62, 42, 46, 14);
		contentPane.add(abestiaklbl);

		JComboBox<String> abestiakCBox = new JComboBox<String>();
		abestiakCBox.setBounds(21, 77, 146, 36);
		contentPane.add(abestiakCBox);
		
		System.out.println(cboxArtista + 1);
		
		//abestiak comboboxean sartzeko
		List<String> abestiak = DBArtista.AbestiakAtera(cboxArtista);
		for (String abestia : abestiak) {
			abestiakCBox.addItem(abestia);  
		System.out.println(abestia);
			
		
		JLabel deskribapenaLbl = new JLabel("Deskribapena");
		deskribapenaLbl.setBounds(277, 42, 79, 14);
		contentPane.add(deskribapenaLbl);
		
		textField = new JTextField();
		textField.setBounds(219, 77, 188, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton erabiltzaileaBtn = new JButton(erabiltzailea);
		erabiltzaileaBtn.setBounds(321, 11, 89, 23);
		contentPane.add(erabiltzaileaBtn);
		erabiltzaileaBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    	ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
		    	
		    }
		});
	
		
		
		
			
    }   
	}
	}
