package cc189.ch1;

import java.util.*;

/**
 * Created by xu_xt on 10/1/18.
 */
public class Q1_2 {
    // O (n) time O(n) space n is the length of s1
    public boolean isPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        for (int v : map.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Q1_2 q1_2 = new Q1_2();
        String[] testCases = {null, null, null, "", "abc", null, "abc", "a",
                "aaaabbbbccccdddd", "abcdabcdabcdabcd",
                "abcddcba", "dcbaabcd"};
        for (int i = 0; i < testCases.length; i+=2) {
            System.out.println(testCases[i] + "/" + testCases[i + 1] + ":" + q1_2.isPermutation(testCases[i], testCases[i + 1]));
        }
    }
}
