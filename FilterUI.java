
import javax.swing.*;
import java.awt.*;

public class FilterUI extends JPanel {

    public FilterUI() {
        setLayout(new BorderLayout());

        // Create the main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(375, 1000)); // enough height for scrolling
        contentPanel.setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("Filter");
        title.setFont(new Font("Alata", Font.PLAIN, 25));
        title.setBounds(20, 100, 200, 30);
        contentPanel.add(title);

        // Category Buttons (Two rows)
        String[] categories = {"Party", "Club", "Sport", "Event", "Art", "Food"};
        int x = 20;
        int y = 153;
        for (int i = 0; i < categories.length; i++) {
            if (i == 4) { // Start second row
                x = 20;
                y += 100;
            }

            JButton btn = new JButton(categories[i]);
            btn.setBounds(x, y, 63, 63);
            btn.setBackground(Color.ORANGE);
            btn.setForeground(Color.WHITE);
            contentPanel.add(btn);

            JLabel label = new JLabel(categories[i], SwingConstants.CENTER);
            label.setBounds(x - 5, y + 70, 80, 20);
            contentPanel.add(label);

            x += 80;
        }

        // Time & Date Label
        JLabel timeLabel = new JLabel("Time & Date");
        timeLabel.setFont(new Font("Alata", Font.PLAIN, 16));
        timeLabel.setBounds(20, 377, 150, 30);
        contentPanel.add(timeLabel);

        // Time Buttons
        JButton todayBtn = new JButton("Today");
        todayBtn.setBounds(20, 423, 81, 42);
        contentPanel.add(todayBtn);

        JButton tomorrowBtn = new JButton("Tomorrow");
        tomorrowBtn.setBounds(113, 423, 110, 42);
        tomorrowBtn.setBackground(Color.ORANGE);
        contentPanel.add(tomorrowBtn);

        JButton thisWeekBtn = new JButton("This week");
        thisWeekBtn.setBounds(235, 423, 107, 42);
        contentPanel.add(thisWeekBtn);

        JButton chooseCalendarBtn = new JButton("Choose from calendar");
        chooseCalendarBtn.setBounds(20, 479, 241, 42);
        contentPanel.add(chooseCalendarBtn);

        // Action Buttons
        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(20, 936, 130, 58);
        contentPanel.add(resetBtn);

        JButton applyBtn = new JButton("Apply");
        applyBtn.setBounds(169, 936, 185, 58);
        applyBtn.setBackground(Color.ORANGE);
        applyBtn.setForeground(Color.WHITE);
        contentPanel.add(applyBtn);

        // Wrap content panel in scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);
    }

    // Optional: test in a standalone window
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Filter Screen");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new FilterUI());
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
