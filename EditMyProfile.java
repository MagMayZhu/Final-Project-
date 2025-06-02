import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EditMyProfile extends JPanel {
    private JTextField nameInput;
    private JTextArea aboutInput;
    private JLabel previewImage;
    private ImageIcon selectedImage;
    // private MyProfile mainProfile;
    private List<JCheckBox> interestCheckboxes = new ArrayList<>();

    private AppController controller;
    private User user;

    public EditMyProfile(AppController controller)
    {
        this.controller = controller;
        this.user = controller.getUser();
        
        setLayout(null);
        setPreferredSize(new Dimension(375, 812));
        setBackground(Color.WHITE);

        initComponents();
    }

    private void initComponents()
    {
        // Loading data from initial user
        String currentName = user.getName();
        String currentBio = user.getBio();
        Icon currentIcon = user.getImage();
        List<String> interests = user.getInterests();

        previewImage = new JLabel(currentIcon);
        previewImage.setBounds(140, 10, 96, 90);
        add(previewImage);

        // Change Image Button
        JButton changePic = new JButton("Change Photo");
        changePic.setBounds(120, 105, 130, 25);
        add(changePic);

        changePic.addActionListener(_ -> {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                selectedImage = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage()
                    .getScaledInstance(96, 90, Image.SCALE_SMOOTH));
                previewImage.setIcon(selectedImage);
            }
        });

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 145, 100, 20);
        add(nameLabel);

        nameInput = new JTextField(currentName);
        nameInput.setBounds(20, 175, 320, 30);
        add(nameInput);

        // About
        JLabel aboutLabel = new JLabel("About Me:");
        aboutLabel.setBounds(20, 215, 100, 20);
        add(aboutLabel);

        aboutInput = new JTextArea(currentBio);
        aboutInput.setLineWrap(true);
        aboutInput.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(aboutInput);
        scrollPane.setBounds(20, 245, 320, 150);
        add(scrollPane);

        // Interests
        JLabel interestsLabel = new JLabel("Select Category:");
        interestsLabel.setBounds(20, 405, 200, 20);
        add(interestsLabel);

        JPanel interestsPanel = new JPanel();
        interestsPanel.setLayout(new GridLayout(0, 2));
        interestsPanel.setBounds(20, 430, 320, 80);
        add(interestsPanel);

        String[] allTags = {"Academic", "Culture", "Creative", "Career", "Physcial Activity", "Social", "Other"};
        for (String tag : allTags) {
            JCheckBox checkBox = new JCheckBox(tag);
            checkBox.setSelected(interests.contains(tag));
            interestCheckboxes.add(checkBox);
            interestsPanel.add(checkBox);
        }

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(250, 540, 90, 30);
        saveButton.setBackground(new Color(0, 123, 255));
        saveButton.setForeground(Color.BLACK); // Changed to white for better visibility
        saveButton.setFocusPainted(false);
        add(saveButton);

        saveButton.addActionListener(_ -> saveProfile());
        
        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 540, 90, 30);
        cancelButton.setBackground(new Color(200, 200, 200));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setFocusPainted(false);
        add(cancelButton);

        cancelButton.addActionListener(_ -> {
            if (controller != null)
            {
                controller.showMyProfile();
            }
            else
            {
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window != null) 
                {
                    window.dispose();
                }
            }
        });
    }

    private void saveProfile() {
        // Get new values from inputs
    String newName = nameInput.getText();
    String newAbout = aboutInput.getText();
    List<String> newInterests = new ArrayList<>();
    for (JCheckBox cb : interestCheckboxes) {
        if (cb.isSelected()) {
            newInterests.add(cb.getText());
        }
    }
    ImageIcon newImage = selectedImage != null ? selectedImage : (ImageIcon) previewImage.getIcon();

    // Update user object via controller (or direct reference)
    controller.getUser().setName(newName);
    controller.getUser().setBio(newAbout);
    controller.getUser().setImage(newImage);
    controller.getUser().setInterests(newInterests);
    
        // Notify controller to update database and refresh profile UI
        if (controller != null) {
            // controller.updateUserProfile(user);
            controller.showMyProfile();
        }
    
        // // Close window if applicable
        // Window window = SwingUtilities.getWindowAncestor(this);
        // if (window != null) {
        //     window.dispose();
        // }
        
        JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void refreshData() {
    this.user = controller.getUser();
    nameInput.setText(user.getName());
    aboutInput.setText(user.getBio());
    previewImage.setIcon(user.getImage());
    selectedImage = null; // reset to ensure updates happen properly

    // Update checkboxes based on interests
    List<String> interests = user.getInterests();
    for (JCheckBox cb : interestCheckboxes) {
        cb.setSelected(interests.contains(cb.getText()));
    }
}


    // Main method for testing
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        User testUser = new User(
            "Jane Doe",
            "I love hiking and reading.",
            new ImageIcon(new BufferedImage(96, 90, BufferedImage.TYPE_INT_ARGB)),
            List.of("Culture", "Creative")
        );

        JFrame frame = new JFrame("Edit My Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EditMyProfile(null));  // controller is null for UI test
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
}

}