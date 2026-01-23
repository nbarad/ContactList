import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // instance variable
    private ArrayList<Person> contacts; // list of contacts
    private Scanner check; // input
    private int action; // determine which action the user wants
    // constructor
    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
        check = new Scanner(System.in);
        action = -1;
    }

    // getter
    public ArrayList<Person> getContacts() {
        return contacts;
    }
    // adds a contact
    public void addContact (Person p) {
        contacts.add(p);
    }
    // prints menu screen
    public void printActions() {
        System.out.print(  "\nMenu:" +
                           "\n1. Add Contact" +
                           "\n2. List All Contacts By First Name" +
                           "\n3. List All Contacts By Last Name" +
                           "\n4. List All Contacts By Phone Number" +
                           "\n5. List All Students" +
                           "\n6. Search By First Name" +
                           "\n7. Search By Last Name" +
                           "\n8. Search By Phone Number" +
                           "\n0. Exit\n");
    }
    // prints all contacts
    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }
    // bubble sorts alphabetically by last name if sortby is 0, first name if 1, and phone number if 2
    public void sort(int sortBy) {
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size(); i++) {// bubble sort algorithm
                for (int j = 0; j < i - 1; j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {// determine if a swap is needed, using compareTo
                        contacts.add(j, contacts.remove(j + 1)); // swaps elements
                    }
                }
            }
        }
        else if (sortBy == 1) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < i - 1; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        contacts.add(j, contacts.remove(j + 1));
                    }
                }
            }
        }
        else if (sortBy == 2) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < i - 1; j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        contacts.add(j, contacts.remove(j + 1));
                    }
                }
            }
        }
    }
    // returns the person if it exists, otherwise null
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }
    // same as above except uses last name
    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }
    // same as above except uses phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }
    // prints out all students in contacts
    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student) {// checks if p is a student
                System.out.println(p);
            }
        }
    }
    // get an integer input. returns the input and takes in boundaries and the message
    public int getIntInput(int min, int max, String message) {
        int input;
        System.out.print(message);
        do {
            input = check.nextInt();
        }
        while (input < min || input > max );
        check.nextLine(); // so that getString doesn't get messed up
        return input;
    }
    // get a string input
    public String getStringInput(String message) {

        System.out.println(message);
        return check.nextLine();

    }
    // main game loop
    public void run() {
        // action is a contactlist instance variable which starts at -1
        while (action != 0) {
            printActions();
            action = getIntInput(0,8, ""); // get input for action

            switch (action) { // switch case for all values of action
                case 1:// add a contact
                    int which = getIntInput(1,2, "Select a type of contact to add" + // determine which kind of person
                                                                    "\n1. Student" +
                                                                    "\n2. Lumberjack\n");
                    switch(which) {
                        case 1:// nested switch case to add a new contact to the list using 4 get String inputs or 1 get int.
                            addContact(new Student(getStringInput("Please fill out the following information.\nFirst Name:"),
                                                      getStringInput("Last Name: "),
                                                      getStringInput("Phone number: "),
                                                      getIntInput(1, 12, "Grade: ")));
                            break;
                        case 2:
                            addContact(new Lumberjack(getStringInput("Please fill out the following information.\nFirst Name: "),
                                                      getStringInput("Last Name: "),
                                                      getStringInput("Phone number: "),
                                                      getStringInput("Favorite Tree: ")));
                            break;
                    }
                    break;

                case 2: // Sort by first name
                    sort(1);
                    printContacts();
                    break;
                case 3: // Sort by last name
                    sort(0);
                    printContacts();
                    break;
                case 4: // Sort by phone number
                    sort(2);
                    printContacts();
                    break;
                case 5: // print out all students
                    listStudents();
                    break;
                case 6: // Search by first name, determines if a person has the inputted first name
                    String firstName = getStringInput("Enter First Name: ");
                    Person a = searchByFirstName(firstName);
                    if (a == null) {
                        System.out.println(firstName + "is not in the list");
                    }
                    else {
                        System.out.println(a);
                    }
                    break;
                case 7:// Search by last name, determines if a person has the inputted last name
                    String lastName = getStringInput("Enter Last Name: ");
                    Person b = searchByLastName(lastName);
                    if (b == null) {
                        System.out.println(lastName + "is not in the list");
                    }
                    else {
                        System.out.println(b);
                    }
                    break;
                case 8: // Search by phone number, determines if a person has the inputted phone number
                    String phoneNumber = getStringInput("Enter Phone Number: ");
                    Person c = searchByPhoneNumber(phoneNumber);
                    if (c == null) {
                        System.out.println(phoneNumber + "is not in the list");
                    }
                    else {
                        System.out.println(c);
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ContactList c = new ContactList(new ArrayList<Person>()); // ContactList object
        System.out.print("Welcome to your contacts List" + // instructions
                "\nPlease pick from the following menu options" +
                "\n" +
                "\n" );
        c.run(); // main game loop
    }
}