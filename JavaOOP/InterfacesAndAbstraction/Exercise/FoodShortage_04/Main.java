package JavaOOP.InterfacesAndAbstraction.Exercise.FoodShortage_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        List<Buyer> buyers = new ArrayList<>();

        while (lines-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");

            if (info.length == 4) {
                buyers.add(new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3]));
            } else {
                buyers.add(new Rebel(info[0], Integer.parseInt(info[1]), info[2]));
            }
        }
        String input = "";
        while (!(input = scanner.nextLine()).equals("End")) {
            String finalInput = input;
            buyers.stream().filter(b -> b.getName().equals(finalInput)).findFirst().ifPresent(Buyer::buyFood);
        }
        int totalFood = buyers.stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
