package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        vehicles.put("Car", create(carInfo));
        vehicles.put("Truck", create(truckInfo));
        // Bus bus = createBus(busInfo);
        vehicles.put("Bus", create(busInfo));

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");
            String currentVehicle = commands[1];

            switch (commands[0]) {
                case "Drive":
                    vehicles.get(currentVehicle).drive(Double.parseDouble(commands[2]));
                    break;
                case "Refuel":
                    vehicles.get(currentVehicle).refuel(Double.parseDouble(commands[2]));
                    break;
                case "DriveEmpty":
                    Bus bus = (Bus) vehicles.get("Bus");
                    bus.driveEmpty(Double.parseDouble(commands[2]));
                    vehicles.put("Bus", bus);
                    break;
            }
        }
        vehicles.forEach((key, value) -> System.out.println(value.toString()));
    }

    public static Vehicle create(String[] info) {
        String vehicleType = info[0];
        double fuelQty = Double.parseDouble(info[1]);
        double litersPerKm = Double.parseDouble(info[2]);
        double tankCapacity = Double.parseDouble(info[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQty, litersPerKm, tankCapacity);
            case "Truck":
                return new Truck(fuelQty, litersPerKm, tankCapacity);
            case "Bus":
                return new Bus(fuelQty, litersPerKm, tankCapacity);
            default:
                throw new IllegalStateException("Unknown Vehicle type for " + vehicleType);
        }
    }

    public static Bus createBus(String[] info) {
        double fuelQty = Double.parseDouble(info[1]);
        double litersPerKm = Double.parseDouble(info[2]);
        double tankCapacity = Double.parseDouble(info[3]);
        return new Bus(fuelQty, litersPerKm, tankCapacity);
    }
}
