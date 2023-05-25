package JavaAdvanced.StreamsFilesAndDirectories.Lab;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\resources\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ",
                        Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
