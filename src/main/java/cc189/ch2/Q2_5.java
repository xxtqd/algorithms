package cc189.ch2;

import common.ListNode;

import java.util.Stack;

/**
 * Created by xu_xt on 10/8/18.
 */
public class Q2_5 {
    public ListNode  sumListReverse(ListNode h1, ListNode h2) {
        if (h1 == null && h2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        int carry = 0;
        while (h1 != null && h2 != null) {
            int sum = carry + h1.val + h2.val;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            h1 = h1.next;
            h2 = h2.next;
            dummy = dummy.next;
        }
        while (h1 != null) {
            int sum = carry + h1.val;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            h1 = h1.next;
            dummy = dummy.next;
        }
        while (h2 != null) {
            int sum = carry + h2.val;
            dummy.next = new ListNode(sum % 10);
            carry = sum / 10;
            h2 = h2.next;
            dummy = dummy.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return 	result.next;
    }
    // solve the problem with stack or recursively
    public ListNode sumList(ListNode h1, ListNode h2) {
        if (h1 == null && h2 == null) {
            return null;
        }
        // need to find out the size of each list
        ListNode t1 = h1, t2 = h2;
        int s = 0, l = 0;
        while (t1 != null && t2 != null) {
            t1 = t1.next;
            t2 = t2.next;
            s++;
            l++;
        }
        ListNode lh = null, sh = null;
        if (t1 != null) {
            lh = h1;
            sh = h2;
            while (t1 != null) {
                t1 = t1.next;
                l++;
            }
        } else {
            lh = h2;
            sh = h1;
            while (t2 != null) {
                t2 = t2.next;
                l++;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        while (l != s) {
            stack.push(lh);
            lh = lh.next;
            l--;
        }
        while (l != 0) {
            stack.push(new ListNode(lh.val + sh.val));
            lh = lh.next;
            sh = sh.next;
            l--;
        }
        ListNode result = new ListNode(0);
        int carry = 0;
        while (!stack.isEmpty()){
            int sum = stack.pop().val + carry;
            ListNode temp = new ListNode(sum % 10);
            // add to head
            temp.next = result.next;
            result.next = temp;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result.next;
            result.next = temp;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Q2_5 q = new Q2_5();
        ListNode h1 = ListNode.formList(new int[]{6,2,5});
        ListNode h2 = ListNode.formList(new int[]{9, 6});
        // 526 + 69 = 595
        ListNode result = q.sumListReverse(h1, h2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
        result = q.sumList(h1, h2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}
