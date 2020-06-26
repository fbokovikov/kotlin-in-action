package kotlin_in_action.amazon.easy;

import kotlin_in_action.structrures.trees.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[]args){
        TreeNode sRoot = new TreeNode(3);
        sRoot.left = new TreeNode(4);
        sRoot.right = new TreeNode(5);
        sRoot.left.left = new TreeNode(1);
        sRoot.left.right = new TreeNode(2);

        TreeNode tRoot = new TreeNode(4);
        tRoot.left = new TreeNode(1);
        tRoot.right = new TreeNode(2);

        System.out.println(isSubtree(sRoot, tRoot));
    }

    /**
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
     * with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
     * The tree s could also be considered as a subtree of itself.
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (containsTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private static boolean containsTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null ^ t == null)
            return false;
        return s.val == t.val && containsTree(s.left, t.left) && containsTree(s.right, t.right);
    }
}
