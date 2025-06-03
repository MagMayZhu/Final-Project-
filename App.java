import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppController controller = new AppController();
            controller.startApp();
        });
    }
}
