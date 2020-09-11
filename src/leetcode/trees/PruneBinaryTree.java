package leetcode.trees;

import kotlin_in_action.structrures.trees.TreeNode;
import kotlin_in_action.structrures.trees.TreeUtils;

public class PruneBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        TreeNode result = pruneTree(root);
        TreeUtils.inOrder(result);
    }

    /**
     * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
     *
     * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
     */
    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
