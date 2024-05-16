package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MusikaKudeatzaileaVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MusikaKudeatzaileaVi(String erabiltzailea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton artistakBtn = new JButton("Artistak");
		artistakBtn.setBounds(137, 46, 89, 23);
		contentPane.add(artistakBtn);
		artistakBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 AdminMenuaVi adminMenuaFrame = new AdminMenuaVi(erabiltzailea);
	            	 adminMenuaFrame.setVisible(true);
	                 setVisible(false);
	            }
	        });
		
		JButton albumakBtn = new JButton("Albumak");
		albumakBtn.setBounds(137, 93, 89, 23);
		contentPane.add(albumakBtn);
		
		JButton kantakBtn = new JButton("Kantak");
		kantakBtn.setBounds(137, 144, 89, 23);
		contentPane.add(kantakBtn);
		
		JButton atzeraBtn = new JButton("Atzera");
		atzeraBtn.setBounds(10, 227, 89, 23);
		contentPane.add(atzeraBtn);
		  atzeraBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               AdminMenuaVi adminMenuaframe= new AdminMenuaVi(erabiltzailea);
	                adminMenuaframe.setVisible(true);
	                setVisible(false);
	            }
	        });
	}
}
