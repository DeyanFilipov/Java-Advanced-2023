package JavaAdvanced.Generics.Exercise.Threeuple_11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                String[] input = scanner.nextLine().split("\\s+");
                String name = input[0] + " " + input[1];
                String address = input[2];
                String city = input[3];
                Threeuple<String, String, String> firstList = new Threeuple<>(name, address, city);
                System.out.println(firstList);
            } else if (i == 1) {
                String[] input = scanner.nextLine().split("\\s+");
                String name = input[0];
                int liters = Integer.parseInt(input[1]);
                boolean isDrunk = input[2].equals("drunk");
                Threeuple<String, Integer, Boolean> secondList = new Threeuple<>(name, liters, isDrunk);
                System.out.println(secondList);
            } else {
                String[] input = scanner.nextLine().split("\\s+");
                String name = input[0];
                double accountBalance = Double.parseDouble(input[1]);
                String bankName = input[2];
                Threeuple<String, Double, String> thirdList = new Threeuple<>(name, accountBalance, bankName);
                System.out.println(thirdList);
            }
        }
    }
}
