package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double consumption;
    private final double tankCapacity;

    public Vehicle(double fuelQuantity, double consumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double litersPerKm) {
        this.consumption = consumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");
        double neededLiters = distance * this.consumption;
        if (this.fuelQuantity >= neededLiters) {
            setFuelQuantity(getFuelQuantity() - neededLiters);
            System.out.printf("%s travelled %s km\n", getClass().getSimpleName(),
                    df.format(distance));
        } else {
            System.out.printf("%s needs refueling\n", getClass().getSimpleName());
        }
    }

    void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQuantity() + fuel > tankCapacity) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + fuel);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
