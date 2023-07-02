package JavaOOP.Encapsulation.Exercise.ShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokensPeople = scan.nextLine().split(";");
        List<Person> people = new ArrayList<>();
        for (String p : tokensPeople) {
            String name = p.split("=")[0];
            double money = Double.parseDouble(p.split("=")[1]);
            try {
                people.add(new Person(name, money));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] tokensProducts = scan.nextLine().split(";");
        List<Product> products = new ArrayList<>();
        for (String pr : tokensProducts) {
            String name = pr.split("=")[0];
            double cost = Double.parseDouble(pr.split("=")[1]);
            try {
                products.add(new Product(name, cost));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String currPerson = input.split(" ")[0];
            String productToBuy = input.split(" ")[1];
            Person person = people.stream().filter(p -> p.getName().equals(currPerson)).findFirst().get();
            Product product = products.stream().filter(p -> p.getName().equals(productToBuy)).findFirst().get();
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s\n", currPerson, productToBuy);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        people.forEach(System.out::println);
    }
}
