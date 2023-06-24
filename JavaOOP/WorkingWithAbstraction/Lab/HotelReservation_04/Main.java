package JavaOOP.WorkingWithAbstraction.Lab.HotelReservation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pricePerDay = scanner.nextDouble();
        int numberOfDays = scanner.nextInt();
        String season = scanner.next();
        String discountType = scanner.next();

        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, Season.valueOf(season), Discount.valueOf(discountType));

        double totalPrice = calculator.calculateTotalPrice();
        System.out.printf("%.2f", totalPrice);

        scanner.close();
    }
}
