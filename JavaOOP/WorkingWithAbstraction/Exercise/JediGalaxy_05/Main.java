package JavaOOP.WorkingWithAbstraction.Exercise.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] player1 = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] player2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xE = player2[0];
            int yE = player2[1];

            while (xE >= 0 && yE >= 0) {
                if (xE < matrix.length && yE < matrix[0].length) {
                    matrix[xE][yE] = 0;
                }
                xE--;
                yE--;
            }
            int xI = player1[0];
            int yI = player1[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if (xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                    sum += matrix[xI][yI];
                }
                yI++;
                xI--;
            }
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
