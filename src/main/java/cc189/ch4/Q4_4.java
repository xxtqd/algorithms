package cc189.ch4;

/**
 * Created by xu_xt on 10/10/18.
 */

import common.TreeNode;

/**
 * We just need to check recursively if the left subtree and right subtree are balanced
 *  and if the difference of heights between the two is less than one
  */

public class Q4_4 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int height = Math.max(left.height, right.height) + 1;
        if (left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1) {
            return new ResultType(height, true);
        } else {
            return new ResultType(height, false);
        }
    }

    private class ResultType {
        int height;
        boolean balanced;
        ResultType(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    /*
        better performance since it has cut the right branch when left is not balanced
     */
    public boolean isBalanced2(TreeNode root) {
        return helper2(root) >= 0;
    }

    private int helper2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper2(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}