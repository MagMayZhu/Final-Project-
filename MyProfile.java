import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class MyProfile extends JFrame {
    private JTextField nameField;
    private JTextArea aboutText;
    private JButton editButton;
    private JLabel profileImage;
    private java.util.List<String> selectedInterests = new java.util.ArrayList<>();
    private JPanel tagsPanel; // make it accessible so we can update it

    public void updateTagsPanel() {
        tagsPanel.removeAll();
        Color[] colors = {
            new Color(107, 122, 237), new Color(238, 84, 74), new Color(255, 141, 93),
            new Color(125, 103, 238), new Color(41, 214, 151), new Color(57, 209, 242),
            new Color(255, 182, 193)
        };
        String[] allTags = {"Academic", "Culture", "Creative", "Career", "Physcial Activity", "Social", "Other"};
        for (int i = 0; i < allTags.length; i++) {
            if (selectedInterests.contains(allTags[i])) {
                JLabel tag = new JLabel(allTags[i]);
                tag.setOpaque(true);
                tag.setBackground(colors[i % colors.length]);
                tag.setForeground(Color.WHITE);
                tag.setFont(new Font("Arial", Font.PLAIN, 13));
                tag.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                tagsPanel.add(tag);
            }
        }
        tagsPanel.revalidate();
        tagsPanel.repaint();
    }

    public MyProfile() {
        setTitle("My Profile");
        setSize(375, 812);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Header
        JLabel title = new JLabel("Profile");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(57, 49, 200, 30);
        add(title);

        JButton backButton = new JButton("<");
        backButton.setBounds(24, 53, 22, 22);
        add(backButton);

        JLabel time = new JLabel("9:41");
        time.setFont(new Font("Arial", Font.BOLD, 13));
        time.setBounds(21, 7, 50, 20);
        add(time);


        // Profile Section
        profileImage = new JLabel(new ImageIcon("profile.png"));
        profileImage.setBounds(140, 115, 96, 90);
        add(profileImage);

        nameField = new JTextField("PASA @ K College");
        nameField.setFont(new Font("Arial", Font.BOLD, 24));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setBounds(50, 220, 275, 30); // narrower, centered
        nameField.setBorder(null);
        nameField.setEditable(false);
        add(nameField);

        // Stats
        String[] statLabels = {"Posts", "Followers", "Following"};
        String[] statValues = {"120", "300", "180"};
        int x = 40;
        for (int i = 0; i < statLabels.length; i++) {
            JLabel value = new JLabel(statValues[i], SwingConstants.CENTER);
            value.setFont(new Font("Arial", Font.BOLD, 16));
            value.setBounds(x, 260, 90, 30);
            add(value);

            JLabel label = new JLabel(statLabels[i], SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            label.setForeground(new Color(116, 118, 136));
            label.setBounds(x, 290, 90, 20);
            add(label);

            x += 95;
        }

        // Edit Button
        editButton = new JButton("Edit Profile");
        editButton.setBounds(130, 370, 120, 30);
        editButton.setBackground(new Color(255, 165, 0)); // Orange
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setOpaque(true);
        add(editButton);

        // Button Listeners
        editButton.addActionListener(_ -> {
            new EditMyProfile(this, nameField.getText(), aboutText.getText(), profileImage.getIcon(), selectedInterests);
            setEnabled(true);
            setVisible(true);

        });

        // About Me
        JLabel aboutTitle = new JLabel("About Me");
        aboutTitle.setFont(new Font("Arial", Font.BOLD, 18));
        aboutTitle.setBounds(20, 400, 200, 30);
        add(aboutTitle);

        aboutText = new JTextArea("This is a Pilipinx American Student Association (PASA) at Kalamazoo College.");
        aboutText.setWrapStyleWord(true);
        aboutText.setLineWrap(true);
        aboutText.setEditable(false);
        aboutText.setFont(new Font("Arial", Font.PLAIN, 16));
        aboutText.setBounds(20, 440, 323, 60);
        add(aboutText);

       // Interests
       JLabel interestsTitle = new JLabel("Category");
       interestsTitle.setFont(new Font("Arial", Font.BOLD, 18));
       interestsTitle.setBounds(20, 520, 200, 30);
       add(interestsTitle);

       tagsPanel = new JPanel();
       tagsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
       tagsPanel.setBounds(20, 550, 330, 80);
       add(tagsPanel);
       
       // Initially selected interests
       String[] initialTags = {"Culture", "Creative", "Social"};
       java.util.Collections.addAll(selectedInterests, initialTags);
       updateTagsPanel();

    }
    // Called from EditMyProfile to update name, about, and image
    public void updateProfile(String newName, String newAbout, ImageIcon newImage, java.util.List<String> newInterests) {
        nameField.setText(newName);
        aboutText.setText(newAbout);
        if (newImage != null) {
            profileImage.setIcon(newImage);
        }

         // Update selected interests
        selectedInterests = new java.util.ArrayList<>(newInterests);
        updateTagsPanel();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyProfile profile = new MyProfile();
            profile.setVisible(true);  // This line was missing
        });
    }
}


