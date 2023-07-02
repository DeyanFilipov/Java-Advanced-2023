package JavaOOP.InterfacesAndAbstraction.Lab.BorderControl_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        List<Identifiable> list = new ArrayList<>();
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] info = input.split("\\s+");

            if (info.length == 3) {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                list.add(new Citizen(name, age, id));
            } else if (info.length == 2) {
                String model = info[0];
                String id = info[1];
                list.add(new Robot(model, id));
            }
        }
        String fakeIdPostfix = scanner.nextLine();
        list.stream().filter(e -> e.getId().endsWith(fakeIdPostfix)).forEach(e -> System.out.println(e.getId()));
    }
}
