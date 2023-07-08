package JavaOOP.Polymorphism.Lab.WildFarm_04;

public class Mouse extends Mammal {

    public Mouse(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Mice are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }
}
