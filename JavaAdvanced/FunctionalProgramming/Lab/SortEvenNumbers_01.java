package JavaAdvanced.FunctionalProgramming.Lab;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(", ")).map(Integer::parseInt).filter(n -> n % 2 == 0).collect(Collectors.toList());

        getPrintList(numbers);

        Collections.sort(numbers);

        getPrintList(numbers);
    }
    private static void getPrintList(List<Integer> list) {
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
