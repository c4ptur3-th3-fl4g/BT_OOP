import java.util.Scanner;

public class TimSoBeNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");

        for (int i = 0; i < n; i++) {
            System.out.print("phần tử thứ " + (i + 1) + ":");
            arr[i] = scanner.nextInt();
        }

        int min = findMinValue(arr);
        System.out.println("Phần tử nhỏ nhất trong mảng là: " + min);
        scanner.close();
    }

    public static int findMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
