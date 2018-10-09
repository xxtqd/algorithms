package cc189.ch2;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xu_xt on 10/8/18.
 */
public class Q2_7 {
    // HashSet
    // O(n + m) time O(n) space n and m is the size of the two list
    public ListNode intersectUsingHashSet(ListNode h1, ListNode h2) {
        Set<ListNode> set = new HashSet<>();
        while (h1 != null) {
            ListNode temp = h1;
            set.add(temp);
            h1 = h1.next;
        }
        while (h2 != null) {
            if (set.contains(h2)) {
                return h2;
            }
            h2 = h2.next;
        }
        return null;
    }
    // O(m + n) time O(1) space
    public ListNode intersection(ListNode h1, ListNode h2) {
        int size1 = 0, size2 = 0;
        ListNode dummy1 = h1, dummy2 = h2;
        while (dummy1 != null) {
            dummy1 = dummy1.next;
            size1++;
        }
        while (dummy2 != null) {
            dummy2 = dummy2.next;
            size2++;
        }
        dummy1 = h1;
        dummy2 = h2;
        if (size1 > size2) {
            int diff = size1 - size2;
            while (diff > 0) {
                dummy1 = dummy1.next;
                diff--;
            }
        } else {
            int diff = size2 - size1;
            while (diff > 0) {
                dummy2 = dummy2.next;
                diff--;
            }
        }
        while (dummy1 != dummy2) {
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }
        return dummy1;
    }

}

