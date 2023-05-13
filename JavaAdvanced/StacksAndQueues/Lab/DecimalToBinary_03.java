package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();
        int inputNum = Integer.parseInt(scanner.nextLine());

        if (inputNum == 0) {
            System.out.println(inputNum);
        } else {
            while (inputNum != 0) {
                binaryStack.push(inputNum % 2);
                inputNum /= 2;
            }
            String output = "";
            while (!binaryStack.isEmpty()) {
                output += binaryStack.peek();
                binaryStack.pop();
            }
            System.out.println(output);
        }
    }
}
