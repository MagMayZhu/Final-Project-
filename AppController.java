import javax.swing.*;
import java.awt.*;

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

        // After 10 seconds, switch to SignIn
        new javax.swing.Timer(10000, e -> showSignIn()).start();
    }

    public void showSignIn() {
        appGUI.showPanel("signin");
    }

    public void showSignUp() {
        appGUI.showPanel("signup");
    }

    public JFrame getFrame() {
        return appGUI.getFrame();
    }
}
