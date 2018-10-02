package cc189.ch1;

/**
 * Created by xu_xt on 10/1/18.
 */
// clarify: what is "true length" does it include leading and trailing spaces
// O(n) time O(1) space (in place)   n is the "true length" of original string
public class Q1_3 {
    public void URLify(char[] s, int len) {
        if (s == null || len == 0) {
            return;
        }
        int arrayLen = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                arrayLen += 3; // % 2 0
            } else {
                arrayLen += 1;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[arrayLen - 1] = '0';
                s[arrayLen - 2] = '2';
                s[arrayLen - 3] = '%';
                arrayLen -= 3;
            } else {
                s[arrayLen - 1] = s[i];
                arrayLen--;
            }
        }
    }

    public static void main(String[] args) {
        Q1_3 q = new Q1_3();
        char[] testCase = new char[1000000];
        String s = "Mr John Smith ";
        System.arraycopy(s.toCharArray(), 0, testCase, 0, s.length());
        q.URLify(testCase, 13);
        System.out.println(new String(testCase));
    }
}
