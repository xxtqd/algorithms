package cc189.ch2;

import common.ListNode;

/**
 * Created by xu_xt on 10/8/18.
 */
//when slow and fast meet, slow - k steps, fast - 2 * k steps, fast has gone through n circles more than slow 2 * k = k + n * r -> k = n * r
// suppose we need to walk p steps to reach start of circle p + x = n * r -> p = n * r - x = (n - 1) * r + (r - x) r - x is what’s left in the circle
// leave fast where it is and slow start from head, then will meet at the start of circle
public class Q2_8 {
    public ListNode hasLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // fixme mistake error check
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
