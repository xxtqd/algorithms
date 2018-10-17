package cc189.ch4;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by xu_xt on 10/11/18.
 */
// Implement random node binary search tree
// insert O(logN) find O(logN) delete O(logN) getRandomNode O(logN)
public class Q4_11 {
    int size;
    TreeNode root;
    public void insert(int num) {
        insert(root, new TreeNode(num));
        size++;
    }
    private void insert(TreeNode root, TreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        if (node == null) {
            return;
        }
        if (node.val <= root.val) {
            insert(root.left, node);
        } else {
            insert(root.right, node);
        }
    }
    public TreeNode find(int num) {
        return find(root, num);
    }
    private TreeNode find (TreeNode root, int num) {
        if (root == null) {
            return null;
        }
        if (num == root.val) {
            return root;
        } else if (num < root.val) {
            return find (root.left, num);
        } else {
            return find(root.right, num);
        }
    }
//    public boolean delete(int num) {
//        TreeNode node = find(num);
//        // can’t find node in tree
//        if (node == null) {
//            return false;
//        }
//        TreeNode left = node.left;
//        TreeNode right = node.right;
//        TreeNode temp = null;
//        if (left != null) {
//            insert(left, right);
//            temp = left;
//        } else {
//            temp = right;
//        }
//        TreeNode parent = findParent(this.root, node);
//        // if parent is null, delete root
//        if (parent == null) {
//            root = temp;
//        } else {
//            if (node.val <= parent.val) {
//                parent.left = temp;
//            } else {
//                parent.right = temp;
//            }
//        }
//        size--;
//        return true;
//    }
    private TreeNode findParent(TreeNode r, TreeNode node) {
        if (r == null) {
            return null;
        }
        if (r.left == node || r.right == node) {
            return r;
        }
        TreeNode left = findParent(r.left, node);
        if (left != null) {
            return left;
        } else {
            return findParent(r.right, node);
        }
    }
    /*
    Find the deletion node p (= the node that we want to delete)
    Find the successor node of p
    Replace the content of node p with the content of the successor node
    Delete the successor node
     */
    public boolean delete (int num) {
        TreeNode node = find(num);
        if (node == null) {
            return false;
        }
        TreeNode parent = findParent(root, node);
        // node is a leaf node, parent points to null
        if (node.left == null && node.right == null) {
            // node is root;
            if (parent == null) {
                root = null;
            } else {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (node.left == null || node.right == null) {
            // one child, parent point to its child
            TreeNode child = node.left != null ? node.left : node.right;
            if (parent == null) {
                root = child;
            } else {
                if (parent.left == node){
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        } else {
            // find successor (leftmost on right subtree if right child exists)
            TreeNode successor = node.right;
            TreeNode successorParent = node;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent == node) {
                node.val = successor.val;
                node.right = successorParent.right;
            } else {
                node.val = successor.val;
                successorParent.left = successor.right;
            }

        }
        return true;
    }
    public TreeNode getRandomNode() {
        Random random = new Random();
        int val = random.nextInt(size);
        return getNode(root, val);
    }
    // if we always traverse with the same order, all nodes are equally likely to be chosen
    private TreeNode getNode(TreeNode node, int index) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty() && index > 0) {
            TreeNode n = q.poll();
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
            index--;
        }
        return q.isEmpty() ? null : q.poll();
    }
}