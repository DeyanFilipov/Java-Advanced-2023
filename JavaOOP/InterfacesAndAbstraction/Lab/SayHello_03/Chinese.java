package JavaOOP.InterfacesAndAbstraction.Lab.SayHello_03;

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
