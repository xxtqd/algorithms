package cc189.ch5;

/**
 * Created by xu_xt on 10/15/18.
 */
// count number of consecutive 1s by %2 and >>1
public class Q5_3 {
    public int longestSequence(int num) {
        if (~num == 0) {
            return Integer.SIZE; // fixme: edge case
        }
        int maxCount = 1, count  = 0, nextCount = 0;
        boolean flip = false;
        while (num > 0) {
            while (num >  0 && num % 2 == 1 || !flip) {
                if (flip) {
                    nextCount++;
                }
                if (num % 2 == 0) {
                    flip = true;
                }
                count++;
                num >>>= 1; // fixme: use logical right shift to fill the front with 0
            }
            flip = false;
            maxCount = Math.max(maxCount, count);
            count = nextCount;
            nextCount = 0;
        }
        return maxCount;
    }

    public int longestSequenceSolution(int n) {
        if (~n == 0) {
            return Integer.SIZE;
        }
        int maxLen = 1; // fixme: at least 1 bit
        int currentLen = 0;
        int prevLen = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                currentLen++;
            } else {
                prevLen = (n &2) == 0 ? 0 : currentLen;
                currentLen = 0;
            }
            maxLen = Math.max(maxLen, prevLen + currentLen + 1);
            n >>>= 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q5_3 q  = new Q5_3();
        System.out.println(Integer.toBinaryString(1775));
        System.out.println(q.longestSequence(1775));
        System.out.println(q.longestSequenceSolution(1775));
        System.out.println(q.longestSequence(Integer.parseInt("11111001111", 2)));
        System.out.println(q.longestSequenceSolution(Integer.parseInt("11111001111", 2)));
        System.out.println(q.longestSequence(Integer.parseInt("1111100111101", 2)));
        System.out.println(q.longestSequenceSolution(Integer.parseInt("1111100111101", 2)));
    }
}

