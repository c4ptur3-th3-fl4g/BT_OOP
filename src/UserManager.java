import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    public User(String fullName, String email, String password, String phoneNumber, String address) throws NoSuchAlgorithmException {
        this.fullName = fullName;
        this.email = email;
        this.password = hashPassword(password);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
        
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }
    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
public class UserManager {
    private List<User> users = new ArrayList<>();
    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(String fullName, String email, String password, String phoneNumber, String address) throws NoSuchAlgorithmException {
        User newUser = new User(fullName, email, password, phoneNumber, address);
        if (!users.contains(newUser)) {
            users.add(newUser);
        } else {
            System.out.println("Người dùng đã tồn tại");
        }
    }

    public String login(String email, String password) throws NoSuchAlgorithmException {
        for (User user : users) {
           if (user.getEmail().equals(email)) {
            String hashedPassword = new User("", "", "", "", password).getPassword();
            if (user.getPassword().equals(hashedPassword)) {
                return "Đăng nhập thành công";
            } else {
                return "Sai mật khẩu";
            }
           }
        }
        return "Người dùng không tồn tại";
    }

    public void removeUser(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                users.remove(user);
                return;
            }
        }
        System.out.println("Người dùng không tồn tại");
    }

    public List<User> searchUserByName(String fullName) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.getFullName().equalsIgnoreCase(fullName)) {
                result.add(user);
            }
        }
        return result;
    }
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Thêm người dùng mới");
            System.out.println("2. Kiểm tra đăng nhập");
            System.out.println("3. Tìm kiếm người dùng theo tên");
            System.out.println("4. In ra thông tin người dùng khi biết địa chỉ email");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Nhập họ và tên: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Nhập email: ");
                        String email = scanner.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Nhập địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String password = scanner.nextLine();
                        userManager.addUser(fullName, email, phoneNumber, address, password);
                        break;
                    case 2:
                        System.out.print("Nhập email: ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Nhập mật khẩu: ");
                        String loginPassword = scanner.nextLine();
                        String result = userManager.login(loginEmail, loginPassword);
                        System.out.println(result);
                        break;
                    case 3:
                        System.out.print("Nhập tên người dùng: ");
                        String searchName = scanner.nextLine();
                        List<User> users = userManager.searchUserByName(searchName);
                        for (User user : users) {
                            System.out.println(user);
                        }
                        if (users.isEmpty()) {
                            System.out.println("Không tìm thấy người dùng nào.");
                        }
                        break;
                    case 4:
                        System.out.print("Nhập địa chỉ email: ");
                        String searchEmail = scanner.nextLine();
                        User user = userManager.getUserByEmail(searchEmail);
                        if (user != null) {
                            System.out.println(user);
                        } else {
                            System.out.println("Không tìm thấy người dùng với email này.");
                        }
                        break;
                    case 5:
                        scanner.close();
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }
}

