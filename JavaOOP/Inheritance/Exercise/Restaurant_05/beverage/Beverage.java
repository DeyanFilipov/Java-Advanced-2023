package JavaOOP.Inheritance.Exercise.Restaurant_05.beverage;

import JavaOOP.Inheritance.Exercise.Restaurant_05.Product;

import java.math.BigDecimal;

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
