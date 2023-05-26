package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        PrintWriter print = new PrintWriter("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\merge.txt");
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt"));
        readFiles(reader, print);

        reader = new BufferedReader(new FileReader("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt"));
        readFiles(reader, print);

        reader.close();
        print.close();
    }
    private static void readFiles(BufferedReader reader, PrintWriter print) throws IOException {
        String line = reader.readLine();

        while (line != null) {
            print.println(line);
            line = reader.readLine();
        }
    }
}
