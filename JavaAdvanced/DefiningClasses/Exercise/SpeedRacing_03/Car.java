package JavaAdvanced.DefiningClasses.Exercise.SpeedRacing_03;

public class Car {
    private String model;
    private double fuel;
    private double fuelCosPerKm;
    private int distanceTraveled;

    public Car(String model, double fuel, double fuelCosPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCosPerKm = fuelCosPerKm;
        this.distanceTraveled = 0;
    }
    public void drive(int km) {
        if (this.fuelCosPerKm * km > this.fuel) {
            System.out.println("Insufficient fuel for the drive");
            return;
        }
        double calculation = km * this.fuelCosPerKm;
        calcFuel(calculation);
        addKilometers(km);
    }
    public void calcFuel(double calculation) {
        this.fuel -= calculation;
    }
    public void addKilometers(int km) {
        this.distanceTraveled += km;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getFuel() {
        return fuel;
    }
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    public double getFuelCosPerKm() {
        return fuelCosPerKm;
    }
    public void setFuelCosPerKm(double fuelCosPerKm) {
        this.fuelCosPerKm = fuelCosPerKm;
    }
    public int getDistanceTraveled() {
        return distanceTraveled;
    }
    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
