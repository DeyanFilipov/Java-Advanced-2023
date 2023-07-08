package JavaOOP.Polymorphism.Lab.Animals_03;

public abstract class Animal {
    private String name;
    private String favouriteFood;

   protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s\n", this.name, this.favouriteFood);
    }
}
