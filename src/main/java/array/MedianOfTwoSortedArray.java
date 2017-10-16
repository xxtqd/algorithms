package array;

/**
 * Created by xxu on 10/16/2017.
 */
public class MedianOfTwoSortedArray {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a == null || b == null){
            return 0;
        }
        int lengthA = (a == null ? 0 : a.length);
        int lengthB = (b == null ? 0 : b.length);
        int medianPos = (lengthA + lengthB) / 2;
        double median = 0;
        if ((lengthA + lengthB) % 2 == 0){
            int left = findNumberInPosition(a, b, medianPos - 1);
            int right = findNumberInPosition(a, b, medianPos);
            median = ((double) left + (double) right)/2;
        } else {
            median = findNumberInPosition(a, b, medianPos);
        }
        return median;
    }

    private int findNumberInPosition(int[] a, int[] b, int pos){
        int left = 0, right = 0;
        int num = 0;
        int i = 0;
        while (i <= pos){
            while (i <= pos && left < a.length && (right == b.length || a[left] <= b[right])){
                num = a[left++];
                i++;
            }
            while (i <= pos && right < b.length && (left == a.length || b[right] <= a[left])){
                num = b[right++];
                i++;
            }
        }
        return num;
    }

    public static void main(String[] args){
        MedianOfTwoSortedArray solution = new MedianOfTwoSortedArray();
        int[] a = {1,2,3,4,5,6};
        int[] b = {2,3,4,5};
        double median = solution.findMedianSortedArrays(a, b);
        System.out.print(median);
    }
}
