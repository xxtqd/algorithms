package cc189.ch5;

/**
 * Created by xu_xt on 10/16/18.
 */
// XOR the two numbers to see number of bits that are different
public class Q5_6 {
    public int flipCount(int a, int b) {
        int count = 0;
        for (int c = a^b; c != 0; c >>= 1) {
            if((c & 1) == 1)  {
                count++;
            }
        }
        return count;
    }

    public int flipCount2(int a, int b) {
        int count = 0;
        for (int c=a^b; c != 0; c&=c-1) {  // c&=c-1 will flip to least significant bit of 1 to 0
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Q5_6 q = new Q5_6();
        String[] tests1 = {"11101", "11011001111100", "10011110000011"};
        String[] tests2 = {"1111", "11011001111100", "10011110000011"};
        for (int i = 0; i < tests1.length; i++) {
            System.out.print("(" + tests1[i] + ", " + tests2[i] + ")");
            System.out.print("->");
            System.out.println(q.flipCount(Integer.parseInt(tests1[i], 2), Integer.parseInt(tests2[i], 2)));
            System.out.println(q.flipCount2(Integer.parseInt(tests1[i], 2), Integer.parseInt(tests2[i], 2)));
        }
    }
}
