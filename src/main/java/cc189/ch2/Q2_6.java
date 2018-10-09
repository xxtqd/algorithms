package cc189.ch2;

import common.ListNode;

/**
 * Created by xu_xt on 10/8/18.
 */
// reverse the list and compare with original
// O(n) time and O(n) space where n is the size of the list
public class Q2_6 {
    public boolean isPalindrome(ListNode head) {
        ListNode r = reverse(head);
        while (head != null && r != null) {
            if (head.val != r.val) {
                return false;
            }
            head = head.next; //fixme mistake: remember to refresh pointer
            r = r.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        while (head != null) {
//fixme mistake be careful with reference, use copy instad of reference
//            ListNode temp = head.next;
//            head.next = prev;
//            prev = head;
//            head = temp;
            ListNode temp = new ListNode(head.val);
            temp.next = prev;
            prev = temp;
            head = head.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Q2_6 q = new Q2_6();
        ListNode head = ListNode.formList(new int[]{3,5,6,4,2,1,3});
        System.out.println(q.isPalindrome(head));
        head = ListNode.formList(new int[]{3,5,6,4,6,5,3});
        System.out.println(q.isPalindrome(head));
        head = ListNode.formList(new int[]{3,5,6,4,4,6,5,3});
        System.out.println(q.isPalindrome(head));
    }
}
