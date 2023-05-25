package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders_08 {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\Files-and-Streams");

        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(folder);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.printf("%d folders\n", count);
    }
}
