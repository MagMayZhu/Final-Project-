import javax.swing.*;
import java.awt.*;

public class SearchUI extends JPanel {

    public SearchUI() {
        setLayout(null);
        setBackground(Color.WHITE);

        int cm = 40;

        // Status bar
        JPanel statusBar = new JPanel();
        statusBar.setBounds(0, 0, 375, 44);
        statusBar.setLayout(null);
        statusBar.setBackground(Color.WHITE);

        JLabel timeLabel = new JLabel("9:41", SwingConstants.CENTER);
        timeLabel.setBounds(21, 7, 54, 30);
        timeLabel.setFont(new Font("Alata", Font.BOLD, 15));
        timeLabel.setForeground(new Color(0x12, 0x0D, 0x26));

        JPanel battery = new JPanel();
        battery.setBounds(320, 17, 22, 11);
        battery.setBorder(BorderFactory.createLineBorder(new Color(0x12, 0x0D, 0x26), 1));
        battery.setOpaque(false);

        JPanel signal = new JPanel();
        signal.setBounds(350, 17, 22, 11);
        signal.setBorder(BorderFactory.createLineBorder(new Color(0x12, 0x0D, 0x26), 1));
        signal.setOpaque(false);

        statusBar.add(timeLabel);
        statusBar.add(battery);
        statusBar.add(signal);
        add(statusBar);

        // Search header panel (1 cm below statusBar)
        JPanel searchHeader = new JPanel();
        searchHeader.setBounds(0, 44 + cm, 375, 80);
        searchHeader.setLayout(null);
        searchHeader.setBackground(Color.WHITE);

        JPanel backButton = new JPanel();
        backButton.setBounds(24, 18, 22, 22);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(0x12, 0x0D, 0x26), 2));
        backButton.setOpaque(false);
        searchHeader.add(backButton);
        add(searchHeader);

        // Search bar (1 cm below header)
        JPanel searchBar = new JPanel();
        searchBar.setBounds(24, 44 + cm + 80 + cm, 327, 32);
        searchBar.setLayout(null);
        searchBar.setBackground(Color.WHITE);

        JPanel searchIcon = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0x56, 0x69, 0xFF));
                g.drawOval(2, 2, 20, 20);
                g.drawLine(18, 18, 24, 24);
            }
        };
        searchIcon.setBounds(0, 4, 24, 24);

        JLabel searchPlaceholder = new JLabel("Search...");
        searchPlaceholder.setBounds(34, 0, 200, 32);
        searchPlaceholder.setFont(new Font("Alata", Font.PLAIN, 24));
        searchPlaceholder.setForeground(new Color(0, 0, 0, 76));

        searchBar.add(searchIcon);
        searchBar.add(searchPlaceholder);
        add(searchBar);

        // Event card (1 cm below search bar)
        JPanel eventCard = new JPanel();
        int eventCardY = 44 + cm + 80 + cm + 32 + cm;
        eventCard.setBounds(21, eventCardY, 327, 112);
        eventCard.setBackground(Color.WHITE);
        eventCard.setLayout(null);
        eventCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(83, 89, 144, 18), 1, true),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));

        JLabel eventImage = new JLabel();
        eventImage.setBounds(10, 10, 79, 92);
        eventImage.setBackground(new Color(0xBD, 0xAC, 0xAC));
        eventImage.setOpaque(true);

        JLabel eventDate = new JLabel("21st May - WED @2:00-3:00 PM");
        eventDate.setBounds(107, 21, 200, 15);
        eventDate.setFont(new Font("Alata", Font.PLAIN, 12));
        eventDate.setForeground(new Color(0x56, 0x69, 0xFF));
        eventDate.setText(eventDate.getText().toUpperCase());

        JLabel eventTitle = new JLabel("<html>A virtual evening of smooth jazz</html>");
        eventTitle.setBounds(107, 45, 200, 60);
        eventTitle.setFont(new Font("Alata", Font.PLAIN, 18));
        eventTitle.setForeground(new Color(0x12, 0x0D, 0x26));

        eventCard.add(eventImage);
        eventCard.add(eventDate);
        eventCard.add(eventTitle);

        add(eventCard);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Search");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new SearchUI());
            frame.setVisible(true);
        });
    }
}

