package JavaOOP.Polymorphism.Lab.Animals_03;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + "DJAAF";
    }
}

