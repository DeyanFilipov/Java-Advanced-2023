package JavaOOP.DesignPatterns.Lab.Facade;

public class CarAddressBuilder extends CarBuilderFacade {

    public CarAddressBuilder(Car car) {
        this.car = car;
    }

    public CarAddressBuilder inCity(String city) {
        car.setCity(city);
        return this;
    }

    public CarAddressBuilder atAddress(String address) {
        car.setAddress(address);
        return this;
    }
}
