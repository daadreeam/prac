package com.lsw.leetcode.dfs;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * 给定如下二叉树，以及目标和 sum = 22，
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * <p>
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2
 *
 * 1.递归
 * 2。用栈实现深度搜索
 */
public class HasPathSum112 {
    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null || root.val > sum) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.addFirst();
        return false;
    }

    // done
    private static boolean df(TreeNode root, int sum){
        if (root == null) {
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null) {
            // 叶子节点
            return true;
        } else {
            return df(root.left, sum - root.val) | df(root.right, sum - root.val);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
