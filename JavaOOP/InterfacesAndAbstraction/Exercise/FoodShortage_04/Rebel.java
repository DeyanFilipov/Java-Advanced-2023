package JavaOOP.InterfacesAndAbstraction.Exercise.FoodShortage_04;

public class Rebel implements Person, Buyer{

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
