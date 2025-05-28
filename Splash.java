import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash() {
        setupFrame();
        addSplashText();
    }

    private void setupFrame() {
        setTitle("Find the FunKtion - Splash");
        setSize(375, 812);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    }

    private void addSplashText() {
        int marginLeft = 40;

        JLabel topText = new JLabel("Find the");
        topText.setFont(new Font("Alata", Font.BOLD, 36));
        topText.setForeground(Color.BLACK);
        topText.setBounds(marginLeft, 330, 300, 40);
        add(topText);

        JLabel bottomText = new JLabel("FunKtion");
        bottomText.setFont(new Font("Alata", Font.BOLD, 36));
        bottomText.setForeground(Color.BLACK);
        bottomText.setBounds(marginLeft, 370, 300, 50);
        add(bottomText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Splash splash = new Splash();
            splash.setVisible(true);
        });
    }
}
