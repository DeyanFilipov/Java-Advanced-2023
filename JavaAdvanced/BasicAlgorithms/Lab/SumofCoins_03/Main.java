package JavaAdvanced.BasicAlgorithms.Lab.SumofCoins_03;

import java.util.*;

import static JavaAdvanced.BasicAlgorithms.Lab.SumofCoins_03.Coin.chooseCoins;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        if (usedCoins == null) {
            System.out.println("Error");
        } else {
            int totalCoins = 0;
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                int coinValue = usedCoin.getKey();
                int coinCount = usedCoin.getValue();
                totalCoins += coinCount;
            }

            System.out.println("Number of coins to take: " + totalCoins);
            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
                int coinValue = usedCoin.getKey();
                int coinCount = usedCoin.getValue();
                System.out.println(coinCount + " coin(s) with value " + coinValue);
            }
        }
    }
}