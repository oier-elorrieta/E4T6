package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public AdminMenuaVi(String erabiltzailea) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton MusikaDeskubrituBtn = new JButton("Musika Kudeatu");
        MusikaDeskubrituBtn.setBounds(130, 61, 155, 23);
        contentPane.add(MusikaDeskubrituBtn);
        MusikaDeskubrituBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MusikaKudeatzaileaVi musikaKudeatzaileaFrame = new MusikaKudeatzaileaVi(erabiltzailea);
                musikaKudeatzaileaFrame.setVisible(true);
                setVisible(false);
            }
        });

        JButton PodcastBtn = new JButton("Podcastak kudeatu");
        PodcastBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 PodcastKudeatzaileaVi podcastKudeatzaileaFrame = new PodcastKudeatzaileaVi(erabiltzailea);
                podcastKudeatzaileaFrame.setVisible(true);
                 setVisible(false);
            }
        });
        PodcastBtn.setBounds(130, 107, 155, 23);
        contentPane.add(PodcastBtn);

        JButton NirePlaylistBtn = new JButton("Estatistikak");
        NirePlaylistBtn.setBounds(130, 155, 155, 23);
        contentPane.add(NirePlaylistBtn);

        NirePlaylistBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
            }
        });

        JLabel AukeratuLbl = new JLabel("AUKERATU");
        AukeratuLbl.setBounds(174, 25, 106, 14);
        contentPane.add(AukeratuLbl);

        JButton AtzeraBotoia = new JButton("Atzera");
        AtzeraBotoia.setBounds(163, 227, 89, 23);
        contentPane.add(AtzeraBotoia);
    }
}