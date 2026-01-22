public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    // Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    // ToString
    @Override
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
