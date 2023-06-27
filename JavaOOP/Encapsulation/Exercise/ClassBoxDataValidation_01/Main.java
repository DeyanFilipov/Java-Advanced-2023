package JavaOOP.Encapsulation.Exercise.ClassBoxDataValidation_01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, width, height);

        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println("Surface Area: " + decimalFormat.format(box.calculateSurfaceArea()));
        System.out.println("Lateral Surface Area: " + decimalFormat.format(box.calculateLateralSurfaceArea()));
        System.out.println("Volume: " + decimalFormat.format(box.calculateVolume()));
    }
}
