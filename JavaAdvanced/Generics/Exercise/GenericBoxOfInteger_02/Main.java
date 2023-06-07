package JavaAdvanced.Generics.Exercise.GenericBoxOfInteger_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(num);
            System.out.println(box);
        }
    }
}