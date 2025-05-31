import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JPanel {
    public Home() {
        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        // Orange Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(new Color(240, 140, 24));
        headerPanel.setBounds(0, 0, 375, 150);
        add(headerPanel);

        JLabel titleLabel = new JLabel("Home");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(24, 20, 200, 30);
        headerPanel.add(titleLabel);

        // Search Bar
        JTextField searchField = new JTextField("Search...");
        searchField.setBounds(24, 60, 220, 30);
        headerPanel.add(searchField);

        JButton filterBtn = new JButton("Filters");
        filterBtn.setBounds(260, 60, 80, 30);
        filterBtn.setBackground(new Color(255, 149, 0));
        filterBtn.setForeground(Color.BLACK);
        headerPanel.add(filterBtn);

        // Quick Filter Buttons
        String[] filters = {"Sports", "Clubs", "Events", "Art", "Party"};
        Color[] filterColors = {
            new Color(240, 99, 90), new Color(245, 151, 98),
            new Color(41, 214, 151), new Color(70, 205, 251),
            new Color(185, 135, 255)
        };

        for (int i = 0; i < filters.length; i++) {
            JButton tab = new JButton(filters[i]);
            tab.setBounds(10 + i * 72, 110, 70, 30);
            tab.setBackground(filterColors[i]);
            headerPanel.add(tab);
        }

        // Scrollable Events Section
        JPanel scrollContainer = new JPanel();
        scrollContainer.setLayout(null);
        scrollContainer.setPreferredSize(new Dimension(375, 600));
        scrollContainer.setBackground(Color.WHITE);

        JLabel upcomingTitle = new JLabel("Upcoming Events");
        upcomingTitle.setFont(new Font("Alata", Font.BOLD, 18));
        upcomingTitle.setBounds(24, 10, 200, 20);
        scrollContainer.add(upcomingTitle);

        JButton seeAllBtn = new JButton("See All");
        seeAllBtn.setBounds(275, 10, 80, 20);
        seeAllBtn.setForeground(new Color(116, 118, 136));
        scrollContainer.add(seeAllBtn);

        // Add two example event cards
        for (int i = 0; i < 2; i++) {
            JPanel eventCard = new JPanel();
            eventCard.setLayout(null);
            eventCard.setBounds(24, 40 + i * 270, 327, 255);
            eventCard.setBackground(Color.WHITE);
            eventCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            JLabel eventImage = new JLabel(new ImageIcon("https://placehold.co/327x130"));
            eventImage.setBounds(0, 0, 327, 130);
            eventCard.add(eventImage);

            JLabel eventTitle = new JLabel("WOCA Wednesday");
            eventTitle.setFont(new Font("Alata", Font.PLAIN, 18));
            eventTitle.setBounds(10, 140, 200, 20);
            eventCard.add(eventTitle);

            JLabel eventLocation = new JLabel("36 Guild Street London, UK");
            eventLocation.setFont(new Font("Alata", Font.PLAIN, 13));
            eventLocation.setBounds(10, 170, 300, 15);
            eventCard.add(eventLocation);

            JLabel attendees = new JLabel("+20 Going");
            attendees.setForeground(new Color(63, 56, 221));
            attendees.setFont(new Font("Alata", Font.PLAIN, 12));
            attendees.setBounds(10, 200, 100, 15);
            eventCard.add(attendees);

            eventCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            int index = i;
            eventCard.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Event " + (index + 1) + " clicked!");
                    // Future: navigate to event details screen
                }
            });

            scrollContainer.add(eventCard);
        }

        JScrollPane scrollPane = new JScrollPane(scrollContainer);
        scrollPane.setBounds(0, 150, 375, 590);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        // Bottom Navigation Bar
        JPanel bottomNav = new JPanel(null);
        bottomNav.setBounds(0, 745, 375, 67);
        bottomNav.setBackground(Color.WHITE);

        JButton homeBtn = new JButton("Home");
        homeBtn.setBounds(30, 10, 80, 40);
        homeBtn.setEnabled(false); // Current page
        bottomNav.add(homeBtn);

        JButton createEventBtn = new JButton("+");
        createEventBtn.setBounds(165, 0, 45, 45);
        createEventBtn.setBackground(new Color(255, 149, 0));
        createEventBtn.setForeground(Color.BLACK);
        bottomNav.add(createEventBtn);

        JLabel createLabel = new JLabel("Create");
        createLabel.setBounds(160, 48, 60, 15);
        createLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomNav.add(createLabel);

        JButton profileBtn = new JButton("Profile");
        profileBtn.setBounds(265, 10, 80, 40);
        bottomNav.add(profileBtn);

        add(bottomNav);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Home");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Home());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
