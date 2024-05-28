import java.util.Scanner;
public class timsole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kích thước mảng: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Nhập phần tử cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Các số lẻ trong mảng: ");
        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
            }
        }
        scanner.close();
    }
}
