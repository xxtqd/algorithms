package cc189.ch10;

/**
 * Created by xu_xt on 10/24/18.
 */
// from end to start and place element from position n + m where n is the length of a and m is the length of b
// O(N + M) time
public class Q10_1 {
    public void mergeTwoSortedArray(int[] a, int[] b) {
        int n = a.length; // fixme: how to decide the actual length of a??
        for (int i = n - 1; i >= 0; i--) {
            if(a[i] == Integer.MIN_VALUE) {
                n--;
            }
        }
        int m = b.length;
        int i = n - 1, j = m - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[index] = a[i];
                i--;
            } else {
                a[index] = b[j];
                j--;
            }
            index--;
        }
        while (j >= 0) {
            a[index--] = b[j--];
        }
    }

    public static void main(String[] args) {
        Q10_1 q = new Q10_1();
        int[] a = {1,2,3,4,5,6,9,Integer.MIN_VALUE,Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] b = {7,8};
        q.mergeTwoSortedArray(a, b);
        for (int num : a) {
            System.out.print(num + ", ");
        }
    }
}
