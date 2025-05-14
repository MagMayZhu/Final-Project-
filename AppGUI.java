import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {
    private AppController controller;
    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;

    public AppGUI(AppController controller) {
        this.controller = controller;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("My Java App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        inputField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String result = controller.processInput(input);
                outputArea.setText(result);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel(controller.getWelcomeMessage()));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(new JScrollPane(outputArea));

        frame.getContentPane().add(panel);
    }

    public void show() {
        frame.setVisible(true);
    }
}
