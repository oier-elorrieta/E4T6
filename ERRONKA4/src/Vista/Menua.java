package Vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menua extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Menua() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton MusikaDeskubrituBtn = new JButton("Musika Deskubritu");
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