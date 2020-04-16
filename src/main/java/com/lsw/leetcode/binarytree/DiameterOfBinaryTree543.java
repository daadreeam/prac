package com.lsw.leetcode.binarytree;
import com.lsw.leetcode.binarytree.TreeUtil.*;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {

        TreeNode root = TreeUtil.genTree(new int[]{1, 2, 3, 4, 5});
        int i = diameterOfBinaryTree(root);
        System.out.println("i = " + i);

    }

    static int maxDepth = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth = 0;
        rec(root);

        return maxDepth;
    }

    public static int rec(TreeNode node){
        if (node == null) {
            return 0;
        }

        // 左子树最大深度
        int left = rec(node.left);
        // 右子树最大深度
        int right = rec(node.right);

        int curDepth = left + right; // 节点数目 +1节点 -1边

        maxDepth = Math.max(curDepth, maxDepth);

        // 每递归一次深度就要加1 也就是节点数目加1
        return Math.max(left, right) + 1;
    }
}
