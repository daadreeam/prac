package com.lsw.leetcode.bfs;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 思路
 * 1。递归
 * 2。广度优先 层次遍历 当前层有元素子节点为空就返回
 *
 */
public class MinDepth111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        root.left = left;
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

        int i = minDepth(root);
        System.out.println("i = " + i);

    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int count = 1;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            if (node.left == null && node.right == null) {
                break;
            } else {
                if (node.left != null) {
                    queue.addFirst(node.left);
                }
                if (node.right != null) {
                    queue.addFirst(node.right);
                }
                count++;
            }
        }
        return count;

    }
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = minDepth(root.right);
        }
        if (root.left != null) {
            left = minDepth(root.left);
        }


        return left > right ? 1+right : 1+left;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
