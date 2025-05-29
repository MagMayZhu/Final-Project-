// Java Swing version of the UI structure based on cleaned HTML structure
import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    public Home() {
        setTitle("Home");
        setSize(375, 812);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 140, 24));

        // Header
        JLabel locationLabel = new JLabel("Current Location: ");
        locationLabel.setBounds(24, 44, 120, 16);
        locationLabel.setForeground(Color.BLACK);
        add(locationLabel);

        JLabel cityLabel = new JLabel("Kalamazoo, MI");
        cityLabel.setBounds(44, 63, 150, 13);
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setFont(new Font("Serif", Font.BOLD, 13));
        add(cityLabel);

        // Search bar
        JTextField searchField = new JTextField("Search...");
        searchField.setBounds(65, 102, 200, 25);
        searchField.setBackground(Color.WHITE);
        searchField.setForeground(Color.BLACK);
        add(searchField);

        JButton filterBtn = new JButton("Filters");
        filterBtn.setBounds(276, 100, 75, 32);
        filterBtn.setBackground(new Color(255, 149, 0));
        filterBtn.setForeground(Color.BLACK);
        add(filterBtn);

        // Category Tabs
        String[] tabs = {"Sports", "Clubs", "Events", "Art", "Party"};
        int[] tabX = {27, 130, 240, 355, 455};
        Color[] tabColors = {
            new Color(240, 99, 90), new Color(245, 151, 98), new Color(41, 214, 151), new Color(70, 205, 251), new Color(70, 205, 251)
        };

        for (int i = 0; i < tabs.length; i++) {
            JButton tabButton = new JButton(tabs[i]);
            tabButton.setBounds(tabX[i], 159, 80, 40);
            tabButton.setBackground(tabColors[i]);
            tabButton.setForeground(Color.BLACK);
            add(tabButton);
        }

        // Upcoming Events title
        JLabel upcomingTitle = new JLabel("Upcoming Events");
        upcomingTitle.setBounds(24, 200, 200, 18);
        upcomingTitle.setFont(new Font("Alata", Font.PLAIN, 18));
        add(upcomingTitle);

        JButton seeAllBtn = new JButton("See All");
        seeAllBtn.setBounds(296, 224, 80, 14);
        seeAllBtn.setForeground(new Color(116, 118, 136));
        add(seeAllBtn);

        // Example Event Card
        JPanel eventCard = new JPanel();
        eventCard.setLayout(null);
        eventCard.setBounds(24, 270, 237, 255);
        eventCard.setBackground(Color.WHITE);
        eventCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel eventImage = new JLabel(new ImageIcon("https://placehold.co/222x222"));
        eventImage.setBounds(10, 10, 222, 130);
        eventCard.add(eventImage);

        JLabel eventTitle = new JLabel("WOCA Wednesday");
        eventTitle.setBounds(10, 150, 200, 20);
        eventTitle.setFont(new Font("Alata", Font.PLAIN, 18));
        eventCard.add(eventTitle);

        JLabel eventLocation = new JLabel("36 Guild Street London, UK");
        eventLocation.setBounds(10, 180, 220, 13);
        eventLocation.setFont(new Font("Alata", Font.PLAIN, 13));
        eventCard.add(eventLocation);

        JLabel attendees = new JLabel("+20 Going");
        attendees.setBounds(106, 210, 100, 12);
        attendees.setForeground(new Color(63, 56, 221));
        attendees.setFont(new Font("Alata", Font.PLAIN, 12));
        eventCard.add(attendees);

        add(eventCard);

        // Footer Navigation
        JLabel explore = new JLabel("Explore");
        explore.setBounds(30, 765, 50, 12);
        explore.setForeground(Color.BLACK);
        add(explore);

        JLabel events = new JLabel("Events");
        events.setBounds(160, 765, 50, 12);
        events.setForeground(Color.BLACK);
        add(events);

        JLabel profile = new JLabel("Profile");
        profile.setBounds(311, 765, 50, 12);
        profile.setForeground(Color.BLACK);
        add(profile);

        JButton addButton = new JButton("+");
        addButton.setBounds(164, 650, 46, 46);
        addButton.setBackground(new Color(255, 149, 0));
        addButton.setForeground(Color.BLACK);
        add(addButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Home ui = new Home();
            ui.setVisible(true);
        });
    }
}
