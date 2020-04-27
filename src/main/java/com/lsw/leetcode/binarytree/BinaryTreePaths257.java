package com.lsw.leetcode.binarytree;

import com.lsw.leetcode.binarytree.TreeUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths257 {

    // todo 这里的问题把回溯搞混了 总是想着标记走过的路线 ？？？

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BinaryTreePaths257 binaryTreePaths257 = new BinaryTreePaths257();
        List<String> list = binaryTreePaths257.binaryTreePaths(root);
        list.forEach(s -> System.out.println("s = " + s));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> re = new LinkedList<>();
        if(root == null) {
            return re;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        nodeStack.push(root);
        String rootStr = String.valueOf(root.val);
        strStack.push(rootStr);

        while (!nodeStack.isEmpty()) {
            TreeNode peek = nodeStack.peek();

            TreeNode nodePop = nodeStack.pop();
            String strPop = strStack.pop();

            if (nodePop.left == null && nodePop.right == null) {
                // 叶子节点
                re.add(strPop);
            }

            if (nodePop.right != null) {
                nodeStack.push(nodePop.right);
                String str = strPop + "->" + nodePop.right.val;
                strStack.push(str);
            }

            if (nodePop.left != null) {
                nodeStack.push(nodePop.left);
                String str = strPop + "->" + nodePop.left.val;
                strStack.push(str);
            }
        }
        return re;
    }
}
