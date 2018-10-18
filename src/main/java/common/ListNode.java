package common;

/**
 * Created by xu_xt on 8/14/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode formList(int[] array) {
        if (array == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int i = 0; i < array.length; i++) {
            dummy.next = new ListNode(array[i]);
            dummy = dummy.next;
        }
        return head.next;
    }

}