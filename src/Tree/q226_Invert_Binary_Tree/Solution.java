package Tree.q226_Invert_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        else{

            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }

    }

    //迭代 DFS 栈
    public TreeNode invertTree2(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == null) {
                continue;
            }
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            stack.push(curr.left);
            stack.push(curr.right);
        }
        return root;
    }

    //迭代 BFS 队列
    public TreeNode invertTree3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return root;
    }
}
