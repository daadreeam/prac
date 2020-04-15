package com.lsw.leetcode.binarytree;

import java.util.LinkedList;

public class TreeUtil {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode genTree(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        int index = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty() && index < nums.length) {
            TreeNode pop = queue.removeLast();
            if (index < nums.length) {
                pop.left = new TreeNode(nums[index++]);
            }
            if (index < nums.length) {
                pop.right = new TreeNode(nums[index++]);
            }
            queue.addFirst(pop.left);
            queue.addFirst(pop.right);
        }
        return root;
    }

    public static void printTree(TreeNode root){

    }
}
