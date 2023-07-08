package JavaOOP.Polymorphism.Lab.WildFarm_04;

public class Cat extends Felime {
    private final String breed;

    public Cat(String type, String name, double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.insert(sb.indexOf(",") + 1, " " + this.breed + ",");
        return sb.toString();
    }
}
