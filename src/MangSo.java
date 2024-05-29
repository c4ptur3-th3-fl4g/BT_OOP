import java.util.Scanner;

public class MangSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập độ dài mảng
        System.out.print("Nhập độ dài của mảng: ");
        int length = scanner.nextInt();

        // Khởi tạo mảng và nhập các phần tử
        int[] array = new int[length];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        // Nhập hai số a và b
        System.out.print("Nhập số a: ");
        int a = scanner.nextInt();
        
        System.out.print("Nhập số b: ");
        int b = scanner.nextInt();

        // In các số trong đoạn [a, b]
        System.out.println("Các số trong đoạn [" + a + ", " + b + "] là:");
        for (int i = 0; i < length; i++) {
            if (array[i] >= a && array[i] <= b) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
