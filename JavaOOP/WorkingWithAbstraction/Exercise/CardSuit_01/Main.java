package JavaOOP.WorkingWithAbstraction.Exercise.CardSuit_01;

public class Main {
    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        for (Suit suit : Suit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", suit.ordinal(), suit.name());

        }
    }
}
