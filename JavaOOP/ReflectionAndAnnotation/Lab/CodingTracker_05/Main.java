package JavaOOP.ReflectionAndAnnotation.Lab.CodingTracker_05;

public class Main {
    @Author(name = "George")

    public static void main(String[] args) {
        Tracker.printMethodByAuthor(Tracker.class);
        Tracker.printMethodByAuthor(Reflection.class);
        Tracker.printMethodByAuthor(Main.class);
    }
}
