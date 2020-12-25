package Tree.q102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();

            while (count > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                count--;
            }
            ans.add(list);
        }
        return ans;
    }
}
