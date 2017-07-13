package twosum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by xu_xt on 7/12/17.
 */
public class TwoSum {
    public int[] twoSumBrutalForce(int[] nums, int target) {
        if(nums.length < 2){
            return null;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j=0; j < nums.length; j++){
                if(i != j && nums[i] + nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumMapSolution(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
