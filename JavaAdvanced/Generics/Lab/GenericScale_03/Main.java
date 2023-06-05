package JavaAdvanced.Generics.Lab.GenericScale_03;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> integerScale = new Scale<>(12, 2);

        System.out.println(integerScale.getHeavier());
    }
}
