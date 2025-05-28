import javax.swing.*;
import java.awt.*;

public class EventDetail extends JFrame {
    public EventDetail() {
        setTitle("Event Details");
        setSize(375, 812);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Background image
        JLabel backgroundImage = new JLabel(new ImageIcon("https://placehold.co/375x244"));
        backgroundImage.setBounds(0, -23, 375, 244);
        add(backgroundImage);

        // Gradient panel placeholder (simulated with transparent panel)
        JPanel gradientPanel = new JPanel();
        gradientPanel.setBounds(0, 0, 375, 94);
        gradientPanel.setOpaque(false);
        add(gradientPanel);

        // Event title
        JLabel titleLabel = new JLabel("PASA @ K College");
        titleLabel.setFont(new Font("Alata", Font.PLAIN, 30));
        titleLabel.setBounds(24, 271, 313, 40);
        add(titleLabel);

        // Date and time
        JLabel dateLabel = new JLabel("23 May, 2025");
        dateLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        dateLabel.setBounds(84, 390, 200, 20);
        add(dateLabel);

        JLabel timeLabel = new JLabel("Friday, 5:00PM - 6:00PM");
        timeLabel.setFont(new Font("Alata", Font.PLAIN, 12));
        timeLabel.setForeground(new Color(116, 118, 136));
        timeLabel.setBounds(84, 410, 200, 20);
        add(timeLabel);

        // Organizer
        JLabel organizerName = new JLabel("PASA");
        organizerName.setFont(new Font("Alata", Font.PLAIN, 15));
        organizerName.setBounds(81, 528, 200, 20);
        add(organizerName);

        JLabel organizerRole = new JLabel("Organizer");
        organizerRole.setFont(new Font("Alata", Font.PLAIN, 12));
        organizerRole.setForeground(new Color(112, 110, 143));
        organizerRole.setBounds(81, 553, 200, 20);
        add(organizerRole);

        // Location
        JLabel locationLabel = new JLabel("Intercultural Center");
        locationLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        locationLabel.setBounds(81, 468, 242, 18);
        add(locationLabel);

        JLabel locationAddress = new JLabel("1200 Academy St, Hicks Center, Kalamazoo");
        locationAddress.setFont(new Font("Alata", Font.PLAIN, 12));
        locationAddress.setForeground(new Color(116, 118, 136));
        locationAddress.setBounds(80, 488, 260, 20);
        add(locationAddress);

        // About Event
        JLabel aboutLabel = new JLabel("About Event");
        aboutLabel.setFont(new Font("Alata", Font.PLAIN, 18));
        aboutLabel.setBounds(20, 592, 300, 30);
        add(aboutLabel);

        JTextArea aboutText = new JTextArea("Enjoy your favorite dishe and a lovely your friends and family and have a great time. Food from local food trucks will be available for purchase. Read More...");
        aboutText.setFont(new Font("Alata", Font.PLAIN, 16));
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setOpaque(false);
        aboutText.setEditable(false);
        aboutText.setFocusable(false);
        aboutText.setBounds(20, 634, 335, 90);
        add(aboutText);

        // Save Event Button
        JButton saveButton = new JButton("SAVE EVENT");
        saveButton.setFont(new Font("Alata", Font.BOLD, 16));
        saveButton.setBackground(new Color(255, 149, 0));
        saveButton.setForeground(Color.WHITE);
        saveButton.setOpaque(true);                       // Allow background to show
        saveButton.setBorderPainted(false);               // Optional: cleaner look
        saveButton.setBounds(52, 720, 271, 58);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventDetail ed = new EventDetail();
            ed.setVisible(true);
        });
    }
}
