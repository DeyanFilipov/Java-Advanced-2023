package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\06.SortLinesOutput.txt");

        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite, allLines);
    }
}
