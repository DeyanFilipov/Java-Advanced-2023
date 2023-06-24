package JavaOOP.WorkingWithAbstraction.Lab.StudentSystem_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if ("Exit".equals(input[0])) {
                break;
            }
            studentSystem.parseCommand(input);
        }
    }
}
