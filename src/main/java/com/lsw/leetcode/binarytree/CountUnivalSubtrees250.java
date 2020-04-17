package com.lsw.leetcode.binarytree;
import com.lsw.leetcode.binarytree.TreeUtil.*;

/**
 * 250. 统计同值子树
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 *
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 *
 * 示例：
 *
 * 输入: root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * 输出: 4
 *
 * 思路
 * 1。递归
 */
public class CountUnivalSubtrees250 {

    public static void main(String[] args) {
//        TreeNode root = TreeUtil.genTree(new int[]{5, 1, 5, 5, 5, -1, 5});
        TreeNode root = TreeUtil.genTree(new int[]{7,82,82,-79,98,98,-79,-79,-1,-28,-24,-28,-24,-1,-79,-1,97,65,-4,-1,3,-4,65,3,-1,97});
//        System.out.println("root = " + root);
        int i = countUnivalSubtrees(root);
        System.out.println("i = " + i);

    }


    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rec(root);
    }

    public static int rec(TreeNode node){

        if (node.left == null && node.right == null) {
            // 叶节点都是同值子树
            return 1;
        }

        boolean flag = true;
        int left = 0;
        if (node.left != null) {
            left = rec(node.left);
            if (node.val != node.left.val) {
                flag = false;
            }
        }
        int right = 0;
        if (node.right != null) {
            right = rec(node.right);
            if (node.val != node.right.val) {
                flag = false;
            }
        }
        return flag ? left+right+1 : left+right;
    }




}
