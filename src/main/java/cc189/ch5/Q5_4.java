package cc189.ch5;

/**
 * Created by xu_xt on 10/16/18.
 */
public class Q5_4 {
    // find the 0 at the least significant position followed by 1s
    // flip to 1
    // for 1s after that 0 put at the end
    public int getNextMin(int num) { // 101
        int temp = num;
        int countOfOnes = 0;
        int position = 0;
        while (temp > 0 && ((temp & 1) == 1 || countOfOnes == 0)) {
            if ((temp & 1) == 1) {
                countOfOnes++;
            }
            temp >>>= 1;
            position++;
        } // countOfOne = 1, position = 1
        if (countOfOnes == 0) {
            return Integer.MAX_VALUE;
        }
        // set all 0 from position and after
        num &= ~((1 << position) - 1); // 100
        // set position to 1 and tailing ones (countOfOnes - 1)at the end
        temp = 1 << position | (1 << countOfOnes - 1) - 1; // 10
        num |= temp; // 110
        return num;
    }

    // find the 1 at the least significant position followed by 0s
    // flip to 0
    // for 1s after that 0 put next to the flipped position
    public int getPrevMax(int num) { // 1001
        int temp = num;
        int countOfZero = 0;
        int position = 0;
        while (temp > 0 && ((temp & 1) == 0 || countOfZero == 0 )) {
            if ((temp & 1) == 0) {
                countOfZero ++;
            }
            temp >>>= 1;
            position++;
        } // countOfZero = 2, position = 3
        if (countOfZero == 0) {
            return Integer.MIN_VALUE;
        }
        // flip 1 at position to 0
        num &= ~(1 << position);
        // clear bits after position
        num &= ~((1 << position) - 1);
        // insert position - countOfZero + 1 ones after position
        int mask = (1 << position - countOfZero + 1) - 1;
        mask <<= countOfZero - 1;
        num |= mask;
        return num;
    }

    public static void main(String[] args) {
        Q5_4 q = new Q5_4();
        String[] tests = {"101", "11011001111100", "10011110000011"};
        for (String test : tests) {
            System.out.print(test);
            System.out.print("->");
            System.out.println(Integer.toBinaryString(q.getNextMin(Integer.parseInt(test, 2))));
        }
        for (String test : tests) {
            System.out.print(test);
            System.out.print("->");
            System.out.println(Integer.toBinaryString(q.getPrevMax(Integer.parseInt(test, 2))));
        }
    }

}
