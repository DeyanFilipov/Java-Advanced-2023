package JavaOOP.Polymorphism.Exercise.Vehicles_01;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + .9);
    }
}
