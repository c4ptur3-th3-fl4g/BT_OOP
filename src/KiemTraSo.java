import java.util.Scanner;

public class KiemTraSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số cần kiểm tra: ");
        int number = scanner.nextInt();
        if (isPerfectNumber(number)) {
            System.out.println(number + " là số hoàn hảo");
        } else {
            System.out.println(number + " không phải là số hoàn hảo");
        }
        
        scanner.close();
    }
    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
