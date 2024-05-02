package Vista;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBArtista;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class AlbumVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public AlbumVi(int cBoxArtista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel abestiaklbl = new JLabel("Abestiak");
		abestiaklbl.setBounds(55, 18, 46, 14);
		contentPane.add(abestiaklbl);

		JComboBox<String> abestiakCBox = new JComboBox<String>();
		abestiakCBox.setBounds(37, 43, 146, 36);
		contentPane.add(abestiakCBox);
		
		
		int iDaudio = DBArtista.IDAudio(cBoxArtista + 1);
	
		List<String> abestiak = DBArtista.AbestiakAtera(iDaudio);
		for (String abestia : abestiak) {
			abestiakCBox.addItem(abestia);     
    }   
	}
	}
