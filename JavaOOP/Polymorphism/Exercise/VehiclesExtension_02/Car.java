package JavaOOP.Polymorphism.Exercise.VehiclesExtension_02;

public class Car extends Vehicle {
    public static final double CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + CONSUMPTION_INCREASE, tankCapacity);
    }
}
