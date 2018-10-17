package cc189.ch4;

import common.TreeNode;

/**
 * Created by xu_xt on 10/10/18.
 */
public class Q4_8 {
    public TreeNode firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a) {
            return a;
        }
        if (root == b) {
            return b;
        }
        TreeNode left = firstCommonAncestor(root.left, a, b);
        TreeNode right = firstCommonAncestor(root.right, a, b);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}

