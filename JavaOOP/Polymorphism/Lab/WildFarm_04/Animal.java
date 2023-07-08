package JavaOOP.Polymorphism.Lab.WildFarm_04;

public abstract class Animal {
    private String type;
    private String name;
    private Double weight;
    private Integer foodEaten;

    protected Animal(String type, String name, double weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.foodEaten = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();

    protected void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }
}
