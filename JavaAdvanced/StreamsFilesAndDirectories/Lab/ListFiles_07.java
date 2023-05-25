package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\Files-and-Streams");

        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]\n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
