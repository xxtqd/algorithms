package cc189.ch8;

import java.util.Arrays;

/**
 * Created by xu_xt on 10/17/18.
 */
// one can reach the nth step from (n - 1)th, (n - 2)th or (n - 3)th
// step[i] = step[i - 1] + step[i - 2] + step[i - 3]
public class Q8_1 {
    // O(n) time O(n) space
    public int tripleSteps(int n) {
        int[] step = new int[n + 1];
        step[0] = 1;
        for (int i = 1; i <= n; i++) {
            step[i] += step[i - 1];
            if (i >= 2) {
                step[i] += step[i - 2];
                if (i >= 3) {
                    step[i] += step[i - 3];
                }
            }
        }
        return step[n];
    }
        // O(1) space
    public int tripleStepsImprove(int n) {
        int step1 = 0, step2 = 0, step3 = 1;
        int step = 1;
        for (int i = 1; i <=n; i++) {
            step = step1 + step2 + step3;
            step1 = step2;
            step2 = step3;
            step3 = step;
        }
        return step;
    }

    public int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = countWays(n -1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Q8_1 q = new Q8_1();
        int n  = 30;
        System.out.println(q.countWays(n));
        System.out.println(q.tripleSteps(n));
        System.out.println(q.tripleStepsImprove(n));

    }
}
