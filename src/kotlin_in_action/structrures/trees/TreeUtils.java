package kotlin_in_action.structrures.trees;

import java.util.*;

public class TreeUtils {

    public static List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> remainedNodes = new LinkedList<>();
        remainedNodes.offer(root);

        while (!remainedNodes.isEmpty()) {
            TreeNode node = remainedNodes.poll();
            if (node.left != null) {
                remainedNodes.offer(node.left);
            }
            if (node.right != null) {
                remainedNodes.offer(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

    public static List<Integer> DfsPreOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> remainedNodes = new Stack<>();
        remainedNodes.push(root);

        while (!remainedNodes.isEmpty()) {
            TreeNode node = remainedNodes.pop();
            if (node.right != null) {
                remainedNodes.push(node.right);
            }
            if (node.left != null) {
                remainedNodes.push(node.left);
            }
            result.add(node.val);
        }
        return result;
    }

    //      1
    //  2       3
    //4   5

    //(Root-Left-Right) 1 2 4 5 3
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //(Left-Right-Root) 4 5 2 3 1
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    //(Left-Root-Right) 4 2 5 1 3
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
