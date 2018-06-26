package sort;

/**
 * Created by xxu on 1/23/2018.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int n = nums.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (max == min) {
            return 0;
        }
        double bucketWidth = (max - min) * 1.0 / (n - 1);
        // buckets
        int[] localMax = new int[n];
        int[] localMin = new int[n];
        for (int i = 0; i < n; i++){
            localMax[i] = Integer.MIN_VALUE;
            localMin[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++){
            int bucket = (int)((nums[i] - min) / bucketWidth);
            localMax[bucket] = Math.max(localMax[bucket], nums[i]);
            localMin[bucket] = Math.min(localMin[bucket], nums[i]);
        }
        int result = (int) bucketWidth;
        int left = 0, right = 1;
        while (left < n - 1 && right < n){
            while (right < n - 1 && localMax[right] == Integer.MIN_VALUE){ // empty bucket
                right++;
            }
            result = Math.max(result, localMin[right] - localMax[left]);
            left = right;
            right++;
        }
        return result;
    }
    public static void main(String[] args){
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(new int[]{999,999,999,999,999,999,999,999,999,999}));
    }
}
