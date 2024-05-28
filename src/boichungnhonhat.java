import java.util.Scanner;

public class boichungnhonhat {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();
        
        int lcm = lcm(num1, num2);
        
        System.out.println("Bội chung nhỏ nhất của " + num1 + " và " + num2 + " là: " + lcm);
        
        scanner.close();
    }
}
