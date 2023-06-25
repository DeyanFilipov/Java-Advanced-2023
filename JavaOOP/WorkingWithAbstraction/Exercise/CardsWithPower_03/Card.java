package JavaOOP.WorkingWithAbstraction.Exercise.CardsWithPower_03;

enum Rank {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private final int power;

    Rank(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

enum Suit {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private final int power;

    Suit(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int calculatePower() {
        return rank.getPower() + suit.getPower();
    }

    @Override
    public String toString() {
        return "Card name: " + rank.name() + " of " + suit.name() + "; Card power: " + calculatePower();
    }
}