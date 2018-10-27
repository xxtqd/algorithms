package cc189.ch10;

/**
 * Created by xu_xt on 10/24/18.
 */
// Worst case O(n) time complexity
public class Q10_5 {
    public int searchSparseArray(String[] a, String target) {
        // fixme: consider the case when target is an empty string
        if (a == null || target == null || target == "") {
            return -1;
        }
        int l = 0, r = a.length - 1;
            while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            String s = a[mid];
            if (s.isEmpty()) {
                mid = findNearestNonEmptyString(a, mid, l, r);
                if (mid == -1) {
                    return -1;
                }
            }
            if (target.equals(a[mid])) {
                return mid;
            } else if (target.compareTo(a[mid]) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
            if (a[l].equals(target)) {
            return l;
        }
            if (a[r].equals(target)) {
            return r;
        }
        return -1;
    }

    private int findNearestNonEmptyString(String[] a, int index, int start, int end) {
        int l = index - 1, r = index + 1;
        while (l >= start && r <= end) {
            if (!a[l].isEmpty()) {
                return l;
            }
            if (!a[r].isEmpty()) {
                return r;
            }
            l--;
            r++;
        }
        return -1;
    }
}

