package JavaOOP.ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ranges = scanner.nextLine();

        int startOfRange = Integer.parseInt(ranges.split(" ")[0]);
        int endOfRange = Integer.parseInt(ranges.split(" ")[1]);

        System.out.printf("Range: [%d...%d]\n", startOfRange, endOfRange);

        while (true) {
            String input = scanner.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (num >= startOfRange && num <= endOfRange) {
                    System.out.printf("Valid number: %d\n", num);
                    break;
                } else {
                    System.out.printf("Invalid number: %d\n", num);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Invalid number: %s\n", input);
            }
        }
    }
}