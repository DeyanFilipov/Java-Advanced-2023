package JavaOOP.InterfacesAndAbstraction.Lab.SayHelloExtended_04;

public class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
