package leetcode.trees;

import kotlin_in_action.structrures.trees.TreeNode;
import kotlin_in_action.structrures.trees.TreeUtils;

public class SortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        TreeUtils.preOrder(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(0, nums.length - 1, nums);
    }

    private static TreeNode constructBST(int left, int right, int[] nums) {
        if (right - left < 0)
            return null;
        if (left - right == 0)
            return new TreeNode(nums[left]);
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = constructBST(left, middle - 1, nums);
        root.right = constructBST(middle + 1, right, nums);
        return root;
    }
}
