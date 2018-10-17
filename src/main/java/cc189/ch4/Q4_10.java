package cc189.ch4;

import common.TreeNode;

/**
 * Created by xu_xt on 10/11/18.
 */
// find root of T2 in T1
// if r2 exists in T1, then we check if the subtree having r2 as root is identical as T2
// O(N1) time O(1) space since we need to scan T1 and T2
// misunderstood the problem

// The problem is actually comparing the value in the subtree and decide if T2 is a subtree of T1
// scan T1, when a node with the same value as T2 is found, compare the subtree value
// O(n1 + kn2)
public class Q4_10 {
    public boolean isSubTree(TreeNode t1, TreeNode t2) {
        // empty is a subtree??
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (match(t1, t2)) {
            return true;
        }
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    private boolean match(TreeNode t1, TreeNode t2) {
        if (t1== null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return match(t1.left, t2.left) && match(t1.right, t2.right);
    }
}
