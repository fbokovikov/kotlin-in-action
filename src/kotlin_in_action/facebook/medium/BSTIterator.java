package kotlin_in_action.facebook.medium;

import kotlin_in_action.structrures.trees.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BSTIterator implements Iterator<Integer> {

    private List<Integer> values = new ArrayList<>();
    private int curPos = 0;

    public BSTIterator(TreeNode root) {
        initValues(root);
    }

    private void initValues(TreeNode root) {
        if (root == null) {
            return;
        }
        initValues(root.left);
        values.add(root.val);
        initValues(root.right);
    }

    /** @return the next smallest number */
    public Integer next() {
        return values.get(curPos++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curPos < values.size();
    }
}
