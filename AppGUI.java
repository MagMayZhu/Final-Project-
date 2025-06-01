import javax.swing.*;
import java.awt.*;

public class AppGUI {
    private final JFrame frame;
    private final CardLayout layout;
    private final JPanel mainPanel;

    public AppGUI(AppController controller) {
        frame = new JFrame("Find the FunKtion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 812);
        frame.setLocationRelativeTo(null);

        layout = new CardLayout();
        mainPanel = new JPanel(layout);

        // Screens
        Splash splash = new Splash(controller);
        SignIn signIn = new SignIn(controller);
        SignUp signUp = new SignUp(controller);
        Home home = new Home(controller);
        ResetPassword resetPassword = new ResetPassword(controller);
        CreateEvent createEvent = new CreateEvent(controller);

        mainPanel.add(splash, "splash");
        mainPanel.add(signIn, "signin");
        mainPanel.add(signUp, "signup");
        mainPanel.add(home, "home");
        mainPanel.add(resetPassword,"resetPassword");
        mainPanel.add(createEvent, "createEvent");
        // mainPanel.add(myProfile, "myProfile");
        // mainPanel.add(editMyProfile, "editMyProfile");

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    public void showPanel(String name) {
        layout.show(mainPanel, name);
    }

    public JFrame getFrame() {
        return frame;
    }
}
