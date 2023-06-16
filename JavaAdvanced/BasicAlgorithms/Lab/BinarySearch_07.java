package JavaAdvanced.BasicAlgorithms.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] arr = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int key = scanner.nextInt();

        int index = binarySearch(arr, key);
        System.out.println(index);
    }
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
