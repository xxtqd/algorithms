package amazon;

public class RotateFunction {
     public int maxRotateFunction(int[] A) {
         if (A == null || A.length == 0) {
             return 0;
         }
         int n = A.length;
         int max = Integer.MIN_VALUE;
         for (int i = 0; i < n; i++) {
             int sum = 0;
             rotate(A, 1);
             for (int j = 0; j < n; j++) {
                 sum += j * A[j];
             }
             max = Math.max(max, sum);
         }
         return max;
     }

     private void rotate(int[] A, int index){
         int n = A.length;
         reverse(A, 0, index - 1);
         reverse(A, index, n - 1);
         reverse(A, 0, n - 1);
     }

     private void reverse (int[] A, int start, int end) {
         if (start >= end) {
             return;
         }
         while(start < end){
             int temp = A[start];
             A[start] = A[end];
             A[end] = temp;
             start++;
             end--;
         }
     }

     public static void main(String[] args) {
         RotateFunction rf = new RotateFunction();
         int[] a = new int[]{4,18,-3,-6,-1,12,2,-7,19,18,-5};
         rf.maxRotateFunction(a);
     }
}
