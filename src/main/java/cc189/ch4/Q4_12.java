package cc189.ch4;

import common.TreeNode;

import java.util.*;

/**
 * Created by xu_xt on 10/11/18.
 */
public class Q4_12 {
    // O(N) time since for each node we only go through once
    // O(logN) space since for each node we just need to store up to logN sum in the map
    // worst case on an unbalanced tree the space complexity can be O(N)
    public int sumPath(TreeNode root, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1); // cover the case when path start from root
        return sumPath(root, 0, target, sumMap);
    }
    private int sumPath(TreeNode root, int sum, int target, Map<Integer, Integer> sumMap) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int result = sumMap.getOrDefault(sum - target, 0);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        result += sumPath(root.left, sum, target, sumMap);
        result += sumPath(root.right, sum, target, sumMap);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) - 1);
        return result;
    }

    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        map.put(0, list);
        return pathSum(root, 0, target, new ArrayList<>(), map);
    }

    private List<List<Integer>> pathSum(TreeNode root, int sum, int target, List<Integer> path, Map<Integer, List<List<Integer>>> map) {
        if (root == null) {
            return new ArrayList<>();
        }
        sum += root.val;
        path.add(root.val);
        List<List<Integer>> results = new ArrayList<>();
        for (List<Integer> list : map.getOrDefault(sum - target, new ArrayList<>())) {
            List<Integer> copy = new ArrayList<>(path);
            for (Integer obj : list) {
                copy.remove(obj);
            }
            results.add(copy);
        }
        if (map.get(sum) == null) {
            map.put(sum, new ArrayList<>());
        }
        List<Integer> copy = new ArrayList<>(path);// fixme need to copy the arrayList
        map.get(sum).add(copy);
        results.addAll(pathSum(root.left, sum, target, path, map));
        results.addAll(pathSum(root.right, sum, target, path, map));
        map.get(sum).remove(copy);
        path.remove(path.size() - 1);
        return results;
    }

    public List<List<Integer>> binaryTreePathSum2BFSDFS(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                List<Integer> path = new ArrayList<>();
                helper(node, path, results, 0, target);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return results;
    }

    private void helper(TreeNode root, List<Integer> path,
                        List<List<Integer>> results, int sum, int target){
        if (root == null){
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (sum == target){
            results.add(new ArrayList<>(path));
        }
        helper(root.left, path, results, sum, target);
        helper(root.right, path, results, sum, target);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Q4_12 q = new Q4_12();
        TreeNode node = TreeNode.deserialize("{1,2,3,4,#,2}");
        q.binaryTreePathSum2BFSDFS(node, 6);
    }
}

