package cc189.ch10;

import java.util.*;

/**
 * Created by xu_xt on 10/24/18.
 */
// todo: revisit
// find duplicate number between 1 to 32000 with 4k of memory
// 4K = 4 * 1024 * 8 bit > 32000 bit
// could use bitset in the size of 32000, one bit for each number to check for duplicate
public class Q10_8 {
    public List<Integer> findDuplicate(int[] nums) {
        List<Integer> result = new ArrayList<>();
        MyBitSet bitSet = new MyBitSet(32001);
        for (int num : nums) {
            if (bitSet.get(num)) {
                result.add(num);
            } else {
                bitSet.set(num);
            }
        }
        return result;
    }

    public class MyBitSet {
        int[] bits;
        MyBitSet(long size) {
            bits = new int[(int)(size / 32) + 1];
        }
        public boolean get(int num) {
            return (bits[num / 32] & (1 << (num % 32))) != 0;
        }

        public void set(int num) {
            bits[num / 32] |= (1 << (num % 32));
        }

    }
}
