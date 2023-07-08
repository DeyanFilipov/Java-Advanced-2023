package JavaOOP.Polymorphism.Exercise.Vehicles_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2])));
        vehicles.add(new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2])));

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]) {
                case "Drive":
                    vehicles.stream().filter(v -> v.getClass().getSimpleName().equals(commands[1]))
                            .findFirst().ifPresent(v -> v.drive(Double.parseDouble(commands[2])));
                    break;
                case "Refuel":
                    vehicles.stream().filter(v -> v.getClass().getSimpleName().equals(commands[1]))
                            .findFirst().ifPresent(v -> v.refuel(Double.parseDouble(commands[2])));
                    break;
            }
        }
        vehicles.forEach(System.out::println);
    }
}
