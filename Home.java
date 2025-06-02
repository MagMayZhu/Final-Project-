import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel {
    private static final Color ORANGE = new Color(0xFF9500);
    private JPanel headerPanel;
    private JPanel scrollContainer;
    private JPanel bottomNav;
    private AppController controller;

    public Home(AppController controller) {
        this.controller = controller;
        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        createHeader();
        createSearchBar();
        createQuickFilters();
        createScrollSection();
        createBottomNavigation();
    }

    private void createHeader() {
        headerPanel = new JPanel(null);
        headerPanel.setBackground(ORANGE);
        headerPanel.setBounds(0, 0, 375, 150);
        add(headerPanel);

        JLabel titleLabel = new JLabel("Home");
        titleLabel.setFont(new Font("Alata", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds((375 - 200) / 2, 20, 200, 30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel);
    }

    private void createSearchBar() {
        JTextField searchField = createPlaceholderFieldNoLabel("Search", 24, 60, 180);
        headerPanel.add(searchField);

        JButton goBtn = new JButton("Go");
        goBtn.setFont(new Font("Alata", Font.BOLD, 12));
        goBtn.setBounds(210, 60, 55, 30);
        goBtn.setBackground(Color.WHITE);
        goBtn.setForeground(Color.BLACK);
        headerPanel.add(goBtn);

        JButton filterBtn = new JButton("Filters");
        filterBtn.setBounds(270, 60, 80, 30);
        filterBtn.setBackground(Color.WHITE);
        filterBtn.setForeground(Color.BLACK);
        headerPanel.add(filterBtn);
    }

    private void createQuickFilters() {
        String[] filters = {"Sport", "Club", "Event", "Art", "Party"};
        Color[] filterColors = {
            new Color(240, 99, 90), new Color(245, 151, 98),
            new Color(41, 214, 151), new Color(70, 205, 251),
            new Color(185, 135, 255)
        };

        for (int i = 0; i < filters.length; i++) {
            JButton tab = new JButton(filters[i]);
            tab.setBounds(10 + i * 72, 110, 70, 30);
            tab.setBackground(filterColors[i]);
            tab.setForeground(Color.WHITE);
            tab.setFont(new Font("Alata", Font.BOLD, 12));
            headerPanel.add(tab);
        }
    }

    private void createScrollSection() {
        scrollContainer = new JPanel(null);
        scrollContainer.setPreferredSize(new Dimension(375, 600));
        scrollContainer.setBackground(Color.WHITE);

        JLabel upcomingTitle = new JLabel("Upcoming Events");
        upcomingTitle.setFont(new Font("Alata", Font.BOLD, 18));
        upcomingTitle.setBounds(24, 10, 200, 20);
        scrollContainer.add(upcomingTitle);

        JButton seeAllBtn = new JButton("See All");
        seeAllBtn.setBounds(275, 10, 80, 20);
        seeAllBtn.setBackground(ORANGE);
        seeAllBtn.setForeground(Color.WHITE);
        scrollContainer.add(seeAllBtn);

        for (int i = 0; i < 2; i++) {
            scrollContainer.add(createEventCard(i));
        }

        JScrollPane scrollPane = new JScrollPane(scrollContainer);
        scrollPane.setBounds(0, 150, 375, 580);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);
    }

    private JPanel createEventCard(int index) {
        JPanel eventCard = new JPanel(null);
        eventCard.setBounds(24, 40 + index * 270, 327, 255);
        eventCard.setBackground(Color.WHITE);
        eventCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel eventImage = new JLabel(new ImageIcon("https://placehold.co/327x130"));
        eventImage.setBounds(0, 0, 327, 130);
        eventCard.add(eventImage);

        JLabel eventTitle = new JLabel("WOCA Wednesday");
        eventTitle.setFont(new Font("Alata", Font.PLAIN, 18));
        eventTitle.setBounds(10, 140, 200, 20);
        eventCard.add(eventTitle);

        JLabel eventLocation = new JLabel("1200 Academy St, Kalamazoo MI 49006");
        eventLocation.setFont(new Font("Alata", Font.PLAIN, 13));
        eventLocation.setBounds(10, 170, 300, 15);
        eventCard.add(eventLocation);

        JLabel attendees = new JLabel("06/01/2025");
        attendees.setForeground(new Color(63, 56, 221));
        attendees.setFont(new Font("Alata", Font.PLAIN, 12));
        attendees.setBounds(10, 200, 100, 15);
        eventCard.add(attendees);

        eventCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        eventCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Event " + (index + 1) + " clicked!");
            }
        });

        return eventCard;
    }

    private void createBottomNavigation() {
        bottomNav = new JPanel(null);
        bottomNav.setBounds(0, 740, 375, 67);
        bottomNav.setBackground(Color.WHITE);

        JButton homeBtn = new JButton("Home");
        homeBtn.setBounds(30, 0, 80, 35);
        homeBtn.setEnabled(false);
        bottomNav.add(homeBtn);

        JButton createEventBtn = new JButton("+");
        createEventBtn.setFont(new Font("SansSerif", Font.BOLD, 15));
        createEventBtn.setBounds(165, 0, 35, 35);
        createEventBtn.setBackground(ORANGE);
        createEventBtn.setForeground(Color.BLACK);
        createEventBtn.setMargin(new Insets(0, 0, 0, 0));
        createEventBtn.setContentAreaFilled(true);
        createEventBtn.setHorizontalAlignment(SwingConstants.CENTER);
        createEventBtn.setVerticalAlignment(SwingConstants.CENTER);
        createEventBtn.addActionListener(_ -> {
            if (controller != null) controller.showCreateEvent();
            else JOptionPane.showMessageDialog(this, "Redirecting to Create Event page...");}
        );
        bottomNav.add(createEventBtn);

        JButton profileBtn = new JButton("Profile");
        profileBtn.setBounds(265, 0, 80, 35);
        profileBtn.setBackground(Color.WHITE);
        profileBtn.addActionListener(_ -> {
            if (controller != null) controller.showMyProfile();
            else JOptionPane.showMessageDialog(this, "Redirecting to My Profile page...");}
        );
        bottomNav.add(profileBtn);

        add(bottomNav);
    }

    private JTextField createPlaceholderFieldNoLabel(String placeholder, int x, int y, int width) {
        JTextField field = new JTextField(placeholder);
        field.setForeground(Color.GRAY);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.setBounds(x, y, width, 30);
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Find the FunKtion - Home");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);

            // Pass null since we're just testing the SignUp UI
            frame.setContentPane(new Home(null));
            frame.setVisible(true);
        });
    }
}
