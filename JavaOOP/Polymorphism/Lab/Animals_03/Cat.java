package JavaOOP.Polymorphism.Lab.Animals_03;

public class Cat extends Animal {

    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + "MEEOW";
    }
}
