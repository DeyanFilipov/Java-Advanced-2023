package JavaOOP.InterfacesAndAbstraction.Lab.SayHello_03;

public class Bulgarian implements Person {
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
