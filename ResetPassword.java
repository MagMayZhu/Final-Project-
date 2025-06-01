import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ResetPassword extends JPanel {
    private JTextField emailField;
    private boolean isUpperCase = false; // Track uppercase/lowercase state
    private ArrayList<JButton> letterButtons = new ArrayList<>(); // Keep track of letter buttons to update text
    private JButton shiftButton;
    private final AppController controller;

    public ResetPassword(AppController controller) {
        this.controller = controller;

        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(375, 812));

        addBackButton();
        addTitleAndSubtitle();
        addEmailField();
        addSendButton();
        addKeyboard();
    }

    private void addBackButton() {
        JButton backButton = new JButton("\u2190");
        backButton.setBounds(10, 10, 60, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("Alata", Font.BOLD, 25));

        backButton.addActionListener(_ -> {
            if (controller != null) controller.showSignIn();
        });
        add(backButton);
    }

    private void addTitleAndSubtitle() {
        JLabel titleLabel = new JLabel("Reset Password");
        titleLabel.setFont(new Font("sansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0x120D26));
        titleLabel.setBounds(28, 94, 300, 30);
        add(titleLabel);

        JLabel subtitleLabel = new JLabel("<html>Please enter your email address<br>to request a password reset.</html>");
        subtitleLabel.setFont(new Font("sansSerif", Font.PLAIN, 15));
        subtitleLabel.setForeground(new Color(0x120D26));
        subtitleLabel.setBounds(28, 130, 300, 50);
        add(subtitleLabel);
    }

    private void addEmailField() {
        emailField = createPlaceholderField("Email", 28, 190, 317, 40);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(0xE4DFDF), 1));
        emailField.setBackground(Color.WHITE);
        emailField.setMargin(new Insets(10, 15, 10, 15));
    }

    private void addSendButton() {
        JButton sendButton = new JButton("SEND");
        sendButton.setBounds(52, 260, 271, 58);
        sendButton.setFont(new Font("sansSerif", Font.BOLD, 16));
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(new Color(0xFF9500));
        styleButton(sendButton, null);
        sendButton.setOpaque(true);
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(0xFF9500), 1, true));
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        sendButton.addActionListener(_ -> {
        String email = emailField.getText().trim();
        if (email.isEmpty()|| email.equals("Email")) {
            JOptionPane.showMessageDialog(this, "Please enter your email address.");
        } else {
            JOptionPane.showMessageDialog(this, "Reset link sent to: " + email);
        }
    });

        add(sendButton);
    }

    private void addKeyboard() {
        JPanel keyboardPanel = createMobileKeyboardPanel();
        keyboardPanel.setBounds(0, 432, 375, 380);
        add(keyboardPanel);
    }

    private JPanel createMobileKeyboardPanel() {
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(new GridLayout(5, 1, 5, 5));
        keyboardPanel.setBackground(new Color(245, 245, 245));

        letterButtons.clear();

        String[] rows = {
                "1 2 3 4 5 6 7 8 9 0",
                "q w e r t y u i o p",
                "a s d f g h j k l",
                "SHIFT z x c v b n m DEL",
                "_ - @ SPACE . ENTER"
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
                        button.setText(" ");
                    }
                    case "DEL" -> {
                        button = new JButton("⌫");
                        button.setPreferredSize(new Dimension(50, 40));
                        button.addActionListener(_ -> {
                            String text = emailField.getText();
                            if (!text.isEmpty() && !text.equals("Email")) {
                                emailField.setText(text.substring(0, text.length() - 1));
                            }
                        });
                    }
                    case "ENTER" -> {
                        button = new JButton("\u2192");
                        button.setPreferredSize(new Dimension(60, 40));
                        button.addActionListener(_ -> {
        String email = emailField.getText().trim();
        if (email.isEmpty() || email.equals("Email")) {
            JOptionPane.showMessageDialog(this, "Please enter your email address.");
        } else {
            JOptionPane.showMessageDialog(this, "Reset link sent to: " + email);
        }
    });
                    }
                    case "SHIFT" -> {
                        button = new JButton("Shift");
                        button.setPreferredSize(new Dimension(50, 40));
                        shiftButton = button;
                        updateShiftButtonStyle();
                        button.addActionListener(_ -> {
                            isUpperCase = !isUpperCase;
                            updateKeysCase();
                            updateShiftButtonStyle();
                        });
                    }
                    default -> {
                        String displayKey = isUpperCase ? key.toUpperCase() : key.toLowerCase();
                        button = createKeyButton(displayKey);
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
        button.setFont(new Font("sansSerif", Font.PLAIN, 14));
        button.addActionListener(_ -> {
            if (emailField.getText().equals("Email")) {
                emailField.setText("");
                emailField.setForeground(Color.BLACK);
            }
            emailField.setText(emailField.getText() + button.getText());
        });

        return button;
    }

    private void styleButton(JButton button, Font font) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        if (font != null) {
            button.setFont(font);
        }
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
            btn.setText(isUpperCase ? currentText.toUpperCase() : currentText.toLowerCase());
        }
    }

    private void updateShiftButtonStyle() {
        if (shiftButton != null) {
            if (isUpperCase) {
                shiftButton.setBackground(new Color(0xFF9500));
                shiftButton.setForeground(Color.WHITE);
            } else {
                shiftButton.setBackground(Color.WHITE);
                shiftButton.setForeground(Color.BLACK);
            }
        }
    }

    private JTextField createPlaceholderField(String placeholder, int x, int y, int width, int height) {
        JTextField field = new JTextField(placeholder);
        field.setForeground(Color.GRAY);
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
        add(field);
        return field;
    }

    // For testing only
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Reset Password");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ResetPassword(null)); // pass actual controller here
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}