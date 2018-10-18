package cc189.ch5;

/**
 * Created by xu_xt on 10/15/18.
 */
public class Q5_1 {
    public long insertion(long n, long m, int i, int j) {
        int mask = (1 << (j - i + 1)) - 1; // 000011111  fixme: operation order */%+- >> >>> << & ^ |
        mask = mask << i; 	// 00001111100000
        mask = ~mask; // 11110000011111
        return n & mask | (m << i);
    }

    public static void main(String[] args) {
        Q5_1 q = new Q5_1();
        long n = Long.parseLong("10000000000",2);
        long m = Long.parseLong("10011", 2);
        System.out.println("N = " + Long.toBinaryString(n));
        System.out.println("M = " + Long.toBinaryString(m));
        System.out.println("Result = " + Long.toBinaryString(q.insertion(n, m, 2, 6)));
        n = Long.parseLong("11111010011",2);
        m = Long.parseLong("10011", 2);
        System.out.println("N = " + Long.toBinaryString(n));
        System.out.println("M = " + Long.toBinaryString(m));
        System.out.println("Result = " + Long.toBinaryString(q.insertion(n, m, 2, 6)));
    }
}

