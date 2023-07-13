package JavaOOP.ReflectionAndAnnotation.Lab.CodingTracker_05;

import java.util.Arrays;
import java.util.Comparator;

public class Tracker {
    @Author(name = "Peter")
    public static void printMethodByAuthor(Class<?> clazz) {
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getDeclaredAnnotation(Author.class) != null)
                .sorted(Comparator.comparing(m -> m.getDeclaredAnnotation(Author.class).name()))
                .forEach(m ->
                        System.out.println(m.getAnnotation(Author.class).name() + ": " +
                                m.getName()));
    }
}
