package JavaOOP.WorkingWithAbstraction.Exercise.CardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card[] deck = new Card[52];
        int index = 0;
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit);
                deck[index] = card;
                index++;
            }
        }
        Scanner scanner = new Scanner(System.in);
        String rankInput = scanner.nextLine();
        String suitInput = scanner.nextLine();

        try {
            Rank rank = Rank.valueOf(rankInput.toUpperCase());
            Suit suit = Suit.valueOf(suitInput.toUpperCase());
            Card card = new Card(rank, suit);
            System.out.println(card);
        } catch (IllegalStateException e) {
            System.out.println("Invalid input.");
        }
    }
}
