package JavaOOP.Polymorphism.Exercise.Vehicles_01;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + 1.6);
    }

    @Override
    void refuel(double fuel) {
        setFuelQuantity(getFuelQuantity() + 0.95 * fuel);
    }
}
