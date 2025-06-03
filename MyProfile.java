import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyProfile extends JPanel
{
    private final AppController controller;
    private User user;

    private JLabel profileImage;
    private JTextField nameField;
    private JTextArea bioText;
    private JPanel tagsPanel;
    private JButton editButton;
    private List<String> selectedInterests = new ArrayList<>();

    public MyProfile(AppController controller)
    {
        this.controller = controller;
        this.user = controller.getUser();

        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        addBackButton();
        addTitle();
        setupProfileSection();
        setupStatsSection();
        setupEditButton();
        setupAboutSection();
        setupInterestsSection();
    }

    private void addBackButton()
    {
        JButton backButton = new JButton("\u2190");
        backButton.setBounds(10, 10, 60, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        backButton.addActionListener(_ -> {
            if (controller != null) controller.showHome();
        });
        add(backButton);
    }

    private void addTitle()
    {
        JLabel title = new JLabel("Profile");
        title.setFont(new Font("Alata", Font.PLAIN, 20));
        title.setBounds(80, 8, 200, 40);
        add(title);
    }

    private void setupProfileSection()
    {
        profileImage = new JLabel(user.getImage());
        profileImage.setBounds(140, 115, 96, 90);
        add(profileImage);

        nameField = new JTextField(user.getName());
        nameField.setFont(new Font("Alata", Font.BOLD, 24));
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setBounds(50, 220, 275, 30);
        nameField.setBorder(null);
        nameField.setEditable(false);
        add(nameField);
    }

    private void setupStatsSection()
    {
        String[] statLabels = {"Posts", "Followers", "Following"};
        String[] statValues = {"120", "300", "180"};
        int x = 40;
        for (int i = 0; i < statLabels.length; i++)
        {
            JLabel value = new JLabel(statValues[i], SwingConstants.CENTER);
            value.setFont(new Font("Alata", Font.BOLD, 16));
            value.setBounds(x, 260, 90, 30);
            add(value);

            JLabel label = new JLabel(statLabels[i], SwingConstants.CENTER);
            label.setFont(new Font("Alata", Font.PLAIN, 14));
            label.setForeground(new Color(116, 118, 136));
            label.setBounds(x, 290, 90, 20);
            add(label);

            x += 95;
        }
    }

    private void setupEditButton() {
        editButton = new JButton("Edit Profile");
        editButton.setBounds(130, 370, 120, 30);
        editButton.setBackground(new Color(255, 165, 0));
        editButton.setForeground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setBorderPainted(false);
        editButton.setContentAreaFilled(false);
        editButton.setOpaque(true);
        add(editButton);

        editButton.addActionListener(_ -> controller.showEditMyProfile());
    }

    private void setupAboutSection() {
        JLabel aboutTitle = new JLabel("About Me");
        aboutTitle.setFont(new Font("Alata", Font.BOLD, 18));
        aboutTitle.setBounds(20, 400, 200, 30);
        add(aboutTitle);

        bioText = new JTextArea(user.getBio());
        bioText.setWrapStyleWord(true);
        bioText.setLineWrap(true);
        bioText.setEditable(false);
        bioText.setFont(new Font("Alata", Font.PLAIN, 16));
        bioText.setBounds(20, 440, 323, 60);
        add(bioText);
    }

    private void setupInterestsSection() {
        JLabel interestsTitle = new JLabel("Category");
        interestsTitle.setFont(new Font("Alata", Font.BOLD, 18));
        interestsTitle.setBounds(20, 520, 200, 30);
        add(interestsTitle);

        tagsPanel = new JPanel();
        tagsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tagsPanel.setBounds(20, 550, 330, 80);
        tagsPanel.setBackground(Color.WHITE);
        tagsPanel.setOpaque(true);
        add(tagsPanel);

        selectedInterests.addAll(user.getInterests());
        updateTagsPanel();
    }

    // private void openEditDialog() {
    //     JDialog editDialog = new JDialog();
    //     editDialog.setTitle("Edit Profile");
    //     editDialog.setModal(true);

    //     EditMyProfile editPanel = new EditMyProfile(
    //         this,
    //         nameField.getText(),
    //         aboutText.getText(),
    //         profileImage.getIcon(),
    //         selectedInterests
    //     );

    //     editDialog.add(editPanel);
    //     editDialog.pack();
    //     editDialog.setLocationRelativeTo(this);
    //     editDialog.setVisible(true);
    // }

    public void updateTagsPanel()
    {
        tagsPanel.removeAll();

        Color[] colors =
        {
            new Color(107, 122, 237), new Color(238, 84, 74), new Color(255, 141, 93),
            new Color(125, 103, 238), new Color(41, 214, 151), new Color(57, 209, 242),
            new Color(255, 182, 193)
        };

        for (int i = 0; i < selectedInterests.size(); i++) 
        {
            String interest = selectedInterests.get(i);
            JLabel tag = new JLabel(interest);
            tag.setOpaque(true);
            tag.setBackground(colors[i % colors.length]);
            tag.setForeground(Color.WHITE);
            tag.setFont(new Font("Arial", Font.PLAIN, 13));
            tag.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            tagsPanel.add(tag);
        }

        tagsPanel.revalidate();
        tagsPanel.repaint();
    }

    public void updateProfile(String newName, String newAbout, ImageIcon newImage, List<String> newInterests)
    {
        nameField.setText(newName);
        bioText.setText(newAbout);

        if (newImage != null)
        {
            profileImage.setIcon(newImage);
        }

        selectedInterests.clear();
        selectedInterests.addAll(newInterests);
        
        updateTagsPanel();
    }

    public void refreshData() {
    this.user = controller.getUser();  // Get the current user
    nameField.setText(user.getName());
    bioText.setText(user.getBio());
    profileImage.setIcon(user.getImage());
    
    selectedInterests.clear();
    selectedInterests.addAll(user.getInterests());
    updateTagsPanel();
}




    public JButton getEditButton() {
        return editButton;
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("My Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyProfile(null));  // controller is null for UI test
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
}
}