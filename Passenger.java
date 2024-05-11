import java.time.LocalDate;
public class Passenger {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String passportNumber;
    private LocalDate dateOfFlight;
    private double LuggageWeight;

    public void displayPassengerDetails() {
        System.out.println(


        "\n"+
        "_____________________________________________________________________________________________________________________________________________________\n"+
        "| passanger details"+"\n"+
        "|"+"\n"+
        "|"+"Full Name                  :" + firstName + " " + lastName + "\n"+
        "|"+"Age                        :" + age + " years old." + "\n"+
        "|"+"Gender                     :" + gender + "\n"+
        "|"+"Passport Number            :" + passportNumber + "\n"+
        "|"+"Date of Flight (yyyy/mm/dd):" + dateOfFlight + "\n"+
        "|" + "Luggage Weight             :" + LuggageWeight + "\n" +
        "_____________________________________________________________________________________________________________________________________________________"
        
        );
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


    public void setLuggageWeight(double nextDouble) {
        this.LuggageWeight = nextDouble;
    }
}