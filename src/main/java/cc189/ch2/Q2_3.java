package cc189.ch2;

import common.ListNode;

/**
 * Created by xu_xt on 10/5/18.
 */
// O(1) time and space
// We only know the node we want to delete and its next
public class Q2_3{
    public boolean deleteMiddle (ListNode node) {
        if (node == null) {
            return false;
        }
        if (node.next == null) {
            node = null;
            return true;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return true;
    }
}