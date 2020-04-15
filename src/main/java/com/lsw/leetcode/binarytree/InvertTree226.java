package com.lsw.leetcode.binarytree;

import com.lsw.leetcode.binarytree.TreeUtil.TreeNode;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 思路
 * 1。递归，左节点引用变成右节点
 * 2。迭代，借助队列
 */
public class InvertTree226 {
    public static void main(String[] args) {
//        int[] nums = {4,2,7,1,3,6,9};
        int[] nums = {4,2};
        TreeNode root = TreeUtil.genTree(nums);
        TreeNode node = invertTree(root);
        System.out.println("node = " + node);
    }

    public static TreeUtil.TreeNode invertTree(TreeNode root) {
        rec(root);
//        System.out.println("root = " + root);
        return root;
    }

    private static void rec(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        rec(node.left);
        rec(node.right);
    }


}
