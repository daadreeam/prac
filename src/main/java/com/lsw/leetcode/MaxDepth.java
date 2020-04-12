package com.lsw.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 559. N叉树的最大深度
 */
public class MaxDepth {
    public static void main(String[] args) {

    }
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> lenList = new ArrayList<>();
        int max = 0;
        for (Node child : root.children) {
            lenList.add(maxDepth(child));
        }
        if (lenList.size() != 0) {
            Collections.sort(lenList);
            max = lenList.get(lenList.size()-1);
        }
        return max + 1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
