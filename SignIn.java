import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignIn extends JPanel {

    public SignIn() {
        // Frame setup
        setLayout(null);  // Using absolute layout for pixel-accurate placement
        setPreferredSize(new Dimension(375, 812));  // Panel size

        // Title
        JLabel title = new JLabel("Find the FunKtion");
        title.setFont(new Font("Alata", Font.PLAIN, 28));
        title.setBounds(54, 148, 300, 40);
        add(title);

        // Sign In Label
        JLabel signInLabel = new JLabel("Sign in");
        signInLabel.setFont(new Font("Alata", Font.PLAIN, 24));
        signInLabel.setBounds(29, 216, 200, 30);
        add(signInLabel);

        // Email field with placeholder
        JTextField emailField = new JTextField("abc@email.com");
        emailField.setFont(new Font("Alata", Font.PLAIN, 14));
        emailField.setForeground(Color.GRAY);
        emailField.setBounds(28, 269, 317, 56);
        addPlaceholderBehavior(emailField, "abc@email.com");
        add(emailField);

        // Placeholder tracker
final String passwordPlaceholder = "Your password";
final boolean[] isPasswordPlaceholder = {true};  // use array to modify in lambdas

// Password field
JPasswordField passwordField = new JPasswordField(passwordPlaceholder);
passwordField.setFont(new Font("Alata", Font.PLAIN, 14));
passwordField.setForeground(Color.GRAY);
passwordField.setEchoChar((char) 0); // Show text as-is
passwordField.setBounds(28, 345, 317, 56);
add(passwordField);

// Show Password Checkbox
JCheckBox showPassword = new JCheckBox("Show Password");
showPassword.setFont(new Font("Alata", Font.PLAIN, 14));
showPassword.setBounds(230, 400, 150, 25);
showPassword.setOpaque(false);
add(showPassword);

// Focus behavior for placeholder
passwordField.addFocusListener(new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent e) {
        if (isPasswordPlaceholder[0]) {
            passwordField.setText("");
            passwordField.setForeground(Color.BLACK);
            passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•');
            isPasswordPlaceholder[0] = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (passwordField.getPassword().length == 0) {
            passwordField.setText(passwordPlaceholder);
            passwordField.setForeground(Color.GRAY);
            passwordField.setEchoChar((char) 0);
            isPasswordPlaceholder[0] = true;
        }
    }
});

// Checkbox logic
showPassword.addActionListener(e -> {
    if (!isPasswordPlaceholder[0]) {
        passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•');
    }
});


// Toggle password visibility
showPassword.addActionListener(e -> {
    String placeholder = "Your password";
    if (showPassword.isSelected()) {
        // Only show actual password if not showing placeholder
        if (!String.valueOf(passwordField.getPassword()).equals(placeholder)) {
            passwordField.setEchoChar((char) 0);
        }
    } else {
        if (!String.valueOf(passwordField.getPassword()).equals(placeholder)) {
            passwordField.setEchoChar('•');
        }
    }
});



        // Remember me switch (simulated with checkbox)
        JCheckBox rememberMe = new JCheckBox("Remember Me");
        rememberMe.setFont(new Font("Alata", Font.PLAIN, 14));
        rememberMe.setBounds(72, 420, 150, 25);
        rememberMe.setOpaque(false);
        add(rememberMe);

        // Forgot password
        JButton forgotPassword = new JButton("Forgot Password");
        forgotPassword.setFont(new Font("Alata", Font.PLAIN, 14));
        forgotPassword.setBounds(205, 420, 200, 25);
        
        //forgotPassword.setFont(new Font("Alata", Font.PLAIN, 15));
        forgotPassword.setForeground(Color.ORANGE);
        //forgotPassword.setBounds(240, 585, 100, 25);
        forgotPassword.setBorderPainted(false);
        forgotPassword.setContentAreaFilled(false);
        forgotPassword.setFocusPainted(false);
        forgotPassword.setOpaque(false);
        forgotPassword.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Redirecting to Reset Password page...");
            });
            add(forgotPassword);
        

        // Sign In Button
        JButton signInButtons = new JButton("SIGN IN");
        signInButtons.setFont(new Font("Alata", Font.BOLD, 16));
        signInButtons.setBackground(new Color(255, 149, 0));
        signInButtons.setForeground(Color.WHITE);
        signInButtons.setOpaque(true);                       // Allow background to show
        signInButtons.setBorderPainted(false);               // Optional: cleaner look
        signInButtons.setBounds(52, 479, 271, 58);
        add(signInButtons);

       

        // Sign up prompt
        
        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        orLabel.setForeground(new Color(157, 152, 152));
        orLabel.setBounds(175, 551, 50, 25);
        add(orLabel);
    
        JLabel promptLabel = new JLabel("Don't have an account? ");
        promptLabel.setFont(new Font("Alata", Font.PLAIN, 15));
        promptLabel.setBounds(79, 585, 200, 25);
        add(promptLabel);
    
        JButton signInButton = new JButton("Sign in");
        signInButton.setFont(new Font("Alata", Font.PLAIN, 15));
        signInButton.setForeground(Color.ORANGE);
        signInButton.setBounds(240, 585, 100, 25);
        signInButton.setBorderPainted(false);
        signInButton.setContentAreaFilled(false);
        signInButton.setFocusPainted(false);
        signInButton.setOpaque(false);
        signInButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Redirecting to Sign Up page...");
            });
        add(signInButton);

        
    }

    // Method to add placeholder behavior to text components
    private void addPlaceholderBehavior(JTextComponent field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar('•');
                    }
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                    if (field instanceof JPasswordField) {
                        ((JPasswordField) field).setEchoChar((char) 0);
            
                    }
                }
            }
            
        });
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Find the FunKtion - Sign In");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new SignIn());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


    

