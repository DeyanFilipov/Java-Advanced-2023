package JavaOOP.InterfacesAndAbstraction.Exercise.CollectionHierarchy_07;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        List<String> items = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        for (String item : items) {
            int index1 = addCollection.add(item);
            sb1.append(index1).append(" ");
            int index2 = addRemoveCollection.add(item);
            sb2.append(index2).append(" ");
            int index3 = myList.add(item);
            sb3.append(index3).append(" ");
        }

        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();

        int removeOperations = Integer.parseInt(scanner.nextLine());
        while (removeOperations-- > 0) {
            sb4.append(addRemoveCollection.remove()).append(" ");
            sb5.append(myList.remove()).append(" ");
        }
        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());
        System.out.println(sb4.toString().trim());
        System.out.println(sb5.toString().trim());
    }
}
