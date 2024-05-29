import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên từ người dùng
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();

        // Tính UCLN
        int ucln = findGCD(num1, num2);

        // In kết quả
        System.out.println("Ước chung lớn nhất của " + num1 + " và " + num2 + " là: " + ucln);
    }

    // Hàm tính UCLN sử dụng thuật toán Euclid
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}