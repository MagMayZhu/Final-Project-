public class App {
    public static void main(String[] args) {
        // Create controller and launch GUI
        AppController controller = new AppController();
        AppGUI gui = new AppGUI(controller);
        gui.show();
    }
}
