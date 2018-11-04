package palindrome;

/**
 * Created by xu_xt on 11/3/18.
 */
public class LongestPalindrome {
    public String manacher(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String str = generateString(s);
        int n = str.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        int maxLen = 0;
        int startIndex = -1;
        for (int i = 1; i < n; i++) {
            if (right > i) {
                int mirror = center - (i - center);
                p[i] = Math.min(right - i, p[mirror]);
            } else {
                p[i] = 0;
            }
            // #c#c#c#
            // #a#a#a#b#a#a#a#a#
            // 01232107012321210
            // aaabaaaa
            while (i + 1 + p[i] < n && i - 1 - p[i] >= 0
                    && str.charAt(i + 1 + p[i]) == str.charAt(i - 1 - p[i])) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (maxLen < p[i]) {
                maxLen = p[i];
                startIndex = (i - maxLen) / 2;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    private String generateString (String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        lp.manacher("aaabaaaa");
    }
}
