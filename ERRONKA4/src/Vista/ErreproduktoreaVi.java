package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import DB.DBErreproduktorea;

public class ErreproduktoreaVi extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private File Aukera; 
    /**
     * Create the frame.
     */
    public ErreproduktoreaVi(String erabiltzailea, File Aukera) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton menuaBtn = new JButton("Menua");
        menuaBtn.setBounds(10, 168, 89, 23);
        contentPane.add(menuaBtn);

        JButton atzeraBtn = new JButton("<");
        atzeraBtn.setBounds(109, 168, 41, 23);
        contentPane.add(atzeraBtn);

        JButton playBtn = new JButton("Play");
        playBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (Aukera != null && Aukera.exists()) {
                    DBErreproduktorea.playEmon(Aukera);
                } else {
                    System.err.println("Ez da abestirik aukeratu");
                }
            }
        });
        playBtn.setBounds(170, 168, 89, 23);
        contentPane.add(playBtn);

        JButton aurreraBtn = new JButton(">");
        aurreraBtn.setBounds(284, 168, 41, 23);
        contentPane.add(aurreraBtn);

        JButton gustokoaBtn = new JButton("Gustokoa");
        gustokoaBtn.setBounds(335, 168, 89, 23);
        contentPane.add(gustokoaBtn);

        textField = new JTextField();
        textField.setBounds(13, 202, 411, 48);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton profilaBtn = new JButton(erabiltzailea);
        profilaBtn.setBounds(345, 11, 89, 23);
        contentPane.add(profilaBtn);
        profilaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfilaVi profilaFrame = new ProfilaVi(erabiltzailea);
                profilaFrame.setVisible(true);
            }
        });

        this.Aukera = Aukera;
    }
}
