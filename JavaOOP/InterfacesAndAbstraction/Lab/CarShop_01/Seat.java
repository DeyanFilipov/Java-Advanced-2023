package JavaOOP.InterfacesAndAbstraction.Lab.CarShop_01;

public class Seat implements Car{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.getHorsePower();
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        String pattern = "This is %s produced in %s and have %d tires";
        return String.format(pattern,
                this.getModel(),
                this.countryProduced(),
                TIRES);
    }
}
