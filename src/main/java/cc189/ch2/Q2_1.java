package cc189.ch2;

import common.ListNode;

import java.util.*;

/**
 * Created by xu_xt on 10/5/18.
 */
public class Q2_1 {
    // O(n) time O(n) space
    public void removeDupFromLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode dummy = head;
        ListNode prev = null;
        Set<Integer> set = new HashSet<>();
        while (	dummy != null) {
            // remove if value exist
            if (set.contains(dummy.val)) {
                prev.next = dummy.next;
                dummy = dummy.next;
            }  else {
                set.add(dummy.val);
                prev = dummy;
                dummy = dummy.next;
            }
        }
    }
    // O(n^2) time  O(1) space
    public void removeDupFromLinkedListWithoutExtraSpace(ListNode head) {
        ListNode dummy = head;
        while (dummy != null) {
            int val = dummy.val;
            ListNode prev = dummy;
            ListNode current = dummy.next;
            while (current != null) {
                if (current.val == val) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
            dummy = dummy.next;
        }
    }
}
