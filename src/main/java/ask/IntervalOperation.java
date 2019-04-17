package ask;

import java.util.*;

/**
 * Created by xu_xt on 4/2/19.
 */
public class IntervalOperation {
    public Interval overlap(Interval intv1, Interval intv2) {
        if (intv1 == null || intv2 == null) {
            return null;
        }
        if (intv1.end < intv2.start || intv2.end < intv1.start) {
            return null;
        }
        return new Interval(Math.max(intv1.start, intv2.start), Math.min(intv1.end, intv2.end), intv1.val && intv2.val);
    }

    public List<Interval> split(List<Interval> l1, List<Interval> l2) {
        if (l1 == null || l1.isEmpty()) {
            return l2;
        }
        if (l2 == null || l2.isEmpty()) {
            return l1;
        }
        int m = l1.size(), n = l2.size();
        int i = 0, j =0;
        List<Interval> result = new ArrayList<>();
        while (i < m && j < n) {
            Interval intv1 = l1.get(i);
            Interval intv2 = l2.get(j);
            if (intv1.end < intv2.end) {
                i++;
            } else if (intv1.end > intv2.end){
                j++;
            } else {
                i++;
                j++;
            }
            result.add(overlap(intv1, intv2));
        }
        return result;
    }

    List<Interval> findOverlap(List<Interval> list1, List<Interval> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        List<Interval> result = new ArrayList<>();
        int size1 = list1.size(), size2 = list2.size();
        int i = 0, j = 0;
        while (i < size1 && j < size2) {
            Interval in1 = list1.get(i);
            Interval in2 = list2.get(j);
            Interval in = overlap(in1, in2);
            if (in1.end < in2.end) {
                i++;
            } else if (in1.end > in2.end) {
                j++;
            } else {
                i++;
                j++;
            }
            if (!result.isEmpty()) {
                Interval last = result.get(result.size() - 1);
                if (last.end == in.start && last.val == in.val) {
                    last.end = in.end;
                } else {
                    result.add(in);
                }
            } else {
                result.add(in);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        IntervalOperation operation = new IntervalOperation();
        List<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(Integer.MIN_VALUE, 4, true));
        l1.add(new Interval(5, 6, false));
        l1.add(new Interval(7, Integer.MAX_VALUE, true));
        List<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(Integer.MIN_VALUE, 4, true));
        l2.add(new Interval(5, Integer.MAX_VALUE, true));
        System.out.println(operation.split(l1, l2));
        l1 = new ArrayList<>();
        l1.add(new Interval(Integer.MIN_VALUE, 0, true));
        l1.add(new Interval(0, 5, false));
        l1.add(new Interval(5, Integer.MAX_VALUE, true));
        l2 = new ArrayList<>();
        l2.add(new Interval(Integer.MIN_VALUE, 3, true));
        l2.add(new Interval(3, 6, false));
        l2.add(new Interval(6, Integer.MAX_VALUE, true));
        System.out.println(operation.split(l1, l2));
        System.out.println(operation.findOverlap(l1, l2));
    }
}
