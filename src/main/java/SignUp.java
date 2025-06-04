import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp extends JPanel
{
    private static final Color ORANGE = new Color(0xFF9500);
    private final AppController controller;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;


    public SignUp(AppController controller)
    {
        this.controller = controller;

        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        addBackButton();
        addTitleLabel();
        addInputFields();
        addSignUpButton();
        addSignInLink();
    }

    private void addBackButton()
    {
        JButton backButton = new JButton("\u2190");
        backButton.setBounds(10, 10, 60, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("Alata", Font.BOLD, 25));

        backButton.addActionListener(e -> {
            if (controller != null) controller.showSignIn();
        });
        add(backButton);
    }

    private void addTitleLabel()
    {
        JLabel title = new JLabel("Find the FunKtion");
        title.setFont(new Font("Alata", Font.BOLD, 28));
        title.setBounds((375 - 300) / 2, 60, 300, 40);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JLabel signUpLabel = new JLabel("Sign up");
        signUpLabel.setFont(new Font("Alata", Font.PLAIN, 24));
        signUpLabel.setBounds(29, 120, 200, 30);
        add(signUpLabel);
    }

    private void addInputFields()
    {
        addFirstNameField();
        addLastNameField();
        addEmailField();
        addPasswordField();
        addConfirmPasswordField();
    }

    private void addFirstNameField()
    {
        int x = (375 - 317) / 2, y = 180, width = 317, height = 40;
        firstNameField = createPlaceholderField("First Name", x, y, width, height);
        add(firstNameField);
    }

    private void addLastNameField()
    {
        int x = (375 - 317) / 2, y = 250, width = 317, height = 40;
        lastNameField = createPlaceholderField("Last Name", x, y, width, height);
        add(lastNameField);
    }

    private void addEmailField()
    {
        int x = (375 - 317) / 2, y = 320, width = 317, height = 40;
        emailField = createPlaceholderField("Email", x, y, width, height);
        add(emailField);
    }

    private void addPasswordField()
    {
        int x = (375 - 317) / 2, y = 390, width = 317, height = 40;
        String tooltip = "<html>Password requirements:<br>- At least one letter<br>- At least one number<br>- At least 8 characters long</html>";
        passwordField = createPlaceholderPasswordField("Password", x, y, width, height, tooltip);
        add(passwordField);
    }

    private void addConfirmPasswordField()
    {
        int x = (375 - 317) / 2, y = 460, width = 317, height = 40;
        String tooltip = "Must match the password entered above";
        confirmPasswordField = createPlaceholderPasswordField("Confirm Password", x, y, width, height, tooltip);
        add(confirmPasswordField);
    }

    private void addSignUpButton()
    {
        JButton signUpButton = new JButton("SIGN UP");
        signUpButton.setBounds(52, 550, 271, 58);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFont(new Font("Alata", Font.BOLD, 16));
        signUpButton.setFocusPainted(false);
        signUpButton.setBorderPainted(false);
        signUpButton.setBackground(ORANGE);
        signUpButton.setHorizontalAlignment(SwingConstants.CENTER);
        signUpButton.addActionListener(e -> {
            if (validateAndRegisterUser() && controller != null)
            {
                controller.showSignIn();
            }
        });
        add(signUpButton);
    }

    private void addSignInLink()
    {
        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        orLabel.setForeground(new Color(157, 152, 152));
        orLabel.setBounds(175, 622, 50, 25);
        add(orLabel);

        JLabel promptLabel = new JLabel("Already have an account? ");
        promptLabel.setFont(new Font("Alata", Font.PLAIN, 15));
        promptLabel.setBounds(79, 656, 200, 25);
        add(promptLabel);

        JButton signInButton = new JButton("Sign in");
        signInButton.setFont(new Font("Alata", Font.PLAIN, 15));
        signInButton.setForeground(ORANGE);
        signInButton.setBounds(249, 656, 80, 25);
        signInButton.setBorderPainted(false);
        signInButton.setContentAreaFilled(false);
        signInButton.setFocusPainted(false);
        signInButton.setOpaque(false);

        signInButton.addActionListener(e -> {
        if (controller != null) controller.showSignIn();
        });

        this.add(signInButton);
    }

    private JTextField createPlaceholderField(String placeholder, int x, int y, int width, int height)
    {
        JTextField field = new JTextField(placeholder);
        field.setForeground(Color.GRAY);
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e)
            {
                if (field.getText().equals(placeholder))
                {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e)
            {
                if (field.getText().isEmpty())
                {
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                }
            }
        });
        // add(field);
        return field;
    }

    private JPasswordField createPlaceholderPasswordField(String placeholder, int x, int y, int width, int height, String tooltip)
    {
        JPasswordField field = new JPasswordField(placeholder);
        field.setEchoChar((char) 0);
        field.setForeground(Color.GRAY);
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.setToolTipText(tooltip);

        final boolean[] isPlaceholder = {true};

        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e)
            {
                String value = new String(field.getPassword());
                if (isPlaceholder[0] && value.equals(placeholder))
                {
                    field.setText("");
                    field.setEchoChar('•');
                    field.setForeground(Color.BLACK);
                    isPlaceholder[0] = false;
                }
            }

            public void focusLost(FocusEvent e)
            {
                String value = new String(field.getPassword());
                if (value.isEmpty())
                {
                    field.setEchoChar((char) 0);
                    field.setForeground(Color.GRAY);
                    field.setText(placeholder);
                    isPlaceholder[0] = true;
                }
            }
        });

        JCheckBox toggle = new JCheckBox("Show Password");
        toggle.setFont(new Font("Alata", Font.PLAIN, 12));
        toggle.setBounds(x + width - 120, y + height + 5, 120, 20);
        toggle.setOpaque(false);
        toggle.addActionListener(e -> {
            // String text = new String(field.getPassword());
            if (!isPlaceholder[0]) {
                field.setEchoChar(toggle.isSelected() ? (char) 0 : '•');
            }
        });

        add(field);
        add(toggle);

        return field;
    }

    private boolean validateAndRegisterUser()
    {
        // Extract user input from fields
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Strip placeholder if still present
        if (firstName.equals("First Name") || lastName.equals("Last Name") || email.equals("Email") ||
        password.equals("Password") || confirmPassword.equals("Confirm Password"))
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }

        // Validate inputs
        if (!InputValidator.validateFirstNameField(firstName))
        {
            JOptionPane.showMessageDialog(this, "Invalid first name.");
            return false;
        }
        if (!InputValidator.validatelastNameField(lastName))
        {
            JOptionPane.showMessageDialog(this, "Invalid last name.");
            return false;
        }
        if (!InputValidator.validEmail(email))
        {
            JOptionPane.showMessageDialog(this, "Invalid email. Must be a kzoo.edu address.");
            return false;
        }
        if (!InputValidator.validPassword(password))
        {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters and contain a letter and number.");
            return false;
        }
        if (!InputValidator.ConfirmPassword(password, confirmPassword))
        {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return false;
        }

        // Check if email already exists
        try (Connection conn = DatabaseConnection.getConnection())
        {
            String checkSQL = "SELECT 1 FROM \"Users\" WHERE email = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSQL))
            {
                checkStmt.setString(1, email);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next())
                {
                JOptionPane.showMessageDialog(this, "Email already in use.");
                return false;
                }
            }

            // Insert user
            String insertSQL = "INSERT INTO \"Users\" (firstname, lastname, email, password, display_name) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL))
            {
                insertStmt.setString(1, firstName);
                insertStmt.setString(2, lastName);
                insertStmt.setString(3, email);
                insertStmt.setString(4, password); // You should hash this before storing in production
                insertStmt.setString(5, firstName); // default display name

                int rowsInserted = insertStmt.executeUpdate();

                if (rowsInserted == 1)
                {
                    JOptionPane.showMessageDialog(this, "Sign up successful!");
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Sign up failed. Please try again.");
                    return false;
                }
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            return false;
        }
    }

    // Main method for standalone testing
    public static void main(String[] args)
    {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Find the FunKtion - Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 812);
        frame.setLocationRelativeTo(null);

        // Pass null since we're just testing the SignUp UI
        frame.setContentPane(new SignUp(null));
        frame.setVisible(true);
    });
}

}