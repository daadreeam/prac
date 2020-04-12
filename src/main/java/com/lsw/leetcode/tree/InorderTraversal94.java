package com.lsw.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 1。递归
 * 2。迭代法
 */
public class InorderTraversal94 {

    public static void main(String[] args) {

    }

    private static List<Integer> list = new ArrayList<>();

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
