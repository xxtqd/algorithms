package cc189.ch8;

/**
 * Created by xu_xt on 10/17/18.
 */
// binary search
public class Q8_3 {
    public int findMagicIndexDistinct(int[] a) {
        if (a == null) {
            return -1;
        }
        int start = 0, end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == mid) {
                return mid;
            } else if (a[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (a[start] == start) {
            return start;
        }
        if (a[end] == end) {
            return end;
        }
        return -1;
    }

    public int findMagicIndexWithDupe(int[] a) {
        if (a == null) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public int findMagicIndexWithDupeImproved(int[] a) {
        if (a == null) {
            return -1;
        }
        return findMagicIndexWithDupeImproved(a, 0, a.length - 1);
    }

    private int findMagicIndexWithDupeImproved(int[] a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] == mid) {
            return mid;
        }
        int left = findMagicIndexWithDupeImproved(a, start, Math.min(mid - 1, a[mid]));
        if (left != -1) {
            return left;
        }
        return findMagicIndexWithDupeImproved(a, Math.max(mid + 1, a[mid]), end);
    }
}
