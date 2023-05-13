package JavaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!fileName.equals("print")) {
            if (fileName.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.println("Canceled " + printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(fileName);
            }
            fileName = scanner.nextLine();

        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }

    }
}