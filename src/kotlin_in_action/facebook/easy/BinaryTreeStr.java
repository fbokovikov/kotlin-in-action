package kotlin_in_action.facebook.easy;

import kotlin_in_action.structrures.trees.TreeNode;

public class BinaryTreeStr {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(null));
    }

    public static String tree2str(TreeNode t) {
        StringBuilder result = new StringBuilder();
        tree2str(result, t);

        return result.toString();
    }

    public static void tree2str(StringBuilder res, TreeNode t) {
        if (t == null) {
            return;
        }

        res.append(t.val);

        if (t.left != null || t.right != null) {
            res.append('(');
            tree2str(res, t.left);
            res.append(')');
        }

        if (t.right != null) {
            res.append('(');
            tree2str(res, t.right);
            res.append(')');
        }
    }
}
