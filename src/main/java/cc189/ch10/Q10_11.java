package cc189.ch10;

import java.util.Arrays;

/**
 * Created by xu_xt on 10/24/18.
 */
// Sort array and place numbers alternatively
// 1,2,3,4,5
// 31425
// 1,2,3,4,5,6
// 415263
// 1,2,3,3,5
// 31325
// O(nlogn) time sorting O(n) space
public class Q10_11 {
    public int[] generatePeaksAndValleys(int[] a) {
        if(a == null || a.length <= 1) {
            return a;
        }
        int n = a.length;
        Arrays.sort(a);
        int[] result = new int[n];
        int index = 0, valley = 1, peak = n / 2;
        while (index < n) {
            result[index++] = a[peak];
            peak += 2;
            if (index < n) {
                result[index++] = a[valley];
                valley += 2;
            }
        }
        return result;
    }
    // for every other element, swap with the previous number
    // O(nlogn) time and in place
    public void genPeaksAndValleysImproved(int[] a) {
        if(a == null || a.length <= 1) {
            return;
        }
        int n = a.length;
        Arrays.sort(a);
        int index = 1;
        while (index < n) {
            swap(a, index - 1, index);
            index += 2;
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // optimal O(n) time in place
    // compare every other element with its left and right neighbors
    public void genPeaksAndValleysOptimal(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int n = a.length;
        for (int i = 1; i < n; i += 2) {
            int minIndex = findMinIndex(a, i - 1, i, i + 1);
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }
    private int findMinIndex(int[] a, int i, int j, int k) {
        int n = a.length;
        int vi = i >= 0 && i < n ? a[i] : Integer.MAX_VALUE;
        int vj = j >= 0 && j < n ? a[j] : Integer.MAX_VALUE;
        int vk = k >= 0 && k < n ? a[k] : Integer.MAX_VALUE;
        int vMin = Math.min(vi, Math.min(vj, vk));
        if (vi == vMin) {
            return i;
        } else if (vj == vMin) {
            return j;
        } else {
            return k;
        }
    }

}