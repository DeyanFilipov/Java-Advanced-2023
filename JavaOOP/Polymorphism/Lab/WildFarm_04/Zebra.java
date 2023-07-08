package JavaOOP.Polymorphism.Lab.WildFarm_04;

public class Zebra extends Mammal {

    public Zebra(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Zebras are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }
}
