import javax.swing.*;
import java.awt.*;

public class Verification extends JFrame {
    public Verification() {
        setTitle("Verification");
        setSize(375, 812);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Title
        JLabel title = new JLabel("Verification");
        title.setFont(new Font("Alata", Font.PLAIN, 24));
        title.setBounds(28, 94, 200, 30);
        add(title);

        // Subtitle
        JLabel subtitle = new JLabel("<html>We’ve sent you the verification code to your email.<br>Enter code to continue.</html>");
        subtitle.setFont(new Font("Alata", Font.PLAIN, 15));
        subtitle.setBounds(28, 138, 300, 50);
        add(subtitle);

        // Code Boxes
        int[] boxX = {35, 119, 203, 287};
        for (int i = 0; i < 4; i++) {
            JPanel box = new JPanel();
            box.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            box.setBounds(boxX[i], 215, 55, 55);
            JLabel digit = new JLabel("4", SwingConstants.CENTER);
            digit.setFont(new Font("Alata", Font.PLAIN, 24));
            box.add(digit);
            add(box);
        }

        // Timer
        JLabel timer = new JLabel("Re-send code in 0:20", SwingConstants.CENTER);
        timer.setFont(new Font("Alata", Font.PLAIN, 15));
        timer.setBounds(114, 392, 200, 30);
        add(timer);

        // Continue Button
        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("Alata", Font.BOLD, 16));
        continueButton.setBackground(new Color(255, 149, 0));
        continueButton.setForeground(Color.WHITE);
        continueButton.setBorderPainted(false);
        continueButton.setOpaque(true);                       // Allow background to show
        //continueButton.setBorderPainted(false);  
        continueButton.setBounds(52, 310, 271, 58);
        add(continueButton);

        // Keypad panel
        JPanel keypad = new JPanel(new GridLayout(4, 3, 10, 10));
        keypad.setBounds(6, 554, 360, 216);
        String[] keys = {
            "1", "2 ABC", "3 DEF",
            "4 GHI", "5 JKL", "6 MNO",
            "7 PQRS", "8 TUV", "9 WXYZ",
            "*", "0", "#"
        };
        for (String key : keys) {
            JPanel keyPanel = new JPanel(new BorderLayout());
            keyPanel.setBackground(Color.WHITE);
            keyPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            JLabel keyLabel = new JLabel("<html><center>" + key.replace(" ", "<br>") + "</center></html>", SwingConstants.CENTER);
            keyLabel.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
            keyPanel.add(keyLabel, BorderLayout.CENTER);
            keypad.add(keyPanel);
        }
        add(keypad);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Verification vs = new Verification();
            vs.setVisible(true);
        });
    }
}
