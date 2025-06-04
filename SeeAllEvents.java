import javax.swing.*;
import java.awt.*;

public class SeeAllEvents extends JFrame {
    private JPanel contentPanel;
    public SeeAllEvents() {
        setTitle("Events");
        setSize(375, 812);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(240, 140, 24));

        // Panel that holds all content
        contentPanel = new JPanel();
        contentPanel.setLayout(null);  // still using null layout to keep your original design
        contentPanel.setPreferredSize(new Dimension(375, 900)); // Adjust height as needed
        contentPanel.setBackground(Color.WHITE);


        addEventCard(104, "Jo Malone London’s Mother’s Day Presents", "Wed, Apr 28 • 5:30 PM", "Radius Gallery • Santa Cruz, CA");
        addEventCard(222, "A Virtual Evening of Smooth Jazz", "Sat, May 1 • 2:00 PM", "Lot 13 • Oakland, CA");
        addEventCard(340, "Women's Leadership Conference 2021", "Sat, Apr 24 • 1:30 PM", "53 Bush St • San Francisco, CA");
        addEventCard(458, "International Kids Safe Parents Night Out", "Fri, Apr 23 • 6:00 PM", "Lot 13 • Oakland, CA");
        addEventCard(581, "Collectivity Plays the Music of Jimi", "Mon, Jun 21 • 10:00 PM", "Longboard Margarita Bar");
        addEventCard(699, "International Gala Music Festival", "Sun, Apr 25 • 10:15 AM", "36 Guild Street London, UK");

        JLabel header = new JLabel("Events");
        header.setFont(new Font("Alata", Font.PLAIN, 24));
        header.setBounds(57, 49, 200, 30);
        contentPanel.add(header);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // smoother scroll
        setContentPane(scrollPane);
    }

    private void addEventCard(int top, String title, String datetime, String location) {
        JPanel card = new JPanel(null);
        card.setBounds(24, top, 327, 106);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(240, 140, 24), 1, true));

        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(new ImageIcon("https://placehold.co/79x92").getImage().getScaledInstance(79, 92, Image.SCALE_SMOOTH)));
        image.setBounds(10, 7, 79, 92);
        card.add(image);

        JLabel dateTimeLabel = new JLabel(datetime);
        dateTimeLabel.setFont(new Font("Alata", Font.PLAIN, 13));
        dateTimeLabel.setForeground(new Color(86, 105, 255));
        dateTimeLabel.setBounds(100, 7, 200, 20);
        card.add(dateTimeLabel);

        JLabel titleLabel = new JLabel("<html><b>" + title + "</b></html>");
        titleLabel.setFont(new Font("Alata", Font.PLAIN, 15));
        titleLabel.setForeground(new Color(18, 13, 38));
        titleLabel.setBounds(100, 27, 200, 30);
        card.add(titleLabel);

        JLabel locationLabel = new JLabel(location);
        locationLabel.setFont(new Font("Alata", Font.PLAIN, 13));
        locationLabel.setForeground(new Color(116, 118, 136));
        locationLabel.setBounds(100, 67, 200, 20);
        card.add(locationLabel);

        contentPanel.add(card);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SeeAllEvents ui = new SeeAllEvents();
            ui.setVisible(true);
        });
    }
}
