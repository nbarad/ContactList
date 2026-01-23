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
    public void sort(int sortBy) {
        if (sortBy == 0) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = 0; j < i - 1; j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        contacts.add(j, contacts.remove(j + 1));
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

    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }
■   public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }
■   public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    
}