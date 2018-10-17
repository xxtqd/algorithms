package cc189.ch4;

import common.TreeNode;

/**
 * Created by xu_xt on 10/9/18.
 */

/**BST node value is greater than nodes on left subtree and small than nodes on right subtree
 * To create a BST of minimal height, we need to match the number of nodes on the left subtree with
 * number of nodes on the right subtree as much as possible
 * split the array in half and buildMinimslHeightBST left and right recursively
 * O(n) time
 *
 */
public class Q4_2 {
    public TreeNode buildBST(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return buildMinimslHeightBST(array, 0, array.length - 1);
    }
    private TreeNode buildMinimslHeightBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = buildMinimslHeightBST(array, start, mid - 1);
        root.right = buildMinimslHeightBST(array, mid + 1, end);
        return root;
    }
}
