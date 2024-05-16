package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class PodcastKudeatzaileaVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public PodcastKudeatzaileaVi(String erabiltzailea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton podcasterSortuBtn = new JButton("Podcaster Sortu");
		podcasterSortuBtn.setBounds(35, 71, 139, 23);
		contentPane.add(podcasterSortuBtn);
		
		JButton podcastSortuBtn = new JButton("Podcast Sortu");
		podcastSortuBtn.setBounds(249, 71, 120, 23);
		contentPane.add(podcastSortuBtn);
		
		JButton atzeraBtn = new JButton("Atzera");
		atzeraBtn.setBounds(163, 201, 89, 23);
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
