import javax.swing.*;
import java.awt.*;

public class Splash extends JPanel {
    private AppController controller;

    public Splash(AppController controller) {
        this.controller = controller;

        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);
        setLayout(null);
        addSplashText();

        // Auto transition to SignIn after 2.5 seconds
        Timer timer = new Timer(2500, e -> controller.showSignIn());
        timer.setRepeats(false);
        timer.start();
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
}
