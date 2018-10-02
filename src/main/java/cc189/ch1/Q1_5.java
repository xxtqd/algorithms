package cc189.ch1;

/**
 * Created by xu_xt on 10/1/18.
 */
// insert, remove or replace
// create a pointer for each, and a count counting steps away, when same, both add by 1, when different, move based on the length of each string
// check if both enter the end
// O(n) time O(1) space
public class Q1_5 {
    public boolean onStepAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        // same string, not one step away
        int sLen1 = s1.length(), sLen2 = s2.length();
        if (sLen1 == sLen2 && s1.equals(s2)) {
            return false;
        }
        // more than one step away
        if (Math.abs(sLen1 - sLen2) > 1) {
            return false;
        }
        int sIndex1 = 0, sIndex2 = 0;
        int step = 0;
        while (sIndex1 < sLen1 && sIndex2 < sLen2) {
            char c1 = s1.charAt(sIndex1);
            char c2 = s2.charAt(sIndex2);
            if (c1 == c2) {
                sIndex1++;
                sIndex2++;
            } else if (sLen1 == sLen2) {
                sIndex1++;
                sIndex2++;
                step++;
            } else if (sLen1 > sLen2) {
                sIndex1++;
                step++;
            } else {
                sIndex2++;
                step++;
            }
            if (step > 1) { 	// more than one step away
                return false;
            }
        }
        //return sIndex1 == sLen1 && sIndex2 == sLen2;// mistake: abc abcd
        return sIndex1 == sLen1 && sIndex2 == sLen2 || step == 0;
    }

    public static void main(String[] args) {
        Q1_5 q = new Q1_5();
        String[] testCases = {null, null, null, "", "abc", null, "abc", "a",
                "abc", "abcd",
                "bc", "abc",
                "abc", "abc",
                "abc", "abcde",
                "abcd", "abc",
                "abdc", "abc"};
        for (int i = 0; i < testCases.length; i+=2) {
            System.out.println(testCases[i] + "/" + testCases[i + 1] + ":" + q.onStepAway(testCases[i], testCases[i + 1]));
        }
    }
}
