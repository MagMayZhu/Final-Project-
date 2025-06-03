import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CreateEvent extends JPanel {
    private static final Color ORANGE = new Color(0xFF9500);
    private static final Color GRAY = new Color(0xCCCCCC);

    private JTextField nameField, dateField, timeField, locationField, hostField;
    private JTextArea descriptionArea;
    private JLabel imageLabel;

    public CreateEvent() {
        setLayout(null);
        setBackground(Color.WHITE);

        addBackButton();
        addTitle();
        addImage();
        addFields();
        addEventDescription();
        addFilterButtons();
        addPublishButton();
    }

    private void addBackButton() {
        JButton backButton = new JButton("\u2190");
        backButton.setBounds(10, 10, 60, 30);
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 25));
        backButton.addActionListener(_ -> {
            JOptionPane.showMessageDialog(this, "Back button clicked!");
        });
        add(backButton);
    }

    private void addTitle() {
        JLabel title = new JLabel("Create Event");
        title.setFont(new Font("Alata", Font.PLAIN, 20));
        title.setBounds(80, 8, 200, 40);
        add(title);
    }

    private void addImage() {
        imageLabel = new JLabel(getScaledImageIcon("UploadImage.png", 170, 170));
        imageLabel.setBounds((375 - 200) / 2, 55, 170, 170);
        imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(CreateEvent.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    imageLabel.setIcon(getScaledImageIcon(selectedFile.getAbsolutePath(), 170, 170));
                }
            }
        });
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel);
    }

    private void addFields() {
        int y = 260;
        nameField = createPlaceholderField("Event Name", 50, y); y += 50;
        dateField = createPlaceholderField("MM/DD/YYYY", 50, y); y += 50;
        timeField = createPlaceholderField("HH:MM AM/PM", 50, y); y += 50;
        locationField = createPlaceholderField("Location", 50, y); y += 50;
        hostField = createPlaceholderField("Host", 50, y);
    }

    private JTextField createPlaceholderField(String placeholder, int x, int y) {
        JLabel label = new JLabel(placeholder + ":");
        label.setFont(new Font("Alata", Font.BOLD, 16));
        label.setBounds(x, y - 20, 280, 20);
        add(label);

        JTextField field = new JTextField(placeholder);
        field.setForeground(Color.GRAY);
        field.setFont(new Font("Alata", Font.PLAIN, 14));
        field.setBounds(x, y, 280, 30);
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

        add(field);
        return field;
    }

    private void addEventDescription() {
        JLabel label = new JLabel("Description:");
        label.setFont(new Font("Alata", Font.BOLD, 16));
        label.setBounds(50, 490, 300, 20);
        add(label);

        descriptionArea = new JTextArea("Enter event description...");
        descriptionArea.setForeground(Color.GRAY);
        descriptionArea.setFont(new Font("Alata", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        descriptionArea.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (descriptionArea.getText().equals("Enter event description...")) {
                    descriptionArea.setText("");
                    descriptionArea.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (descriptionArea.getText().isEmpty()) {
                    descriptionArea.setText("Enter event description...");
                    descriptionArea.setForeground(Color.GRAY);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        scrollPane.setBounds(50, 510, 280, 50);
        add(scrollPane);
    }

    private void addFilterButtons() {
        JLabel label = new JLabel("Filters:");
        label.setFont(new Font("Alata", Font.BOLD, 16));
        label.setBounds(50, 560, 100, 20);
        add(label);

        String[] filters = { "Party", "Club", "Sport", "Event", "Art", "Food" };

        int xStart = 50;
        int y = 590;
        int width = 120;
        int height = 35;
        int gap = 10;
        int count = 0;

        for (String filter : filters) {
            JButton button = new JButton(filter);
            button.setFont(new Font("Alata", Font.PLAIN, 14));
            button.setBounds(xStart + (count % 2) * (width + gap), y, width, height);
            styleFilterButton(button, false);
            button.addActionListener(e -> {
                boolean isSelected = button.getBackground().equals(ORANGE);
                styleFilterButton(button, !isSelected);
            });
            add(button);
            count++;
            if (count % 2 == 0) y += height + gap;
        }
    }

    private void styleFilterButton(JButton button, boolean selected) {
        button.setBackground(selected ? ORANGE : GRAY);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    }

    private void addPublishButton() {
        JButton publish = new JButton("Publish Event");
        publish.setBounds(100, 725, 180, 40);
        publish.setFont(new Font("Alata", Font.BOLD, 16));
        publish.setBackground(ORANGE);
        publish.setForeground(Color.WHITE);
        publish.setFocusPainted(false);

        publish.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Event published!");

            // For now, just print; later you can call controller.switchTo("EventDetail");
            System.out.println("Go to EventDetail screen...");
        });

        add(publish);
    }

    private ImageIcon getScaledImageIcon(String path, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(originalImage, 0, 0, width, height, null);
            g2d.dispose();
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Main method for standalone testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Create Event");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(375, 812);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new CreateEvent());
            frame.setVisible(true);
        });
    }
}
