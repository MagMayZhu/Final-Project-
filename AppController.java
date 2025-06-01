import javax.swing.*;

public class AppController {
    private final AppGUI appGUI;

    public AppController() {
        appGUI = new AppGUI(this);
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

    public JFrame getFrame() {
        return appGUI.getFrame();
    }
}
