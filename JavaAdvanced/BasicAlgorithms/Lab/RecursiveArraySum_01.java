package JavaAdvanced.BasicAlgorithms.Lab;

import java.util.Scanner;

public class RecursiveArraySum_01 {
    public static int recursiveArraySum(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int currentElement = arr[index];
        int nextSum = recursiveArraySum(arr, index + 1);

        return currentElement + nextSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numStrings = input.split(" ");
        int[] array = new int[numStrings.length];

        for (int i = 0; i < numStrings.length; i++) {
            array[i] = Integer.parseInt(numStrings[i]);
        }

        int sumOfArray = recursiveArraySum(array, 0);
        System.out.println(sumOfArray);

        scanner.close();
    }
}
