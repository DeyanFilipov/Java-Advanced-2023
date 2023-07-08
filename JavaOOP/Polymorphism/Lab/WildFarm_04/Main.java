package JavaOOP.Polymorphism.Lab.WildFarm_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        List<Animal> animals = new ArrayList<>();

        while (!(input = scanner.nextLine()).equals("End")) {
            String[] animalInfo = input.split("\\s+");
            Animal animal = createAnimal(animalInfo);
            animals.add(animal);
            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food = createFood(foodInfo);
            animal.makeSound();
            animal.eat(food);
        }
        animals.forEach(System.out::println);
    }
    private static Animal createAnimal(String[] animalInfo) {
        String type = animalInfo[0];
        String name = animalInfo[1];
        double weight = Double.parseDouble(animalInfo[2]);
        String livingRegion = animalInfo[3];

        switch (type) {
            case "Mouse":
                return new Mouse(type, name, weight, livingRegion);
            case "Zebra":
                return new Zebra(type, name, weight, livingRegion);
            case "Cat":
                String catBreed = animalInfo[4];
                return new Cat(type, name, weight, livingRegion, catBreed);
            case "Tiger":
                return new Tiger(type, name, weight, livingRegion);
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
    private static Food createFood(String[] foodInfo) {
        int foodQuantity = Integer.parseInt(foodInfo[1]);
        return foodInfo[0].equals("Meat") ? new Meat(foodQuantity) : new Vegetable(foodQuantity);
    }
}
