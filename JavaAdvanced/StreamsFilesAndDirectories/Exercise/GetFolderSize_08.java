package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFolderSize_08 {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        long size = Files.walk(folder).filter(p -> p.toFile().isFile()).mapToLong(p -> p.toFile().length()).sum();
        System.out.printf("Folder size: %d", size);

    }
}
