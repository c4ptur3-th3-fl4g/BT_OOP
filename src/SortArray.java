/*viết chương trình nhập vào một mảng và sắp xếp theo thứ tự tăng dần*/
import java.util.Arrays;
import java.util.Scanner;
public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Mảng sau khi sắp xếp: ");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        scanner.close();
    }
}
