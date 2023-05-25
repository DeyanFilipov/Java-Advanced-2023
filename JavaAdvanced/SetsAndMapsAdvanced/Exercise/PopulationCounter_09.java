package JavaAdvanced.SetsAndMapsAdvanced.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class PopulationCounter_09 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        String line;
        while (!(line = reader.readLine()).equals("report")) {
            String[] tokens = line.split("\\|");

            String town = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
            }
            if (!countries.get(country).containsKey(town)) {
                countries.get(country).put(town, population);
            } else {
                countries.get(country).put(town, countries.get(country).get(town) + population);
            }
        }
        countries.entrySet().stream().sorted((c1, c2) -> Long.compare(c2.getValue().values().stream().mapToLong(Long::longValue).sum(),
                        c1.getValue().values().stream().mapToLong(Long::longValue).sum())).forEach(c -> {System.out.printf("%s (total population: %d)%n",
                c.getKey(), c.getValue().values().stream().mapToLong(Long::longValue).sum());
                            c.getValue().entrySet().stream().sorted((t1, t2) -> Long.compare(t2.getValue(), t1.getValue())).forEach(t -> System.out.printf("=>%s: %d%n", t.getKey(), t.getValue()));
                        });
    }
}
