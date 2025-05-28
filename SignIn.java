import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignIn extends JFrame {

    public SignIn() {
        // Frame setup
        setTitle("Find the FunKtion - Sign In");
        setSize(375, 812);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);  // Using absolute layout for pixel-accurate placement

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
        JLabel forgotPassword = new JLabel("Forgot Password?");
        forgotPassword.setFont(new Font("Alata", Font.PLAIN, 14));
        forgotPassword.setBounds(237, 420, 150, 25);
        add(forgotPassword);

        // Sign In Button
        JButton signInButton = new JButton("SIGN IN");
        signInButton.setFont(new Font("Alata", Font.BOLD, 16));
        signInButton.setBackground(new Color(255, 149, 0));
        signInButton.setForeground(Color.WHITE);
        signInButton.setOpaque(true);                       // Allow background to show
        signInButton.setBorderPainted(false);               // Optional: cleaner look
        signInButton.setBounds(52, 479, 271, 58);
        add(signInButton);

        // OR separator
        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        orLabel.setForeground(new Color(157, 152, 152));
        orLabel.setBounds(175, 561, 50, 25);
        add(orLabel);

        // Sign up prompt
        JLabel signUpPrompt = new JLabel("<html>Don’t have an account? <font color='#FF9500'>Sign up</font></html>");
        signUpPrompt.setFont(new Font("Alata", Font.PLAIN, 15));
        signUpPrompt.setBounds(79, 595, 250, 25);
        add(signUpPrompt);

        setVisible(true);

        
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
        new SignIn();
    }
}


    

