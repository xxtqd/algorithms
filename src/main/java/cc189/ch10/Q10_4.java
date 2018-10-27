package cc189.ch10;

import java.util.*;

/**
 * Created by xu_xt on 10/24/18.
 */
public class Q10_4 {
    public int findTarget(Listy listy, int target) {
        int r = findEnd(listy, target);
//        int l = 0;
        int l = r / 2; // fixme: target can only be on the second half
        return binarySearch(listy, l, r, target);
    }
    private int findEnd(Listy listy, int target) {
        int index = 1;
        while (listy.elementAt(index) > 0 && listy.elementAt(index) < target) {
            index *= 2;
        }
        return index;
    }
    private int binarySearch(Listy listy, int start, int end, int target) {
        int l  = start, r = end;
        while (l + 1 < end) {
            int mid = l + (r - l) / 2;
            int num = listy.elementAt(mid);
            if (num == -1 || target < num ) {
                r = mid - 1;
            } else if (target > num) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        if (listy.elementAt(l) == target) {
            return l;
        }
        if (listy.elementAt(r) == target) {
            return r;
        }
        return -1;
    }
    class Listy {
        private List<Integer> list;
        Listy () {
            this.list = new ArrayList<>();
        }
        Listy(int[] nums) {
            this.list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
        }
        public void add(int num) {
            this.list.add(num);
        }
        public int elementAt(int index) {
            if (index >= list.size()) {
                return -1;
            } else {
                return list.get(index);
            }
        }
    }
}
