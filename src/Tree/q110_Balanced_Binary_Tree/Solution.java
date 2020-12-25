package Tree.q110_Balanced_Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return Math.abs(height(root.right) - height(root.left)) <= 1
                && isBalanced(root.right)
                && isBalanced(root.left);
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        else {
            return Math.max(height(root.right), height(root.left)) + 1;
        }
    }
}
