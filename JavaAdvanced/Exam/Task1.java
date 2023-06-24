package JavaAdvanced.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tools = parseInput(scanner.nextLine());
        List<Integer> substances = parseInput(scanner.nextLine());
        List<Integer> challenges = parseInput(scanner.nextLine());

        boolean foundOstracon = false;

        while (!challenges.isEmpty()) {
            if (substances.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                if (!tools.isEmpty()) {
                    System.out.println("Tools: " + joinElements(tools));
                }
                if (!substances.isEmpty()) {
                    System.out.println("Substances: " + joinElements(substances));
                }
                if (!challenges.isEmpty()) {
                    System.out.println("Challenges: " + joinElements(challenges));
                }
                return;
            }

            int tool = tools.get(0);
            int substance = substances.get(substances.size() - 1);
            int result = tool * substance;

            if (challenges.contains(result)) {
                tools.remove(0);
                substances.remove(substances.size() - 1);
                challenges.remove(challenges.indexOf(result));
            } else {
                tools.remove(0);
                tools.add(tool + 1);
                substances.set(substances.size() - 1, substance - 1);
                if (substance == 1) {
                    substances.remove(substances.size() - 1);
                }
            }

            if (challenges.isEmpty() && !substances.isEmpty()) {
                foundOstracon = true;
            }
        }

        if (foundOstracon) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        if (!substances.isEmpty()) {
            System.out.println("Substances: " + joinElements(substances));
        }
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> list = new ArrayList<>();
        String[] elements = input.split(" ");
        for (String element : elements) {
            list.add(Integer.parseInt(element));
        }
        return list;
    }

    private static String joinElements(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}