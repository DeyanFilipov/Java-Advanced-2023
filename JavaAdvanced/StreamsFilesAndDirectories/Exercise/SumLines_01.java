package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\input.txt"));

        String line = bufferedReader.readLine();

        while (line != null) {
            long sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
