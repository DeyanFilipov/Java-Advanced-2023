package JavaAdvanced.Generics.Exercise.GenericCountMethodString_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(scanner.nextLine());
            boxes.add(box);
        }
        Box<String> boxToCompare = new Box<>(scanner.nextLine());
        int result = countGreaterResults(boxes, boxToCompare);
        System.out.println(result);
    }
    private static <T extends Comparable<T>> int countGreaterResults(List<T> data, T element) {
        int count = 0;
        for (T elements : data) {
            int result = elements.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }
    private static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);
        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }
}