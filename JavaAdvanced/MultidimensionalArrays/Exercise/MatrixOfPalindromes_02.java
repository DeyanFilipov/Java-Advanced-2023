package JavaAdvanced.MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[inputData[0]][inputData[1]];

        char row = 'a';
        char col = 'b';

        for (int i = 0; i < matrix.length; i++) {
            col = row;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(Character.valueOf(row)) + String.valueOf(Character.valueOf(col)) + String.valueOf(Character.valueOf(row));
                col++;
            }
            row++;
        }
        for (String[] item : matrix) {
            for (String current : item) {
                System.out.printf("%s ", current);
            }
            System.out.println();
        }
    }
}
