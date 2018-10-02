package cc189.ch1;

import java.util.*;

/**
 * Created by xu_xt on 10/1/18.
 */
public class Q1_1 {
    // O(n) time O(n) space
    public boolean isStringUnique(String str) {
        if (str == null) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                return false;
            }
        }
        return true;
    }

    // O(n^2) time O(1) space
    public boolean isStringUniqueWithoutExtraSpace(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q1_1 q1_1 = new Q1_1();
        String[] testCases = new String[]{"aaaa", "", null, "abcde", "1234#dv"};
        for (String str : testCases) {
            System.out.println(str + ": " + q1_1.isStringUnique(str));
            System.out.println(str + ": " + q1_1.isStringUniqueWithoutExtraSpace(str));
        }
    }
}
