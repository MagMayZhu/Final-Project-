import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignIn extends JPanel
{
    private static final Color ORANGE = new Color(0xFF9500);
    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JCheckBox rememberMe;
    private JButton forgotPassword;
    private JButton signInButton;
    private JButton goToSignUpButton;
    private final String passwordPlaceholder = "Your password";
    private final boolean[] isPasswordPlaceholder = {true};

    private AppController controller;

    public SignIn(AppController controller)
    {
        this.controller = controller;

        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        addTitle();
        addSignInLabel();
        addEmailField();
        addPasswordField();
        addShowPasswordCheckbox();
        addRememberMeCheckbox();
        addForgotPasswordButton();
        addSignInButton();
        addSignUpPrompt();
    }

    private void addTitle()
    {
        JLabel title = new JLabel("Find the FunKtion");
        title.setFont(new Font("Alata", Font.BOLD, 28));
        title.setBounds((375 - 300) / 2, 155, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);
    }

    private void addSignInLabel()
    {
        JLabel signInLabel = new JLabel("Sign in");
        signInLabel.setFont(new Font("Alata", Font.PLAIN, 24));
        signInLabel.setBounds(29, 215, 200, 30);
        add(signInLabel);
    }

    private void addEmailField()
    {
        emailField = new JTextField("Email");
        emailField.setFont(new Font("Alata", Font.PLAIN, 14));
        emailField.setForeground(Color.GRAY);
        emailField.setBounds((375 - 317) / 2, 275, 317, 40);
        addPlaceholderBehavior(emailField, "Email");
        add(emailField);
    }

    private void addPasswordField()
    {
        passwordField = new JPasswordField(passwordPlaceholder);
        passwordField.setFont(new Font("Alata", Font.PLAIN, 14));
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds((375 - 317) / 2, 345, 317, 40);
        add(passwordField);

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

        add(passwordField);
    }

    private void addShowPasswordCheckbox()
    {
        showPassword = new JCheckBox("Show Password");
        showPassword.setFont(new Font("Alata", Font.PLAIN, 12));
        showPassword.setBounds(226, 390, 120, 20);
        showPassword.setOpaque(false);
        showPassword.addActionListener(e -> {
            if (!isPasswordPlaceholder[0]) {
                passwordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '•');
            }
        });
        add(showPassword);
    }

    private void addRememberMeCheckbox()
    {
        rememberMe = new JCheckBox("Remember Me");
        rememberMe.setFont(new Font("Alata", Font.PLAIN, 12));
        rememberMe.setBounds(34, 390, 120, 20);
        rememberMe.setOpaque(false);
        add(rememberMe);
    }

    private void addForgotPasswordButton()
    {
        forgotPassword = new JButton("Forgot Password");
        forgotPassword.setFont(new Font("Alata", Font.PLAIN, 14));
        forgotPassword.setBounds((375-200)/2, 415, 200, 25);
        forgotPassword.setForeground(ORANGE);
        forgotPassword.setBorderPainted(false);
        forgotPassword.setContentAreaFilled(false);
        forgotPassword.setFocusPainted(false);
        forgotPassword.setOpaque(false);
        forgotPassword.addActionListener(e -> {
            if (controller != null) controller.showResetPassword();
            else JOptionPane.showMessageDialog(this, "Redirecting to Reset Password page...");}
        );
        add(forgotPassword);
    }

    private void addSignInButton()
    {
        signInButton = new JButton("SIGN IN");
        signInButton.setFont(new Font("Alata", Font.BOLD, 16));
        signInButton.setBackground(ORANGE);
        signInButton.setForeground(Color.WHITE);
        signInButton.setOpaque(true);
        signInButton.setBorderPainted(false);
        signInButton.setBounds(52, 465, 271, 58);
        signInButton.addActionListener(e -> {
    
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (email.equals("Email") || email.isEmpty() ||
            password.equals(passwordPlaceholder) || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter both email and password.");
            return;
        }

        if (authenticateUser(email, password))
        {
            if (controller != null) controller.showHome();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Incorrect login credentials. Please try again.");
        }
        });
        add(signInButton);
    }

    private void addSignUpPrompt()
    {
        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        orLabel.setForeground(new Color(157, 152, 152));
        orLabel.setBounds(175, 537, 50, 25);
        add(orLabel);

        JLabel promptLabel = new JLabel("Don't have an account? ");
        promptLabel.setFont(new Font("Alata", Font.PLAIN, 15));
        promptLabel.setBounds(79, 571, 200, 25);
        add(promptLabel);

        goToSignUpButton = new JButton("Sign up");
        goToSignUpButton.setFont(new Font("Alata", Font.PLAIN, 15));
        goToSignUpButton.setForeground(ORANGE);
        goToSignUpButton.setBounds(240, 571, 100, 25);
        goToSignUpButton.setBorderPainted(false);
        goToSignUpButton.setContentAreaFilled(false);
        goToSignUpButton.setFocusPainted(false);
        goToSignUpButton.setOpaque(false);
        goToSignUpButton.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "Redirecting to Sign Up page...")
        );

        goToSignUpButton.addActionListener(e -> {
        if (controller != null) controller.showSignUp();
        });

        add(goToSignUpButton);
    }

    private void addPlaceholderBehavior(JTextComponent field, String placeholder)
    {
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

    private boolean authenticateUser(String email, String password)
    {
        String query = "SELECT * FROM \"Users\" WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query))
        {
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery())
            {
                return rs.next(); // returns true if a match is found
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error connecting to database:\n" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Find the FunKtion - Sign In");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);

            // Pass null since we're just testing the SignUp UI
            frame.setContentPane(new SignIn(null));
            frame.setVisible(true);
        });
    }
}
