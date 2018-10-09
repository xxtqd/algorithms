package cc189.ch2;

import common.ListNode;

/**
 * Created by xu_xt on 10/5/18.
 */
// O(n) time two passes
// O(n) time O(1) space, two pointers one is k - 1 steps ahead
// Assumption: when k = 1 return the last node
public class Q2_2 {
    public ListNode kthToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i <= k; i++) {
            if (p1 == null) {
                return null; // size less than k
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}