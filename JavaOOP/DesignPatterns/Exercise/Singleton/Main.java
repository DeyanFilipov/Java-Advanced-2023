package JavaOOP.DesignPatterns.Exercise.Singleton;

public class Main {
    public static void main(String[] args) {

        Hashcode instance = Hashcode.getInstance("Deyan");
        Hashcode instance1 = Hashcode.getInstance("Filipov");

        System.out.println(instance.getPoint().hashCode());
        System.out.println(instance1.getPoint().hashCode());
        System.out.println("Filipov".hashCode());
    }
}
