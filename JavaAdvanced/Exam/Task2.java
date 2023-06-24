package JavaAdvanced.Exam;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Parse the input
        String[] dimensions = scanner.nextLine().split(",");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        char[][] cupboard = new char[N][M];
        int mouseRow = 0;
        int mouseCol = 0;
        int remainingCheeses = 0;

        for (int i = 0; i < N; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                cupboard[i][j] = row.charAt(j);
                if (cupboard[i][j] == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                } else if (cupboard[i][j] == 'C') {
                    remainingCheeses++;
                }
            }
        }

        // Step 2: Process the commands
        String command = scanner.nextLine();

        while (!command.equals("danger")) {
            int newMouseRow = mouseRow;
            int newMouseCol = mouseCol;

            if (command.equals("up")) {
                newMouseRow--;
            } else if (command.equals("down")) {
                newMouseRow++;
            } else if (command.equals("left")) {
                newMouseCol--;
            } else if (command.equals("right")) {
                newMouseCol++;
            }

            // Check if the new position is within the cupboard
            if (newMouseRow < 0 || newMouseRow >= N || newMouseCol < 0 || newMouseCol >= M) {
                System.out.println("No more cheese for tonight!");
                cupboard[mouseRow][mouseCol] = 'M';
                printCupboard(cupboard);
                return;
            }

            // Check the new position in the cupboard
            char newPosition = cupboard[newMouseRow][newMouseCol];

            if (newPosition == '*') {
                // Empty position, update the mouse's position
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                mouseRow = newMouseRow;
                mouseCol = newMouseCol;
            } else if (newPosition == 'C') {
                // Cheese found, eat it and update the mouse's position
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                mouseRow = newMouseRow;
                mouseCol = newMouseCol;
                remainingCheeses--;

                if (remainingCheeses == 0) {
                    // All cheese eaten
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    printCupboard(cupboard);
                    return;
                }
            } else if (newPosition == 'T') {
                // Mouse trapped
                cupboard[mouseRow][mouseCol] = '*';
                cupboard[newMouseRow][newMouseCol] = 'M';
                System.out.println("Mouse is trapped!");
                printCupboard(cupboard);
                return;
            }

            command = scanner.nextLine();
        }

        // "danger" command received before eating all the cheese
        System.out.println("Mouse will come back later!");
        cupboard[mouseRow][mouseCol] = 'M';
        printCupboard(cupboard);
    }

    public static void printCupboard(char[][] cupboard) {
        for (char[] row : cupboard) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}