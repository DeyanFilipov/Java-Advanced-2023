package JavaOOP.Polymorphism.Lab.WildFarm_04;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private final String livingRegion;

    protected Mammal(String type, String name, Double weight, String livingRegion) {
        super(type, name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]"
                , this.getType(), this.getName(), df.format(this.getWeight()), this.livingRegion, super.getFoodEaten());
    }
}
