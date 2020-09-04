package kotlin_in_action.facebook.medium;

import kotlin_in_action.structrures.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        Queue<TreeNode> unprocessedNodes = new LinkedList<>();
        if (root != null)
            unprocessedNodes.offer(root);

        while (!unprocessedNodes.isEmpty()) {
            Queue<TreeNode> levelNodes = new LinkedList<>();
            TreeNode node = null;
            while (!unprocessedNodes.isEmpty()) {
                node = unprocessedNodes.poll();
                if (node.left != null) levelNodes.offer(node.left);
                if (node.right != null) levelNodes.offer(node.right);
            }
            rightSide.add(node.val);
            unprocessedNodes.addAll(levelNodes);
        }
        return rightSide;
    }

}
