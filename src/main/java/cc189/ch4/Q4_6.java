package cc189.ch4;

import common.ParentTreeNode;
import common.TreeNode;

/**
 * Created by xu_xt on 10/10/18.
 */
public class Q4_6 {
    public ParentTreeNode BSTSuccessor(ParentTreeNode node) {
        if (node == null) {
            return null;
        }
        // if node has right child, return the leftmost node on the right subtree
        if (node.right != null) {
            ParentTreeNode child = node.right;
            while (child.left != null) {
                child = child.left;
            }
            return child;
        }
        // if node is on the left subtree of another node, find that node
        ParentTreeNode parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
    // with root but without knowing parent for each node
    // if node is on the left, we need to know the parent of the node
    // if node is on the right, the next would be either on its right subtree or the parent to its right
    public TreeNode BSTSuccessorWithRoot(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return null;
        }
        // find node
        TreeNode parent = null;
        while (root != null && root != node) {
            if (root.val >= node.val) {
                parent = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        // node does not exist
        if (root == null) {
            return 	null;
        }
        if (node.right == null) {
            return parent;
        }
        // find the leftmost node on its right subtree;
        TreeNode child = node.right;
        while (child.left != null) {
            child = child.left;
        }
        return child;
    }
}
