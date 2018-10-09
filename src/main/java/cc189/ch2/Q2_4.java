package cc189.ch2;

import cc189.ch1.Q1_4;
import common.ListNode;

/**
 * Created by xu_xt on 10/5/18.
 */
// iterate through the list, add node smaller that target value to head otherwise to tail.
// O(n) time O(1) space where n is the size of the list
public class Q2_4 {
    public ListNode partitionList(ListNode node, int target) {
        if (node == null) {
            return null;
        }
        ListNode head = node, tail = node;
        while (node != null) {
            ListNode temp = node.next;
            if (node.val < target) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
                // fixme can't put tail.next = null here, since it may not come to this block e.g {3} infinite loop
                // tail.next = null;
            }
            node = temp;
        }
        // fixme need to make end of list null
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.formList(new int[]{3});
        Q2_4 q = new Q2_4();
        ListNode head = q.partitionList(node, 5);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
