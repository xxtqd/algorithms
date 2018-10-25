package cc189.ch8;

import java.util.Arrays;

/**
 * Created by xu_xt on 10/20/18.
 */
public class Q8_14 {

    public int countEval(String exp, boolean result) {
        int n = exp.length();
        int[][] countTrue = new int[n][n];
        int[][] countFalse = new int[n][n];
        for (int[] t : countTrue) {
            Arrays.fill(t, -1);
        }
        for (int[] f : countFalse) {
            Arrays.fill(f, -1);
        }
        for (int i = 0; i < n; i+= 2) {
            if(exp.charAt(i) == '0') {
                countFalse[i][i] = 1;
            } else if (exp.charAt(i) == '1') {
                countTrue[i][i] = 1;
            }
        }
        countEval(exp, 0, n - 1, result, countTrue, countFalse);
        if (result) {
            return countTrue[0][n - 1];
        }
        return countFalse[0][n - 1];
    }

    private int countEval(String exp, int start, int end, boolean result, int[][] countTrue, int[][] countFalse) {
        if (start > end) {
            return 0;
        }
        if (result && countTrue[start][end] >= 0) {
            return countTrue[start][end];
        }
        if (!result && countFalse[start][end] >= 0) {
            return countFalse[start][end];
        }
        int t = 0, f = 0;
        for (int i = start + 1; i <= end; i += 2) {
            char c = exp.charAt(i);
            if (c == '&') {
                if (result) {
                    t += countEval(exp, start, i - 1, true, countTrue, countFalse) * countEval(exp, i + 1, end, true, countTrue, countFalse);
                } else {
                    int count1 = countEval(exp, start, i - 1, false, countTrue, countFalse);
                    int count2 = countEval(exp, i + 1, end, false, countTrue, countFalse);
                    f += countEval(exp, start, i - 1, true, countTrue, countFalse) * count2 + countEval(exp, i + 1, end, true, countTrue, countFalse) * count1 + count1 * count2;
                }
            } else if (c == '|') {
                if (result) {
                    int count1 = countEval(exp, start, i - 1, true, countTrue, countFalse);
                    int count2 = countEval(exp, i + 1, end, true, countTrue, countFalse);
                    t += countEval(exp, start, i - 1, false, countTrue, countFalse) * count2 + countEval(exp, i + 1, end, false, countTrue, countFalse) * count1 + count1 * count2;
                } else {
                    f += countEval(exp, start, i - 1, false, countTrue, countFalse) * countEval(exp, i + 1, end, false, countTrue, countFalse);
                }
            } else if (c == '^') {
                if (result) {
                    t += (countEval(exp, start, i - 1, true, countTrue, countFalse) * countEval(exp, i + 1, end, false, countTrue, countFalse)
                            + countEval(exp, start, i - 1, false, countTrue, countFalse) * countEval(exp, i + 1, end, true, countTrue, countFalse));
                } else {
                    f += (countEval(exp, start, i - 1, true, countTrue, countFalse) * countEval(exp, i + 1, end, true, countTrue, countFalse)
                            + countEval(exp, start, i - 1, false, countTrue, countFalse) * countEval(exp, i + 1, end, false, countTrue, countFalse));
                }
            }
        }
        if (result) {
            countTrue[start][end] = t;
            return t;
        } else {
            countFalse[start][end] = f;
            return f;
        }
    }

    public static void main(String[] args) {
        Q8_14 q = new Q8_14();
        System.out.print(q.countEval("0&0&0&1^1|0", true));
    }
}

