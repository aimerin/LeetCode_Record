package Tree.q1325_Delete_Leaves_with_a_Given_Value;

import java.util.LinkedList;
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
    //递归
    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        if(root==null)return root;

        root.left=removeLeafNodes2(root.left,target);
        root.right=removeLeafNodes2(root.right,target);
        if(root.val==target&&root.left==null&root.right==null)return null;
        return root;
    }

    //迭代
    public TreeNode removeLeafNodes(TreeNode root,int target){
        if(root==null)return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null) queue.offer(treeNode.left);
            if(treeNode.right!=null) queue.offer(treeNode.right);
            if(treeNode.left==null&& treeNode.right==null&&treeNode.val==target)treeNode=null;
        }
        return root;
    }
}
