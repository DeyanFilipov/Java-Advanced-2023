package JavaOOP.ReflectionAndAnnotation.Exercise.BlackBoxInteger_02;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        String input = "";

        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!(input = scanner.nextLine()).equals("END")) {
            String methodName = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);

            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            int result = (int) innerValue.get(blackBoxInt);
            System.out.println(result);
        }

    }
}
