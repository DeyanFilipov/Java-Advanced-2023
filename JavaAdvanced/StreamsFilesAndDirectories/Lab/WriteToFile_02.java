package JavaAdvanced.StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {


        String pathRead = "C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\input.txt";
        String pathWrite = "C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\02.WriteToFileOutput.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int currentByte = inputStream.read();
        while (currentByte >= 0) {
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '!' && currentSymbol != '?') {
                outputStream.write(currentSymbol);
            }

            currentByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();
    }
}
