package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputLineNumbers.txt"));
        PrintWriter print = new PrintWriter("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\output2.txt");

        int lineCount = 1;
        String line = reader.readLine();
        while (line != null) {
            line = String.format("%d. %s", lineCount, line);
            print.println(line);

            line = reader.readLine();
            lineCount++;
        }
        reader.close();
        print.close();
    }
}
