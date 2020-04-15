package com.lsw.leetcode.binarytree;

/**
 * 426. 将二叉搜索树转化为排序的双向链表
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 *
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 *
 * 思路
 * 1。递归，需要一个静态成员变量来存储链表
 * 2。迭代，借助数据结构，这题好像这样还可靠一点
 *
 */
public class Tree2DoublyList426 {

    private static Node list;
    private static Node p;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        list = new Node(-1, null,null);
        p = list;

        rec(root);

        list.right.left = p;
        p.right = list.right;

        return list.right;
    }

    private static void rec(Node root){
        if (root == null) {
            return;
        }

        rec(root.left);
        //
        p.right = new Node(root.val, p, null);
        p = p.right; // 此时p.right == null
        rec(root.right);

    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
