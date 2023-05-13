package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String operator = null;
        for (String item : inputArr) {
            if (item.equals("+") || item.equals("-")) {
                operator = item;
            } else if (stack.isEmpty()) {
                stack.push(Integer.parseInt(item));
            } else {
                int currentNumber = Integer.parseInt(item);
                int lastNumber = stack.peek();
                stack.pop();
                if (operator.equals("+")) {
                    stack.push(currentNumber + lastNumber);
                } else {
                    stack.push(lastNumber - currentNumber);
                }
            }
        }
        System.out.println(stack.peek());
    }
}
