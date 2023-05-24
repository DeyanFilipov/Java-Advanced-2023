package JavaAdvanced.SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> usernameSet = new LinkedHashSet<>();

        int rotation = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rotation; i++) {
            String input = scanner.nextLine();
            usernameSet.add(input);
        }
        usernameSet.forEach(System.out::println);
    }
}
