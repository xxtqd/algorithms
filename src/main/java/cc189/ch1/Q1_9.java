package cc189.ch1;

/**
 * Created by xu_xt on 10/2/18.
 */
// rotate string and then compare
// O(n) time O(n) space
public class Q1_9 {
    // fixme misunderstood rotation
    public boolean isRotationWrong(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        char[] chars = s2.toCharArray();
        int left = 0, right = len2 - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return isSubstring(s1, new String(chars));
    }

    public boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        return isSubstring(s1, s2 + s2);
    }

    private boolean isSubstring(String s1, String s2) {
        return false;
    }
}

