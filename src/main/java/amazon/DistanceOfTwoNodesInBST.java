package amazon;

import java.util.Arrays;

public class DistanceOfTwoNodesInBST {

    public int distanceOfTwoInBST(int[] nums, int a, int b) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        TreeNode root = constructBST(nums, 0, nums.length - 1);
        int distance = distanceInBST(root, a, b);
        return distance;
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        return root;
    }

    private int distanceInBST(TreeNode root, int a, int b) {
        int val = root.val;
        if (a < val && b < val) {
            return distanceInBST(root.left, a, b);
        }
        if (a > val && b > val) {
            return distanceInBST(root.right, a, b);
        }
        return levelInBST(root, a) + levelInBST(root, b);
    }

    private int levelInBST(TreeNode root, int val) {
        if (root.val == val) {
            return 0;
        }
        if (val < root.val) {
            return levelInBST(root.left, val) + 1;
        }
        return levelInBST(root.right, val) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DistanceOfTwoNodesInBST d = new DistanceOfTwoNodesInBST();
        int distance = d.distanceOfTwoInBST(new int[]{}, 0, 0);
        System.out.println(distance);
    }

}
