package kotlin_in_action.facebook.easy;

import kotlin_in_action.structrures.trees.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
    }

    public static int rangeSumBST(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }
        int result = root.val >= l && root .val <= r ? root.val : 0;
        if (root.val > l) {
            result += rangeSumBST(root.left, l, r);
        }
        if (root.val < r) {
            result += rangeSumBST(root.right, l, r);
        }
        return result;
    }
}
