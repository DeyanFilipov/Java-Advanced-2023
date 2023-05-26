package JavaAdvanced.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt"));
        PrintWriter print = new PrintWriter("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\results.txt");
        Map<String, Integer> occurrencesMap = new LinkedHashMap<>();
        String[] words = reader.readLine().split("\\s+");

        for (String word : words) {
            occurrencesMap.putIfAbsent(word, 0);
        }
        reader.close();

        reader = new BufferedReader(new FileReader("C:\\Users\\didko\\Desktop\\Java-Advanced-2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt"));
        String lineToCheck = reader.readLine();
        Pattern patter = Pattern.compile("\\w+");
        Matcher matcher = patter.matcher(lineToCheck);

        while (matcher.find()) {
            String word = matcher.group(0);
            if (occurrencesMap.containsKey(word)) {
                occurrencesMap.put(word, occurrencesMap.get(word) + 1);
            }
        }
        occurrencesMap = occurrencesMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        occurrencesMap.forEach((word, count) -> print.println(String.format("%s - %d", word, count)));

        reader.close();
        print.close();
    }
}
