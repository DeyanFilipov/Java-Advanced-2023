package JavaOOP.DesignPatterns.Lab.Facade;

public class Car {
    private String type;
    private String color;
    private int numberOfDoors;
    private String city;
    private String address;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("CarType: %s, " +
                "Color: %s, Number of doors: %d, " +
                "Manufactured in %s, at address: %s", this.type, this.color, this.numberOfDoors, this.getCity(), this.getAddress());
    }
}
