import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignUp extends JFrame {

    private static final Color ORANGE = new Color(0xFF9500);

    public SignUp()
    {
        setupFrame();
        addBackButton();
        addTitleLabel();
        addInputFields();   // Adds all input fields internally
        addSignUpButton();
        addSignInLink();
    }

    private void setupFrame()
    {
        setTitle("Find the FunKtion - Sign Up");
        setSize(375, 812);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void addBackButton()
    {
        JButton backButton = new JButton("\u2190");
        backButton.setBounds(10, 10, 60, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 25));

        // Placeholder action for now
        backButton.addActionListener(e -> {JOptionPane.showMessageDialog(this, "Back button clicked!");});
        add(backButton);
    }

    private void addTitleLabel()
    {
        // App title
        JLabel title = new JLabel("Find the FunKtion");
        title.setFont(new Font("Alata", Font.BOLD, 28));
        title.setBounds((375 - 300) / 2, 60, 300, 40);  // Centered horizontally
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        // Sign Up header
        JLabel signUpLabel = new JLabel("Sign up");
        signUpLabel.setFont(new Font("Alata", Font.PLAIN, 24));
        signUpLabel.setBounds(29, 120, 200, 30); // Position below the title
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
        int x = (375-317)/2, y = 180, width = 317, height = 40;
        createPlaceholderField("First Name", x, y, width, height);
    }

    private void addLastNameField()
    {
        int x = (375-317)/2, y = 250, width = 317, height = 40;
        createPlaceholderField("Last Name", x, y, width, height);
    }

    private void addEmailField()
    {
        int x = (375-317)/2, y = 320, width = 317, height = 40;
        createPlaceholderField("Email", x, y, width, height);
    }

    private void addPasswordField()
    {
        int x = (375-317)/2, y = 390, width = 317, height = 40;
        String tooltip = "<html>Password requirements:<br>- At least one letter<br>- At least one number<br>- At least 8 characters long</html>";
        createPlaceholderPasswordField("Password", x, y, width, height, tooltip);
    }

    private void addConfirmPasswordField()
    {
        int x = (375-317)/2, y = 460, width = 317, height = 40;
        String tooltip = "Must match the password entered above";
        createPlaceholderPasswordField("Confirm Password", x, y, width, height, tooltip);
    }

    private void addSignUpButton() 
    {
    // int buttonY = 180 + 5 * 60 + 20; // 5 fields, 60 spacing each, plus some vertical padding

    JButton signUpButton = new JButton("SIGN UP");
    signUpButton.setBounds(52, 550, 271, 58);
    signUpButton.setForeground(Color.WHITE);
    signUpButton.setFont(new Font("Alata", Font.BOLD, 16));
    signUpButton.setFocusPainted(false);
    signUpButton.setBorderPainted(false);
    signUpButton.setBackground(new Color(0xFF9500));

    // Ensure text is centered
    signUpButton.setHorizontalAlignment(SwingConstants.CENTER);

    // Optional dummy action
    signUpButton.addActionListener(e -> {
        JOptionPane.showMessageDialog(this, "Signing up...");
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

        // "Already have an account? "
        JLabel promptLabel = new JLabel("Already have an account? ");
        promptLabel.setFont(new Font("Alata", Font.PLAIN, 15));
        promptLabel.setBounds(79, 656, 200, 25);
        add(promptLabel);

        // "Sign in" button styled as hyperlink
        JButton signInButton = new JButton("Sign in");
        signInButton.setFont(new Font("Alata", Font.PLAIN, 15));
        signInButton.setForeground(ORANGE);
        signInButton.setBounds(249, 656, 80, 25);

        // Remove button visuals
        signInButton.setBorderPainted(false);
        signInButton.setContentAreaFilled(false);
        signInButton.setFocusPainted(false);
        signInButton.setOpaque(false);

        // Placeholder action for now
        signInButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Redirecting to Sign In page..."));

        add(signInButton);
    }

    // Helpers for placeholder text fields
    private void createPlaceholderField(String placeholder, int x, int y, int width, int height)
    {
        JTextField field = new JTextField(placeholder);
        field.setForeground(Color.GRAY);
        field.setBounds(x, y, width, height);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.addFocusListener(new FocusAdapter()
        {
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
        add(field);
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

        field.addFocusListener(new FocusAdapter()
        {
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

        // Add visibility toggle
        JCheckBox toggle = new JCheckBox("Show Password");
        toggle.setFont(new Font("Alata", Font.PLAIN, 12));
        toggle.setBounds(x + width - 120, y + height + 5,120, 20);
        toggle.setOpaque(false);
        toggle.addActionListener(e -> 
        {
            String text = new String(field.getPassword());
            if (!isPlaceholder[0]) 
            {
                field.setEchoChar(toggle.isSelected() ? (char) 0 : '•');
            }
        });

        add(field);
        add(toggle);

        return field;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            SignUp screen = new SignUp();
            screen.setVisible(true);
        });
    }
}

