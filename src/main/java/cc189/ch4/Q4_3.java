package cc189.ch4;

import common.TreeNode;

import java.util.*;

/**
 * Created by xu_xt on 10/9/18.
 */
// Level traverse of binary tree
// use BFS
// O(n) time where n is the number of nodes
public class Q4_3 {
    public List<List<TreeNode>> listOfDepths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}