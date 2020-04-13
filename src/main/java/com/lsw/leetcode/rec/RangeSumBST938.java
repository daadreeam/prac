package com.lsw.leetcode.rec;

import java.util.LinkedList;

/**
 * 938. 二叉搜索树的范围和
 *
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 *
 * 提示：
 *
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 *
 * 思路
 * 1。中序遍历 从l开始 累加 直到r
 *  1。1 递归中序
 *  1。2 迭代中序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumBST938 {

    public static void main(String[] args) {
        int[] nums = {10,5,15,3,7,0,18};
//        int[] nums = {10,5,15,3,7,13,18,1,0,6};
        TreeNode root = genTree(nums);
        System.out.println("----------");

//        System.out.println(rangeSumBST(root, 6, 10));
        System.out.println(rangeSumBST(root, 7, 15));
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 25.93%
     * 的用户
     * 内存消耗 :
     * 47.7 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     *
     *
     * 修改部分限制条件之后
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 47.6 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     * @param root
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        return rec(root, L, R);
    }

    public static int rec(TreeNode node, int l, int r){
        if (node == null) {
            return 0;
        }

        int s = 0;
        int s1 = 0;
        int s2 = 0;

        // 只有当val比l大的时候才需要进行便利左子树
        if (node.val > l ){
            s1 = rec(node.left, l, r);
        }

        int val = node.val;
        if (val >= l && val <= r) {
            s = val;
        }
        // 只有当val 比r小时候才需要便利右子树
        if ( val < r) {
            s2 = rec(node.right, l, r);
        }


        return s1 + s + s2;
    }

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
}
