package JavaOOP.ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 10) {
            int number = readNumber(start, end, scanner);

            if (number <= 0) {
                continue;
            }

            numbers.add(number);
            start = number;
        }
        System.out.println(numbers.toString().replace("[", "").replace("]", ""));
    }

    public static int readNumber(int start, int end, Scanner scanner) {

        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());

            if (number <= start || number >= end) {
                System.out.printf("Your number is not in range %d - 100!\n", start);
                number = -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
        }
        return number;
    }
}
