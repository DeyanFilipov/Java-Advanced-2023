package JavaAdvanced.Exam.automotiveRepairShop;

public class Vehicle {
    private String VIN;
    private int mileage;
    private String damage;

    public Vehicle(String VIN, int mileage, String damage) {
        this.VIN = VIN;
        this.mileage = mileage;
        this.damage = damage;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Damage: " + damage + ", Vehicle: " + VIN + " (" + mileage + " km)";
    }
}
