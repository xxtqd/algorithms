package cc189.ch4;

import common.TreeNode;

import java.util.*;

/**
 * Created by xu_xt on 10/11/18.
 */
// children need to be after parent
// create an candidate list every time we add a node to the result, we add its children to the candidate list, iterate through the candidate list to find the next node the add to the result

public class Q4_9 {
    public List<List<Integer>> findAllSequence(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<TreeNode> candidates = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        candidates.add(root);
        helper(result, candidates, results);
        return results;
    }
    private void helper(List<Integer> result, List<TreeNode> candidates, List<List<Integer>> results) {
        if (candidates.size() == 0) {
            results.add(new ArrayList<>(result));
//            for (int num : result) {
//                System.out.print(num);
//            }
//            System.out.println();
            return;
        }
        List<TreeNode> copy = new ArrayList<>(candidates);
        for (TreeNode node : copy) {
            result.add(node.val);
            candidates.remove(node);
            if (node.left != null) {
                candidates.add(node.left);
            }
            if (node.right != null) {
                candidates.add(node.right);
            }
            helper(result, candidates, results);
            result.remove(result.size() - 1);
            candidates.add(node);
            // fixme remember to remove its children
            if (node.left != null) {
                candidates.remove(node.left);
            }
            if (node.right != null) {
                candidates.remove(node.right);
            }
        }

    }
    public static void main(String[] args) {
        Q4_9 q = new Q4_9();
        TreeNode node = TreeNode.deserialize("{4,2,5,1,3,#,6}");
        for (List<Integer> list : q.findAllSequence(node)) {
            for (int num : list) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
