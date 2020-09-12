package leetcode.trees;

import kotlin_in_action.structrures.trees.TreeNode;
import kotlin_in_action.structrures.trees.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        TreeNode node = addOneRow(root, 1, 2);
        System.out.println(TreeUtils.bfs(node));
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> levelToUpdate = new LinkedList<>();
        levelToUpdate.offer(root);
        int curLevelIdx = 1;

        while (curLevelIdx + 1 < d) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!levelToUpdate.isEmpty()) {
                TreeNode curNode = levelToUpdate.poll();
                if (curNode.left != null) nextLevel.offer(curNode.left);
                if (curNode.right != null) nextLevel.offer(curNode.right);
            }
            curLevelIdx++;
            levelToUpdate = nextLevel;
        }

        for (TreeNode node : levelToUpdate) {
            TreeNode newLeftNode = new TreeNode(v);
            TreeNode newRightNode = new TreeNode(v);
            newLeftNode.left = node.left;
            newRightNode.right = node.right;
            node.left = newLeftNode;
            node.right = newRightNode;
        }

        return root;
    }
}
