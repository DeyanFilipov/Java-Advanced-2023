package JavaAdvanced.BasicAlgorithms.Lab;

import java.util.Scanner;

public class RecursiveFactorial_02 {
    public static int recursiveFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int factorial = recursiveFactorial(number);
        System.out.println(factorial);

        scanner.close();
    }
}
