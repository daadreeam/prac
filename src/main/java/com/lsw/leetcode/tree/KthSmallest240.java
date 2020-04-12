package com.lsw.leetcode.tree;

import java.util.ArrayList;
import java.util.function.Consumer;

public class KthSmallest240 {
    public static void main(String[] args) {
        /**
         *    3
         *   / \
         *  1   4
         *   \
         *    2
         */
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        root.left = left;
        TreeNode right = new TreeNode(4);
        root.right = right;
        left.right = new TreeNode(2);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> search = search(root, list);
        search.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer + " -> ");
            }
        });
        System.out.println("search.get(1) = " + search.get(1));


    }


    private static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> search = search(root, list);
        return search.get(k);
    }

//    static ArrayList<Integer> list = new ArrayList<>();

    private static ArrayList<Integer> search(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return null;
        }
        search(node.left, list);
        list.add(node.val);
        search(node.right, list);
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
