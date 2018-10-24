package cc189.ch8;

/**
 * Created by xu_xt on 10/18/18.
 */
public class Q8_5 {
    public long multiply(int a, int b) {
        // fixme 让比较小的数当乘数
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a == 0) {
            return 0L;
        }
        long result = 0;
        if (a % 2 ==1) {
            result += b;
        }
        long half = multiply(a >> 1, b);
        return result + half + half;
    }

    public static void main(String[] args) {
        Q8_5 q = new Q8_5();
        System.out.println(q.multiply(101, 9345));
    }
}