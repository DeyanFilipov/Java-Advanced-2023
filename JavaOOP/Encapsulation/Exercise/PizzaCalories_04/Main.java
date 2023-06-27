package JavaOOP.Encapsulation.Exercise.PizzaCalories_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pizzaInput = scanner.nextLine();
        String[] pizzaData = pizzaInput.split(" ");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String doughInput = scanner.nextLine();
        String[] doughData = doughInput.split(" ");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);

        for (int i = 0; i < numberOfToppings; i++) {
            String toppingInput = scanner.nextLine();
            if (toppingInput.equals("END")) {
                break;
            }
            String[] toppingData = toppingInput.split(" ");
            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);

            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
        }

        double overallCalories = pizza.getOverallCalories();
        System.out.printf("%s - %.2f%n", pizza.getName(), overallCalories);

    }
}
