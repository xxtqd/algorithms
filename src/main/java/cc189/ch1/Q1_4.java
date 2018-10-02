package cc189.ch1;

/**
 * Created by xu_xt on 10/1/18.
 */
// count character ignoring cases, there should at most one character that has odd number of count
// clarify if the string is formed by letters only?
// O(n) time, O(n) space
public class Q1_4 {
    public boolean isPalindromePermutation(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String sLow = s.toLowerCase(); // what about characters that are not letters??
        int[] count = new int[26];
        for (int i = 0; i < sLow.length(); i++) {
            char c = sLow.charAt(i);
            if (Character.isLetter(c)) { // mistake made: need to check character is letter
                count[c - 'a']++;
            }
        }
        boolean odd = false;
        for (int c : count) {
            if (c % 2 != 0) {
                if (odd) {
                    return false;
                } else {
                    odd = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_4 q = new Q1_4();
        String[] testCases = {"Tact Coa"};
        for (String s : testCases) {
            System.out.println(s + ": " + q.isPalindromePermutation(s));
        }
    }
}

