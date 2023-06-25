package JavaOOP.WorkingWithAbstraction.Exercise.CardRank_02;

public class Main {
    public enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (Rank rank : Rank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", rank.ordinal(), rank.name());

        }
    }
}
