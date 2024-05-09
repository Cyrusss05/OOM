import java.time.LocalDate;
public class Passenger {
    private String name;
    private int age;
    private char gender;
    private String passportNumber;
    private LocalDate dateOfFlight;

    public void displayPassengerDetails() {
        System.out.println("\nPassenger details are as follows:\nName:\t" + name + "\nAge:\t" + age + " years old." + "\nGender:\t" + gender + "\nPassport Number:\t" + passportNumber + "\nDate of Flight:\t" + dateOfFlight);
    }

    // Getters and setters
    public void setName(String name) {
        this.name = name;
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
