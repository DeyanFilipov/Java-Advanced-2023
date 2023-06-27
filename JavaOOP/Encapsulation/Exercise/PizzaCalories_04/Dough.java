package JavaOOP.Encapsulation.Exercise.PizzaCalories_04;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double flourModifier = 1.0;
        double bakingModifier = 1.0;

        if (flourType.equals("White")) {
            flourModifier = 1.5;
        }

        if (bakingTechnique.equals("Crispy")) {
            bakingModifier = 0.9;
        } else if (bakingTechnique.equals("Chewy")) {
            bakingModifier = 1.1;
        }

        return (2 * weight) * flourModifier * bakingModifier;
    }
}
