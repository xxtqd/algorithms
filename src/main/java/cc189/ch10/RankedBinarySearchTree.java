package cc189.ch10;

/**
 * Created by xu_xt on 10/26/18.
 */
public class RankedBinarySearchTree {
    private RankedNode root;

    public void track(int num){
        if (root == null) {
            root = new RankedNode(num);
        } else {
            root.insert(num);
        }
    }
    public int getRankOfNumber(int num) {
        return getRankOfNumber(root, num);
    }
    public int getRankOfNumber(RankedNode root, int num) {
        if (root == null) {
            return -1;
        }
        int count = 0;
        if (num == root.val) {
            return root.sizeOfLeft;
        } else if (num > root.val) {
            int right = getRankOfNumber(root.right, num);
            if (right == -1) {
                return -1;
            }
            count = root.sizeOfLeft + 1 + right;
        } else {
            count = getRankOfNumber(root.left, num);
        }
        return count;
    }

    public class RankedNode {
        RankedNode left;
        RankedNode right;
        int sizeOfLeft;
        int val;

        public RankedNode(int val) {
            this.val = val;
        }

        public void insert (int num) {
            if (num > val) {
                if (right == null) {
                    RankedNode node = new RankedNode(num);
                    right = node;
                } else {
                    right.insert(num);
                }
            } else  {
                if (left == null) {
                    RankedNode node = new RankedNode(num);
                    left = node;
                } else {
                    left.insert(num);
                }
                sizeOfLeft++;
            }
        }
    }


}

