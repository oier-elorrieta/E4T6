package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menua extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menua frame = new Menua();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menua() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton MusikaDeskubrituBtn = new JButton("M"
        		+ "usika Deskubritu");
        MusikaDeskubrituBtn.setBounds(130, 61, 155, 23);
        contentPane.add(MusikaDeskubrituBtn);
        MusikaDeskubrituBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArtistaList ArtistaListFrame = new ArtistaList();
                ArtistaListFrame.setVisible(true);
                setVisible(false);
            }
        });
        
        JButton PodcastBtn = new JButton("Podcastak deskubritu");
        PodcastBtn.setBounds(130, 107, 155, 23);
        contentPane.add(PodcastBtn);
        
        JButton NirePlaylistBtn = new JButton("Nire PLaylist-ak");
        NirePlaylistBtn.setBounds(130, 155, 155, 23);
        contentPane.add(NirePlaylistBtn);
        
        JLabel AukeratuLbl = new JLabel("AUKERATU");
        AukeratuLbl.setBounds(179, 25, 59, 14);
        contentPane.add(AukeratuLbl);
        
        JButton AtzeraBotoia = new JButton("Atzera");
        AtzeraBotoia.setBounds(27, 209, 89, 23);
        contentPane.add(AtzeraBotoia);
        
        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(317, 209, 89, 23);
        contentPane.add(btnNewButton_1);
    }
}