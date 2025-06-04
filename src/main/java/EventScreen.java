import javax.swing.*;
import java.awt.*;

public class EventScreen extends JPanel {

    public EventScreen() {
        setLayout(null);
        setPreferredSize(new Dimension(375, 813));
        setBackground(Color.WHITE);

        // Header
        JLabel headerLabel = new JLabel("Events");
        headerLabel.setFont(new Font("Alata", Font.PLAIN, 24));
        headerLabel.setBounds(57, 49, 200, 30);
        headerLabel.setForeground(new Color(0x120D26));
        add(headerLabel);

        // Back Arrow Icon (placeholder)
        JPanel backIcon = new JPanel();
        backIcon.setBackground(Color.LIGHT_GRAY);
        backIcon.setBounds(24, 53, 22, 22);
        add(backIcon);

        // Status Bar Time
        JLabel timeLabel = new JLabel("9:41", SwingConstants.CENTER);
        timeLabel.setFont(new Font("SF Pro Text", Font.BOLD, 15));
        timeLabel.setForeground(new Color(0x120D26));
        timeLabel.setBounds(21, 7, 54, 21);
        add(timeLabel);

        // Circle Background
        JPanel circleBack = new JPanel();
        circleBack.setBackground(new Color(0xEBF5FC));
        circleBack.setBounds(81, 243, 202, 202);
        circleBack.setOpaque(true);
        circleBack.setLayout(null);
        circleBack.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(circleBack);

        // Circle Front (overlay)
        JPanel circleFront = new JPanel();
        circleFront.setBackground(new Color(0xDADADA));
        circleFront.setBounds(81, 243, 202, 202);
        circleFront.setOpaque(true);
        circleFront.setLayout(null);
        add(circleFront);

        // Title
        JLabel title = new JLabel("No Upcoming Event", SwingConstants.CENTER);
        title.setFont(new Font("Alata", Font.PLAIN, 24));
        title.setForeground(new Color(0x120D26));
        title.setBounds(62, 475, 250, 30);
        add(title);

        // Subtitle
        JLabel subtitle = new JLabel("No events Upcoming", SwingConstants.CENTER);
        subtitle.setFont(new Font("Alata", Font.PLAIN, 16));
        subtitle.setForeground(new Color(0x747688));
        subtitle.setBounds(54, 519, 268, 30);
        add(subtitle);
    }

    // Optional: Main method for testing in a JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Empty Events");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new EventScreen());
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
