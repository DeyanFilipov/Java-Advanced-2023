package JavaOOP.ReflectionAndAnnotation.Lab.Reflection_01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;
        Class[] interfaces = clazz.getInterfaces();

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor<Reflection> constructor = clazz.getDeclaredConstructor();
        Reflection reflection = constructor.newInstance();
        System.out.println(reflection.toString());

    }
}
