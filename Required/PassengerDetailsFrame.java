import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class PassengerDetailsFrame extends JFrame {
    private Passenger passenger;

    // Constructor
    public PassengerDetailsFrame(Passenger passenger) {
        this.passenger = passenger;
        initialize();
    }

    // Method to initialize the frame components
    private void initialize() {
        setTitle("Aerocheck Boarding Pass");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        // Set custom icon
        ImageIcon icon = new ImageIcon("airplane.png");
        setIconImage(icon.getImage());

        // Create a panel with a boarding pass layout
        BoardingPassPanel panel = new BoardingPassPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the panel
        panel.add(createHeader(), BorderLayout.NORTH);
        panel.add(createPassengerInfo(), BorderLayout.CENTER);
        panel.add(createFooter(), BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
    }

    // Method to create the header of the boarding pass
    private JPanel createHeader() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel headerLabel = new JLabel("BOARDING PASS");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        return headerPanel;
    }

    // Method to create the passenger information section
    private JPanel createPassengerInfo() {
    
    JPanel infoPanel = new JPanel(new GridLayout(0, 1, 0, 10));
    
    // Style the infoPanel
    infoPanel.setBackground(new Color(240, 240, 240)); // Set background color
    infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
    infoPanel.setPreferredSize(new Dimension(300, 200)); // Set preferred size
    
    // Add rounded corners and shadow effect (optional)
    infoPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1), // Border color
            BorderFactory.createEmptyBorder(10, 10, 10, 10) // Inner padding
    ));
    infoPanel.setOpaque(false); // Make panel transparent to see background
    
    // Add components to the infoPanel
    infoPanel.add(createInfoLabel("Name: " + passenger.getFirstName() + " " + passenger.getLastName()));
    infoPanel.add(createInfoLabel("Age: " + passenger.getAge()));
    infoPanel.add(createInfoLabel("Gender: " + passenger.getGender()));
    infoPanel.add(createInfoLabel("Passport Number: " + passenger.getPassportNumber()));
    infoPanel.add(createInfoLabel("Date of Flight: " + passenger.getDateOfFlight().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))));
    infoPanel.add(createInfoLabel("Journey: " + passenger.getJourney()));
    infoPanel.add(createInfoLabel("Luggage Weight: " + (passenger.getLuggageWeight() == 0.0 ? "N/A" : passenger.getLuggageWeight() + " Kg")));
    infoPanel.add(createInfoLabel("Special Needs: " + (passenger.isSpecialNeedsAssistance() ? "Required" : "Not Required")));
    infoPanel.add(createInfoLabel("Baggage Tag: " + passenger.getBaggageTag()));

    return infoPanel;
}

// Method to create a styled JLabel for passenger information
private JLabel createInfoLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Arial", Font.PLAIN, 14));
    label.setForeground(Color.DARK_GRAY);
    return label;
}
    // Method to create the footer of the boarding pass
    private JPanel createFooter() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel = new JLabel("Have a pleasant journey!");
        footerPanel.add(footerLabel);
        return footerPanel;
    }

    // Custom panel for boarding pass appearance
    private class BoardingPassPanel extends JPanel {
        public BoardingPassPanel() {
            setBackground(Color.WHITE);
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(400, 300));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw a boarding pass design (optional)
            // For example, you can draw lines, shapes, or add images here
        }
    }
}
