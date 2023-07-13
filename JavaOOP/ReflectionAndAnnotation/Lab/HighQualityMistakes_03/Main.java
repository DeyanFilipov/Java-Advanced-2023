package JavaOOP.ReflectionAndAnnotation.Lab.HighQualityMistakes_03;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Reflection.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.stream(declaredFields)
                .sorted(Comparator.comparing(Field::getName))
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.printf("%s must be private!\n", f.getName()));

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().startsWith("get"))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f -> System.out.printf("%s have to be public!\n", f.getName()));

        Arrays.stream(declaredMethods)
                .filter(m -> m.getName().startsWith("set"))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(f -> System.out.printf("%s have to be private!\n", f.getName()));

    }
}
