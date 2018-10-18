package cc189.ch5;

/**
 * Created by xu_xt on 10/16/18.
 */
public class Q5_7 {
    public int swapEvenOdd(int num) {
        return (num & 0xaaaaaaaa) >>> 1 | (num & 0x55555555) << 1;
    }
}