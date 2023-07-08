package JavaOOP.Polymorphism.Exercise.Vehicles_01;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    void drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");

        if (this.fuelQuantity >= distance * this.litersPerKm) {
            this.fuelQuantity -= distance * this.litersPerKm;
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(),
                    df.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
