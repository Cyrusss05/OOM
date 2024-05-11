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
        setTitle("Passenger Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add components to the panel
        addComponent(panel, new JLabel("Full Name: " + passenger.getFirstName() + " " + passenger.getLastName()), constraints, 0, 0);
        addComponent(panel, new JLabel("Age: " + passenger.getAge() + " years old"), constraints, 0, 1);
        addComponent(panel, new JLabel("Gender: " + passenger.getGender()), constraints, 0, 2);
        addComponent(panel, new JLabel("Passport Number: " + passenger.getPassportNumber()), constraints, 0, 3);
        addComponent(panel, new JLabel("Date of Flight: " + passenger.getDateOfFlight().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))), constraints, 0, 4);
        addComponent(panel, new JLabel("Total Luggage Weight: " + (passenger.getLuggageWeight() == 0.0 ? "Not Applicable" : passenger.getLuggageWeight() + " Kg")), constraints, 0, 5);
        addComponent(panel, new JLabel("Special Needs Assistance: " + (passenger.isSpecialNeedsAssistance() ? "Required" : "Not Required")), constraints, 0, 6);
        addComponent(panel, new JLabel("Baggage Tag: " + passenger.getBaggageTag()), constraints, 0, 7);

        getContentPane().add(panel);
        pack();
    }

    // Method to add components to the panel with specified constraints
    private void addComponent(Container container, Component component, GridBagConstraints constraints, int gridx, int gridy) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        container.add(component, constraints);
    }
}
