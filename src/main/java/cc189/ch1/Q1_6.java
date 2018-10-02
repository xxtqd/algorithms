package cc189.ch1;

/**
 * Created by xu_xt on 10/1/18.
 */
// O(n) time O(1) space
// iterate through array, increase counter if current character is the same as previous character
public class Q1_6 {
    public String compressString(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len <= 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int index  = 0;
        while (index < len) {
            char c = s.charAt(index);
            int count = 0;
            while (index < len && s.charAt(index) == c) {
                count++;
                index++;
            }
            sb.append(c);
            sb.append(count);
        }
        return sb.length() < len ? sb.toString() : s;
    }

    public static void main(String[] args) {
        Q1_6 q = new Q1_6();
        String[] testCases = new String[]{"aaaa", "", null, "abcde", "aaaabbbcd"};
        for (String str : testCases) {
            System.out.println(str + ": " + q.compressString(str));
        }
    }

}
