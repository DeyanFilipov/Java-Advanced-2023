package JavaOOP.WorkingWithAbstraction.Lab.HotelReservation_04;

enum Season {
    Spring,
    Summer,
    Autumn,
    Winter
}
enum Discount {
    VIP,
    SecondVisit,
    None
}
public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }
    public double calculateTotalPrice() {
        double seasonMultiplier = 1.0;
        switch (season) {
            case Spring:
                seasonMultiplier = 2.0;
                break;
            case Summer:
                seasonMultiplier = 4.0;
                break;
            case Autumn:
                seasonMultiplier = 1.0;
                break;
            case Winter:
                seasonMultiplier = 3.0;
                break;
        }
        double totalPrice = pricePerDay * numberOfDays * seasonMultiplier;
        double discountPercentage = 0.0;
        switch (discountType) {
            case VIP:
                discountPercentage = 0.2;
                break;
            case SecondVisit:
                discountPercentage = 0.1;
                break;
            case None:
                discountPercentage = 0.0;
                break;
        }
        double discountedPrice = totalPrice - (totalPrice * discountPercentage);
        return Math.round(discountedPrice* 100.0) / 100.0;
    }
}
