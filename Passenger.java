import java.time.LocalDate;

public class Passenger {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String passportNumber;
    private LocalDate dateOfFlight;
    private double luggageWeight;

    // Constructor
    public Passenger(String firstName, String lastName, int age, char gender, String passportNumber, LocalDate dateOfFlight, double luggageWeight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.passportNumber = passportNumber;
        this.dateOfFlight = dateOfFlight;
        this.luggageWeight = luggageWeight;
    }

    // Display passenger details method
    public void displayPassengerDetails() {
        System.out.println(
            "\n" +
            "_____________________________________________________________________________________________________________________________________________________\n" +
            "|" + "passenger details\n" +
            "|\n" +
            "|" + "Full Name                  :" + firstName + " " + lastName + "\n" +
            "|" + "Age                        :" + age + " years old." + "\n" +
            "|" + "Gender                     :" + gender + "\n" +
            "|" + "Passport Number            :" + passportNumber + "\n" +
            "|" + "Date of Flight (yyyy/mm/dd):" + dateOfFlight + "\n" +
            "|" + "Luggage Weight             :" + luggageWeight + "\n" +
            "_____________________________________________________________________________________________________________________________________________________"
        );
    }

    // Getters and setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }
}
