package JavaOOP.WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= size; i++) {
            printRow(i, size - i);
        }
        for (int i = size - 1; i > 0; i--) {
            printRow(i, size - i);
        }
    }
    public static void printRow(int countStars, int countOfSpaces) {
        for (int i = 0; i < countOfSpaces; i++) {
            System.out.print(" ");
        }
        for (int col = 1; col < countStars; col++) {
                System.out.print("* ");
        }
            System.out.println("*");
        }
}
