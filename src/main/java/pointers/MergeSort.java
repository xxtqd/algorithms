package pointers;

public class MergeSort {
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        //     // quick sort
        //     int left = 0, right = A.length - 1;
        //     quickSort(A, left, right);
        // }

        // private void quickSort(int[] nums, int start, int end) {
        //     if (start >= end){
        //         return;
        //     }
        //     int left = start, right = end;
        //     int mid = nums[left + (right - left) / 2];
        //     while (left <= right) {
        //         while (left <= right && nums[left] < mid) {
        //             left++;
        //         }
        //         while (left <= right && nums[right] > mid) {
        //             right--;
        //         }
        //         // swap
        //         if (left <= right) {
        //             int temp = nums[left];
        //             nums[left] = nums[right];
        //             nums[right] = temp;
        //             left++;
        //             right--;
        //         }
        //     }
        //     quickSort(nums, start, right);
        //     quickSort(nums, left, end);
        // }

        //merge sort
        A = mergeSort(A, 0, A.length - 1);
    }
    private int[] mergeSort(int[] nums, int start, int end){
        if (start == end) {
            return new int[] {nums[start]};
        }
        int mid = (start + end ) / 2;
        return merge(mergeSort(nums, start, mid), mergeSort(nums, mid + 1, end));
    }

    private int[] merge(int[] a, int[] b){
        int lenA = a.length, lenB = b.length;
        int n = lenA + lenB;
        int[] result = new int[n];
        int currentA = 0, currentB = 0, current = 0;
        while (currentA < lenA && currentB < lenB){
            if (a[currentA] > b[currentB]){
                result[current++] = b[currentB++];
            } else {
                result[current++] = a[currentA++];
            }
        }
        while (currentA < lenA) {
            result[current++] = a[currentA++];
        }
        while (currentB < lenB) {
            result[current++] = b[currentB++];
        }

        return result;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        ms.sortIntegers2(new int[]{3,2,1,4,5});
    }
}
