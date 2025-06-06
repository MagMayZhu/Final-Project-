import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Verification extends JPanel {
    private int currentDigitIndex = 0;
    private JLabel[] digitLabels = new JLabel[4];

    public Verification() {
        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

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
            box.setBounds(boxX[i], 225, 55, 55);
            box.setLayout(new BorderLayout());

            JLabel digitLabel = new JLabel("", SwingConstants.CENTER); // Empty by default
            digitLabel.setFont(new Font("Alata", Font.PLAIN, 24));
            digitLabels[i] = digitLabel;
            box.add(digitLabel, BorderLayout.CENTER);
            add(box);
        }

        // Continue Button
        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("Alata", Font.BOLD, 16));
        continueButton.setBackground(new Color(255, 149, 0));
        continueButton.setForeground(Color.WHITE);
        continueButton.setBorderPainted(false);
        continueButton.setOpaque(true);
        continueButton.setBounds(52, 310, 271, 58);
        add(continueButton);

        // Timer
        JLabel timer = new JLabel("Re-send code in 0:20", SwingConstants.CENTER);
        timer.setFont(new Font("Alata", Font.PLAIN, 15));
        timer.setBounds(114, 392, 200, 30);
        add(timer);

        // Keypad
        JPanel keypad = new JPanel(new GridLayout(4, 3, 10, 10));
        keypad.setBounds(6, 554, 360, 216);
        String[] keys = {
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "<", "0", "C"
        };

        for (String key : keys) {
            JButton keyButton = new JButton(key);
            keyButton.setFont(new Font("SF Pro Display", Font.PLAIN, 20));
            keyButton.setFocusPainted(false);
            keyButton.setBackground(Color.WHITE);
            keyButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            keyButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    handleKeyPress(key);
                }
            });

            keypad.add(keyButton);
        }

        add(keypad);
    }

    private void handleKeyPress(String key) {
        if (key.equals("C")) {
            // Clear all
            for (int i = 0; i < 4; i++) {
                digitLabels[i].setText("");
            }
            currentDigitIndex = 0;
        } else if (key.equals("<")) {
            // Backspace
            if (currentDigitIndex > 0) {
                currentDigitIndex--;
                digitLabels[currentDigitIndex].setText("");
            }
        } else if (key.matches("\\d") && currentDigitIndex < 4) {
            digitLabels[currentDigitIndex].setText(key);
            currentDigitIndex++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Verification");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Verification());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
