package leetcode.trees;

import kotlin_in_action.structrures.trees.TreeNode;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivaluedTree(root, root.val);
    }

    private static boolean isUnivaluedTree(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return (node.val == val) && isUnivaluedTree(node.left, val) && isUnivaluedTree(node.right, val);
    }
}
