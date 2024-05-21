import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Contact implements Comparable<Contact> {
    private String fullName;
    private String nickname;
    private String address;
    private String email;
    private List<String> phoneNumbers;

    public Contact(String fullName, String nickname, String address, String email, List<String> phoneNumbers) {
        this.fullName = fullName;
        this.nickname = nickname;
        this.address = address;
        this.email = email;
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
    }

    public void addPhoneNumber(String phoneNumber) {
        if (!phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        }
    }

    public void removePhoneNumber(String phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }

    @Override
    public int compareTo(Contact other) {
        return this.fullName.compareTo(other.fullName);
    }

    @Override
    public String toString() {
        return "Name: " + fullName + " (Nickname: " + nickname + ")\n" +
               "Address: " + address + "\n" +
               "Email: " + email + "\n" +
               "Phone Numbers: " + String.join(", ", phoneNumbers);
    }
}

class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        Collections.sort(contacts);
    }

    public void removeContact(String fullName) {
        contacts.removeIf(contact -> contact.getFullName().equals(fullName));
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumbers().contains(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(String fullName) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = findContactByFullName(fullName);
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }
        
        System.out.print("Enter new full name (or press Enter to keep current): ");
        String newFullName = scanner.nextLine();
        if (!newFullName.isEmpty()) {
            contact.setFullName(newFullName);
        }

        System.out.print("Enter new nickname (or press Enter to keep current): ");
        String newNickname = scanner.nextLine();
        if (!newNickname.isEmpty()) {
            contact.setNickname(newNickname);
        }

        System.out.print("Enter new address (or press Enter to keep current): ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            contact.setAddress(newAddress);
        }

        System.out.print("Enter new email (or press Enter to keep current): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            contact.setEmail(newEmail);
        }

        List<String> newPhoneNumbers = new ArrayList<>();
        while (true) {
            System.out.print("Enter new phone number (or 'done' to finish): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.equalsIgnoreCase("done")) {
                break;
            }
            newPhoneNumbers.add(phoneNumber);
        }
        if (!newPhoneNumbers.isEmpty()) {
            contact.setPhoneNumbers(newPhoneNumbers);
        }

        Collections.sort(contacts);
    }

    public Contact findContactByFullName(String fullName) {
        for (Contact contact : contacts) {
            if (contact.getFullName().equals(fullName)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(contact).append("\n\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Phone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Find Contact by Phone Number");
            System.out.println("4. Update Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter nickname: ");
                    String nickname = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    List<String> phoneNumbers = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter phone number (or 'done' to finish): ");
                        String phoneNumber = scanner.nextLine();
                        if (phoneNumber.equalsIgnoreCase("done")) {
                            break;
                        }
                        phoneNumbers.add(phoneNumber);
                    }
                    Contact newContact = new Contact(fullName, nickname, address, email, phoneNumbers);
                    phoneBook.addContact(newContact);
                    break;
                case 2:
                    System.out.print("Enter full name of contact to remove: ");
                    String nameToRemove = scanner.nextLine();
                    phoneBook.removeContact(nameToRemove);
                    break;
                case 3:
                    System.out.print("Enter phone number to search: ");
                    String phoneToSearch = scanner.nextLine();
                    Contact foundContact = phoneBook.findContactByPhoneNumber(phoneToSearch);
                    if (foundContact != null) {
                        System.out.println("Contact found:");
                        System.out.println(foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter full name of contact to update: ");
                    String nameToUpdate = scanner.nextLine();
                    phoneBook.updateContact(nameToUpdate);
                    break;
                case 5:
                    System.out.println("All contacts:");
                    System.out.println(phoneBook);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
