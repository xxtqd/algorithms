package pointers;

/**
 * Created by xxu on 1/29/2018.
 */
public class QuickSelect {
    public int kthSmallest(int k, int[] nums) {
        if(nums == null || nums.length < k) {
            return -1;
        }
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    private void quickSelect(int[] nums, int start, int end, int k){
        if (start >= end) {
            return;
        }
        int left = start, right = end;
        int pivot = nums[(start + end) / 2]; // pivot has to be a fixed number, should not use index e.g. pivot = (start + end) / 2
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (right >= k - 1) {
            quickSelect(nums, start, right, k);
        } else if (left <= k - 1){
            quickSelect(nums, left, end, k);
        } else {
            return;
        }
    }

    private void swap (int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args){
        QuickSelect quickSelect = new QuickSelect();
        quickSelect.kthSmallest(3, new int[]{3,4,1,2,5});
    }
}
