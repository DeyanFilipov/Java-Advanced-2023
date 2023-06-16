package JavaAdvanced.BasicAlgorithms.Lab.SumofCoins_03;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coin {
    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Arrays.sort(coins);
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();

        int currentSum = 0;
        int currentIndex = coins.length - 1;

        while (currentSum != targetSum && currentIndex >= 0) {
            int coinValue = coins[currentIndex];
            int remainingSum = targetSum - currentSum;
            int count = remainingSum / coinValue;

            if (count > 0) {
                usedCoins.put(coinValue, count);
                currentSum += coinValue * count;
            }
            currentIndex--;
        }
        if (currentSum != targetSum) {
            return null;
        }
        return usedCoins;
    }
}
