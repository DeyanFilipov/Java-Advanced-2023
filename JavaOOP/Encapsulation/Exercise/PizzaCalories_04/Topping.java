package JavaOOP.Encapsulation.Exercise.PizzaCalories_04;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingModifier = 1.0;

        if (toppingType.equals("Meat")) {
            toppingModifier = 1.2;
        } else if (toppingType.equals("Veggies")) {
            toppingModifier = 0.8;
        } else if (toppingType.equals("Cheese")) {
            toppingModifier = 1.1;
        } else if (toppingType.equals("Sauce")) {
            toppingModifier = 0.9;
        }

        return (2 * weight) * toppingModifier;
    }
}
