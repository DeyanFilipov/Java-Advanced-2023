package JavaOOP.Polymorphism.Lab.WildFarm_04;

public class Tiger extends Felime{

    public Tiger(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (!(food instanceof Meat)) {
            System.out.println("Tigers are not eating that type of food!");
        } else {
            super.eat(food);
        }
    }
}
