import java.util.ArrayList;

public class ContactList {
    // instance variable
    private ArrayList<Person> contacts;
    // constructor
    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    // getter
    public ArrayList<Person> getContacts() {
        return contacts;
    }
    // adds a contact
    public void addContact (Person p) {
        contacts.add(p);
    }

    public void printActions() {
        System.out.println("Welcome to your contacts List" +
                           "\nPlease pick from the following menu options" +
                           "\n" +
                           "\n" +
                           "\nMenu:" +
                           "\n1. Add Contact" +
                           "\n2. List All Contacts By First Name" +
                           "\n3. List All Contacts By Last Name" +
                           "\n4. List All Contacts By Phone Number" +
                           "\n5. List All Lumberjacks" +
                           "\n6. Search By First Name" +
                           "\n7. Search By Last Name" +
                           "\n8. Search By Phone Number" +
                           "\n0. Exit");
    }
public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }
}