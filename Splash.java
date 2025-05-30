import javax.swing.*;
import java.awt.*;

public class Splash extends JPanel {

    public Splash() {
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);
        setLayout(null);
        addSplashText();
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

    // Main method for standalone testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Find the FunKtion - Splash");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new Splash());
            frame.setVisible(true);
        });
    }
}
