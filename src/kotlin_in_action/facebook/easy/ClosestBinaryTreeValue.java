package kotlin_in_action.facebook.easy;

import kotlin_in_action.structrures.trees.TreeNode;

public class ClosestBinaryTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(closestValue(root, 2.714286));
    }

    public static int closestValue(TreeNode root, double target) {
        if (root.val == target
                || root.val >= target && root.left == null
                || root.val <= target && root.right == null) {
            return root.val;
        }

        int leafValue = closestValue(root.val > target ? root.left : root.right, target);
        if (Math.abs(target - leafValue) < Math.abs(root.val - target))
            return leafValue;
        else
            return root.val;
    }
}
