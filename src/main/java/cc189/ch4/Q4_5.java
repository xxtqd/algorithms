package cc189.ch4;

import common.TreeNode;

/**
 * Created by xu_xt on 10/10/18.
 */

/**
 * in BST all node on the left subtree are smaller than the current node and all nodes on the right subtree are greater
 * max left <= val < min right
 */
public class Q4_5 {
    public boolean isValidBST(TreeNode root) {
        return helper(root).valid;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        ResultType left = helper(root.left);
        if (!left.valid || left.max > root.val) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
        ResultType right = helper(root.right);
        if (!right.valid || right.min <= root.val) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        }
        return new ResultType(right.max, left.min, true);

    }

    private class ResultType {
        boolean valid;
        int max;
        int min;
        ResultType(int max, int min, boolean valid) {
            this.max = max;
            this.min = min;
            this.valid = valid;
        }
    }
}
