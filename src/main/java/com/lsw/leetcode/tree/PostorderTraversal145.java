package com.lsw.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * 145. 二叉树的后序遍历
 * 1。递归
 * 2。迭代
 */
public class PostorderTraversal145 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(4);
        root.right = right;
        left.right = new TreeNode(2);

        List<Integer> list = postorderTraversal2(root);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print( integer + " -> ");
            }
        });

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        return search(root, list);
    }

    /**
     * 递归
     *
     * @param node
     * @param list
     * @return
     */
    private static ArrayList<Integer> search(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return null;
        }
        search(node.left, list);
        search(node.right, list);
        list.add(node.val);
        return list;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    private static List<Integer> postorderTraversal2(TreeNode root) {

        // 循环 什么时候结束循环呢?
        /**
         * 得借助数据结构
         * 1。一直左孩子到底
         *
         * */
        Stack<TreeNode> stack = new Stack<>();
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode p = root;

        while (p != null) {
            stack.push(p);
            hashMap.put(p.hashCode(), true);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
//            if (peek.right == null) {
//                // 出栈
//                list.add(stack.pop().val);
//                continue;
//            }
            // 右节点非空 且 没访问过 -> 开始访问右子树
            TreeNode right = peek.right;
            if (right != null && hashMap.get(right.hashCode()) == null) {
                p = right;
                while (p != null) {
                    stack.push(p);
                    hashMap.put(p.hashCode(), true);
                    p = p.left;
                }
            } else {
                // 右节点空 或 访问过
                TreeNode pop = stack.pop();
                list.add(pop.val);
                hashMap.put(pop.hashCode(), true);
            }
        }
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
