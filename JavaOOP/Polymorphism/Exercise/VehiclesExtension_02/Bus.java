package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

public class Bus extends Vehicle {
    public static final double CONSUMPTION_CHANGE = 1.4;

    public Bus(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + CONSUMPTION_CHANGE, tankCapacity);
    }

    public void driveEmpty(double distance) {
        super.setConsumption(getConsumption() - CONSUMPTION_CHANGE);
        drive(distance);
        super.setConsumption(getConsumption() + CONSUMPTION_CHANGE);
    }
}
