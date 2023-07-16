package JavaOOP.ReflectionAndAnnotation.Exercise.HarvestingFields_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = "";

		Field[] fields = RichSoilLand.class.getDeclaredFields();

		Consumer<Field> print = f -> System.out.printf("%s %s %s\n",
				Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName());

		while (!(input = scanner.nextLine()).equals("HARVEST")) {
			String modifier = input;

			switch (modifier) {
				case "protected":
				case "private":
				case "public":
					Arrays.stream(fields)
							.filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
							.forEach(print);
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(print);
					break;
			}

		}

	}
}
