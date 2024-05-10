import java.time.LocalDate;
public class Passenger {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String passportNumber;
    private LocalDate dateOfFlight;

    public void displayPassengerDetails() {
        System.out.println("\n\nFull Name:\t" + firstName + " " + lastName + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nPassport Number:            " + passportNumber + "\nDate of Flight (yyyy/mm/dd):\t" + dateOfFlight);
    }

    // Getters and setters
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
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
}
