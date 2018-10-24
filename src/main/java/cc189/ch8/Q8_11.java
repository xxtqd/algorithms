package cc189.ch8;

/**
 * Created by xu_xt on 10/19/18.
 */
public class Q8_11 {
    public int coinCombination(int n) {
        int[] result = new int[n + 1];
        int[] coins = new int[4];
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;
        coins[3] = 25;
        result[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                result[i] += result[i - coin];
            }
        }
        return result[n];
    }
}