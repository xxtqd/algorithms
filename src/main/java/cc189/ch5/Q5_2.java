package cc189.ch5;

/**
 * Created by xu_xt on 10/16/18.
 */
// fixme: revisit
// representation of decimal: 0.1011(2) = 1 * 1/2 + 0 * 1/(2^2) + 1 * 1/ (2^3) + 1 * 1/(2^4)
public class Q5_2 {
    public String toBinaryString(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        double factor = 0.5;
        while (num != 0) {
            if (sb.length() > 32) {
                return "ERROR";
            }
            if (num >= factor) {
                num -= factor;
                sb.append("1");
            } else {
                sb.append("0");
            }
            factor /= 2;
        }
        return sb.toString();
    }
}
