import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ResetPassword extends JFrame {
    private JTextField emailField;
    private boolean isUpperCase = false; // Track uppercase/lowercase state
    private ArrayList<JButton> letterButtons = new ArrayList<>(); // Keep track of letter buttons to update text
    private JButton shiftButton;

    public ResetPassword() {
        setTitle("Reset Password");
        setSize(375, 780);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Status bar time
        JLabel timeLabel = new JLabel("9:41");
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        timeLabel.setForeground(new Color(0x120D26));
        timeLabel.setBounds(21, 7, 50, 20);
        add(timeLabel);

        // Back button
        JButton backButton = new JButton("\u2190"); // Unicode left arrow
        backButton.setBounds(24, 53, 40, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
        // Placeholder action – replace with actual navigation
        backButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(this, "Back button clicked!");
        });
    
        add(backButton);

        // Title
        JLabel titleLabel = new JLabel("Reset Password");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0x120D26));
        titleLabel.setBounds(28, 94, 300, 30);
        add(titleLabel);

        // Subtitle
        JLabel subtitleLabel = new JLabel("<html>Please enter your email address<br>to request a password reset.</html>");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        subtitleLabel.setForeground(new Color(0x120D26));
        subtitleLabel.setBounds(28, 130, 300, 50);
        add(subtitleLabel);

        // Email field
        emailField = new JTextField();
        emailField.setBounds(28, 190, 317, 56);
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        emailField.setBorder(BorderFactory.createLineBorder(new Color(0xE4DFDF), 1));
        emailField.setBackground(Color.WHITE);
        emailField.setMargin(new Insets(10, 15, 10, 15));
        add(emailField);

        // SEND button
        JButton sendButton = new JButton("SEND");
        sendButton.setBounds(52, 260, 271, 58);
        sendButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(new Color(0xFF9500)); // Orange
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createEmptyBorder());
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sendButton.setOpaque(true);
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF9500), 1, true)); // Rounded feel
        add(sendButton);

        sendButton.addActionListener(_ -> {
            String email = emailField.getText();
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email address.");
            } else {
                JOptionPane.showMessageDialog(null, "Reset link sent to: " + email);
            }
        });

        // Custom mobile-style keyboard
        JPanel keyboardPanel = createMobileKeyboardPanel();
        keyboardPanel.setBounds(0, 350, 375, 380);
        add(keyboardPanel);
    }

    private JPanel createMobileKeyboardPanel() {
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 1, 5, 5));
        keyboardPanel.setBackground(new Color(245, 245, 245));

        // Clear letterButtons list on rebuild
        letterButtons.clear();

        // Keyboard rows including Shift key added in the 4th row
        String[] rows = {
            "1 2 3 4 5 6 7 8 9 0",
            "Q W E R T Y U I O P",
            "A S D F G H J K L",
            "SHIFT Z X C V B N M _ - @ .",
            "SPACE DEL ENTER"
        };

        for (String row : rows) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 2));
            rowPanel.setOpaque(false);

            for (String key : row.split(" ")) {
                JButton button;

                switch (key) {
                    case "SPACE" -> {
                        button = createKeyButton(" ");
                        button.setPreferredSize(new Dimension(120, 40));
                        button.setText("SPACE");
                    }
                    case "DEL" -> {
                        button = new JButton("⌫");
                        button.setPreferredSize(new Dimension(60, 40));
                        button.addActionListener(_ -> {
                            String text = emailField.getText();
                            if (!text.isEmpty()) {
                                emailField.setText(text.substring(0, text.length() - 1));
                            }
                        });
                    }
                    case "ENTER" -> {
                        button = new JButton("⏎");
                        button.setPreferredSize(new Dimension(60, 40));
                        button.addActionListener(_ ->
                                JOptionPane.showMessageDialog(null,
                                        "Reset link sent to: " + emailField.getText()));
                    }
                    case "SHIFT" -> {
                        button = new JButton("Shift");
                        button.setPreferredSize(new Dimension(60, 40));
                        shiftButton = button;
                        updateShiftButtonStyle();
                        button.addActionListener(_ -> {
                            isUpperCase = !isUpperCase;
                            updateKeysCase();
                            updateShiftButtonStyle();
                        });
                    }
                    default -> {
                        // If it's a letter key, adjust case accordingly
                        String displayKey = isUpperCase ? key.toUpperCase() : key.toLowerCase();
                        button = createKeyButton(displayKey);

                        // Track letter buttons only (letters and underscore, dash, @, . are not letters)
                        if (key.matches("[a-zA-Z]")) {
                            letterButtons.add(button);
                        }
                    }
                }

                styleKeyButton(button);
                rowPanel.add(button);
            }

            keyboardPanel.add(rowPanel);
        }

        return keyboardPanel;
    }

    private JButton createKeyButton(String key) {
        JButton button = new JButton(key);
        button.setPreferredSize(new Dimension(32, 40));
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.addActionListener((ActionEvent _) -> {
            emailField.setText(emailField.getText() + button.getText());
        });
        return button;
    }

    private void styleKeyButton(JButton button) {
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        button.setBackground(Color.WHITE);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void updateKeysCase() {
        for (JButton btn : letterButtons) {
            String currentText = btn.getText();
            if (isUpperCase) {
                btn.setText(currentText.toUpperCase());
            } else {
                btn.setText(currentText.toLowerCase());
            }
        }
    }

    private void updateShiftButtonStyle() {
        if (shiftButton != null) {
            if (isUpperCase) {
                shiftButton.setBackground(new Color(0xFF9500)); // Orange when active
                shiftButton.setForeground(Color.WHITE);
            } else {
                shiftButton.setBackground(Color.WHITE);
                shiftButton.setForeground(Color.BLACK);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResetPassword ui = new ResetPassword();
            ui.setVisible(true);
        });
    }
}