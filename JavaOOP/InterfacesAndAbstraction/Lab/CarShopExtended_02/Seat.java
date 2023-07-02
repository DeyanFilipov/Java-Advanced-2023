package JavaOOP.InterfacesAndAbstraction.Lab.CarShopExtended_02;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        String pattern = "Leon sells for %f";
        return String.format(pattern, this.getPrice());
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
