package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

public class Truck extends Vehicle {
    public static final double CONSUMPTION_CHANGE = 1.6;
    public static final double REFUELLING_CAPACITY = 0.95;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + CONSUMPTION_CHANGE, tankCapacity);
    }

    @Override
    void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (getFuelQuantity() + fuel <= super.getTankCapacity()) {
            super.setFuelQuantity(getFuelQuantity() + REFUELLING_CAPACITY * fuel);
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }
}
