import java.util.ArrayList;
import java.util.List;

class Contact {
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

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
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
    }

    public void removeContact(String fullName) {
        contacts.removeIf(contact -> contact.getFullName().equals(fullName));
    }

    public Contact findContact(String fullName) {
        for (Contact contact : contacts) {
            if (contact.getFullName().equals(fullName)) {
                return contact;
            }
        }
        return null;
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
        List<String> phoneNumbers1 = new ArrayList<>();
        phoneNumbers1.add("0123456789");
        Contact contact1 = new Contact("Nguyễn Văn A", "Anh A", "123 Đường A, TP.HCM", "anhnva@example.com", phoneNumbers1);

        List<String> phoneNumbers2 = new ArrayList<>();
        phoneNumbers2.add("0987654321");
        phoneNumbers2.add("0123456788");
        Contact contact2 = new Contact("Trần Thị B", "Chị B", "456 Đường B, Hà Nội", "bitran@example.com", phoneNumbers2);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact(contact1);
        phoneBook.addContact(contact2);

        System.out.println(phoneBook);

        // Add a phone number to contact1
        contact1.addPhoneNumber("0912345678");
        System.out.println("\nAfter adding a phone number to Nguyễn Văn A:");
        System.out.println(phoneBook);

        // Remove a phone number from contact2
        contact2.removePhoneNumber("0123456788");
        System.out.println("\nAfter removing a phone number from Trần Thị B:");
        System.out.println(phoneBook);

        // Find a contact
        Contact foundContact = phoneBook.findContact("Nguyễn Văn A");
        if (foundContact != null) {
            System.out.println("\nFound contact:");
            System.out.println(foundContact);
        } else {
            System.out.println("\nContact not found");
        }
    }
}
