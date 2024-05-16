package Vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.DBErreproduktorea;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class IragarkiaVi extends JFrame {
    private JPanel contentPane;

    public IragarkiaVi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel irudi = new JLabel();
        
        irudi.setBounds(115, 10, 231, 161);
        
        ImageIcon icon = new ImageIcon("src/MediaM/kamaronron.jpg");
        irudi.setIcon(icon);
        contentPane.add(irudi);

        DBErreproduktorea.playCamaron();
        
        
    } 
}
