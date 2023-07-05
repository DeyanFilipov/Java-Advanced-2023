package JavaOOP.InterfacesAndAbstraction.Exercise.BirthdayCelebrations_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        List<Birthable> birthables = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] info = input.split("\\s+");
            switch (info[0]) {
                case "Citizen":
                    birthables.add(new Citizen(info[1], Integer.parseInt(info[2]), info[3], info[4]));
                    break;
                case "Pet":
                    birthables.add(new Pet(info[1], info[2]));
                    break;
            }
        }
        String year = scanner.nextLine();
        birthables.stream()
                .filter(b -> b.getBirthDate().endsWith(year))
                .forEach(b -> System.out.println(b.getBirthDate()));
    }
}
