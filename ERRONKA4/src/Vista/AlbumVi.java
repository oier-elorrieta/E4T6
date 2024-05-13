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
	private int cboxAbestia;
	private JTextField textField_1;
	
	public AlbumVi(String cboxDiska, String erabiltzailea) {
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
		abestiakCBox.setBounds(10, 77, 146, 36);
		contentPane.add(abestiakCBox);
		
		textField_1 = new JTextField();

		textField_1 .setBounds(159, 60, 265, 94);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String Deskribapena = DBArtista.albumarenInformazioa(cboxDiska);
		
		textField_1.setText(Deskribapena);
		
		System.out.println(cboxDiska);
		//abestiak comboboxean sartzeko
		List<String> abestiak = DBArtista.AbestiakAtera(cboxDiska);
		for (String abestia : abestiak) {
			abestiakCBox.addItem(abestia); 
			
			
			
			abestiakCBox.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
			 cboxAbestia = abestiakCBox.getSelectedIndex();
	           
             ErreproduktoreaVi ErreprodukzioaFrame= new ErreproduktoreaVi(erabiltzailea, cboxAbestia);
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
		erabiltzaileaBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    	ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
		    	
		    }
		});
			
    }   
	}
	}
