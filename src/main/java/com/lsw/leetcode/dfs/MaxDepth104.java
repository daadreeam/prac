package com.lsw.leetcode.dfs;

/**
 * 二叉树的最大深度
 * 1。递归
 * 2。迭代？
 */
public class MaxDepth104 {

    public static void main(String[] args) {


    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return  left + 1;
        } else {
            return right + 1;
        }
    }

    public static int maxDepth2(TreeNode root) {
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
