
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

public class AddressBookApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search for Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addContact(addressBook, scanner);
                    break;
                case 2:
                    removeContact(addressBook, scanner);
                    break;
                case 3:
                    searchContact(addressBook, scanner);
                    break;
                case 4:
                    addressBook.displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private static void addContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
            Contact contact = new Contact(name, phoneNumber, emailAddress);
            addressBook.addContact(contact);
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Invalid input. Name, phone number, and email address are required.");
        }
    }

    private static void removeContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to remove: ");
        String name = scanner.nextLine();

        addressBook.removeContact(name);
        System.out.println("Contact removed successfully.");
    }

    private static void searchContact(AddressBook addressBook, Scanner scanner) {
        System.out.print("Enter the name of the contact to search: ");
        String name = scanner.nextLine();

        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found:\n" + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

}
