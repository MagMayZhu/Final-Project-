import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EditMyProfile extends JFrame {
    private JTextField nameInput;
    private JTextArea aboutInput;
    private JLabel previewImage;
    private ImageIcon selectedImage;
    private MyProfile mainProfile;
    private List<JCheckBox> interestCheckboxes = new ArrayList<>();

    

    public EditMyProfile(MyProfile profileRef, String currentName, String currentAbout, Icon currentIcon, java.util.List<String> interests) {
        this.mainProfile = profileRef;

        setTitle("Edit Profile");
        setSize(375, 620);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Center the window on screen

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
                selectedImage = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(96, 90, Image.SCALE_SMOOTH));
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

        aboutInput = new JTextArea(currentAbout);
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
    saveButton.setForeground(Color.BLACK);
    add(saveButton);

    saveButton.addActionListener(_ -> {
        String newName = nameInput.getText();
        String newAbout = aboutInput.getText();
        List<String> newInterests = new ArrayList<>();
        for (JCheckBox cb : interestCheckboxes) {
            if (cb.isSelected()) {
                newInterests.add(cb.getText());
            }
        }
        if (selectedImage == null) {
            Icon icon = previewImage.getIcon();
            if (icon instanceof ImageIcon) {
                selectedImage = (ImageIcon) icon;
            }
        }
        mainProfile.updateProfile(newName, newAbout, selectedImage, newInterests);
        JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Close this window
    });

    setVisible(true); // Make sure this is called!
    }
}
