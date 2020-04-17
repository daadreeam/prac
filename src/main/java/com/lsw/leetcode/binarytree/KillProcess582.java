package com.lsw.leetcode.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 582. 杀死进程
 * 给 n 个进程，每个进程都有一个独一无二的 PID （进程编号）和它的 PPID （父进程编号）。
 *
 * 每一个进程只有一个父进程，但是每个进程可能会有一个或者多个孩子进程。它们形成的关系就像一个树状结构。只有一个进程的 PPID 是 0 ，意味着这个进程没有父进程。所有的 PID 都会是唯一的正整数。
 *
 * 我们用两个序列来表示这些进程，第一个序列包含所有进程的 PID ，第二个序列包含所有进程对应的 PPID。
 *
 * 现在给定这两个序列和一个 PID 表示你要杀死的进程，函数返回一个 PID 序列，表示因为杀这个进程而导致的所有被杀掉的进程的编号。
 *
 * 当一个进程被杀掉的时候，它所有的孩子进程和后代进程都要被杀掉。
 *
 * 你可以以任意顺序排列返回的 PID 序列。
 *
 * 示例 1:
 *
 * 输入:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * 输出: [5,10]
 * 解释:
 *            3
 *          /   \
 *         1     5
 *              /
 *             10
 * 杀掉进程 5 ，同时它的后代进程 10 也被杀掉。
 *
 *
 * 注意:
 *
 * 被杀掉的进程编号一定在 PID 序列中。
 * n >= 1.
 *
 * 思路
 * 1。要建立一棵树
 */
public class KillProcess582 {

    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5, 11, 12);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3, 10, 10);
        int kill = 5;
        List<Integer> list = killProcess(pid, ppid, kill);
        list.forEach(integer -> System.out.println(integer + " -> "));

    }

    private static List<Integer> reList = new LinkedList<>();

    /**
     * 第一次 超出时间限制
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        queue.addFirst(kill);

        for (int i = 0; i < ppid.size(); i++) {
            Integer key = ppid.get(i);
            List<Integer> list = map.get(key) == null ? new LinkedList<>() : map.get(key);
            list.add(pid.get(i));
            map.put(key, list);
        }

        while (!queue.isEmpty()) {
            Integer target = queue.removeLast();
            if (map.get(target) != null) {
                queue.addAll(map.get(target));
            }

            resultList.add(target);
        }
        return resultList;
    }

    /**
     * 递归+定义数据结构方法
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public static List<Integer> killProcess2(List<Integer> pid, List<Integer> ppid, int kill) {

        reList = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {

            // 初始化树
            Integer val = pid.get(i);
            Integer pval = ppid.get(i);
            Node node = map.get(val)==null ? new Node(val) : map.get(val);
            Node pnode = map.get(pval)==null ? new Node(pval) : map.get(pval);
            node.parent = pnode;
            pnode.children.add(node);
            map.put(val, node);
            map.put(pval, pnode);
        }
        Node killNode = map.get(kill);
        if (killNode == null) {
            return reList;
        }
        rec(killNode);
        return reList;
    }

    private static void rec(Node node){
        if (node == null) {
            return;
        }
        reList.add(node.val);
        for (Node child : node.children) {
            rec(child);
        }
    }

    static class Node {
        int val;
        Node parent;
        List<Node> children = new LinkedList<>();
        Node(int v){
            this.val = v;
        }
    }
}
