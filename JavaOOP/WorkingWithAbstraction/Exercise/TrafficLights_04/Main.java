package JavaOOP.WorkingWithAbstraction.Exercise.TrafficLights_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split(" ");

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < signals.length; j++) {
                String currentSignal = signals[j];

                String updatedSignal = updateTrafficLight(currentSignal);

                System.out.print(updatedSignal + " ");

                signals[j] = updatedSignal;
            }
            System.out.println();
        }
    }
    public static String updateTrafficLight(String signal) {
        switch (signal) {
            case "RED":
                return "GREEN";
            case "GREEN":
                return "YELLOW";
            case "YELLOW":
                return "RED";
            default:
                return "unknown";
        }
    }
}
