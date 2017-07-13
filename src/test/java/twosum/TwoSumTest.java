package twosum;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xu_xt on 7/12/17.
 */
public class TwoSumTest {

    @Test
    public void testTwoSum(){
        int[] nums = {2,3,4};
        int target = 6;
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSumBrutalForce(nums, target);
        assertTrue(result[0]==0&&result[1]==2 || result[1]==0&&result[0]==2);
        result = ts.twoSumMapSolution(nums, target);
        assertTrue(result[0]==0&&result[1]==2 || result[1]==0&&result[0]==2);

    }
}
