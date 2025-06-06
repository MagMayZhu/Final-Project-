import java.util.List;
import javax.swing.*;

public class AppController {
    private final AppGUI appGUI;
    private final User user;

    public AppController()
    {
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("default_profile.jpg"));

        this.user = new User(
            "Your Name",
            "Your bio here",
            image,
            List.of("Academic", "Creative")
        );
        
        appGUI = new AppGUI(this);
    }

    public User getUser()
    {
        return user;
    }

    public void startApp() {
        showSplash();
    }

    public void showSplash() {
        appGUI.showPanel("splash");
    }

    public void showSignIn() {
        appGUI.showPanel("signin");
    }

    public void showSignUp() {
        appGUI.showPanel("signup");
    }

    public void showHome() {
        appGUI.showPanel("home");
    }

    public void showResetPassword()
    {
        appGUI.showPanel("resetPassword");
    }

    public void showCreateEvent()
    {
        appGUI.showPanel("createEvent");
    }

    public void showMyProfile()
    {
        appGUI.showPanel("myProfile");
    }

    public void showEditMyProfile()
    {
        appGUI.showPanel("editMyProfile");
    }

    public JFrame getFrame() {
        return appGUI.getFrame();
    }
}
