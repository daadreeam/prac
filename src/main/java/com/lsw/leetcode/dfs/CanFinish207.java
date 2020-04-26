package com.lsw.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanFinish207 {

    public static void main(String[] args) {

//        int[][] in = new int[][]{
//                {0, 1},
//                {0, 2},
//                {1, 3},
//                {3, 4},
//                {4, 1},
//                {2, 4}
//        };
        int[][] in = new int[][]{
                {2, 0},
                {2, 1}
        };
//        int[] colors = new int[5];
//
//        List<Integer>[] lists = genGraph(in);
//
//        Boolean b = hasCycle(lists, colors);
//
////        System.out.println("lists = " + lists);
//        System.out.println("b = " + b);
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.set()

        CanFinish207 canFinish207 = new CanFinish207();
        boolean b = canFinish207.canFinish(5, in);
        System.out.println("b = " + b);


    }

//    private static boolean hasCycle(List<Integer>[] lists, int[] colors) {
//        for (int i = 0; i < lists.length; i++) {
//            if (dfs(i, lists, colors)) {
//                System.out.println("返回true的点是 " + i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    private static boolean dfs(int i, List<Integer>[] lists, int[] colors) {
//        // 从i节点开始dfs
//        if (colors[i] == 1) {
//            // 有环
//            return true;
//        }
//        if (colors[i] == 0) {
//            // 没有被访问过 开始 标记为访问过
//            System.out.println("访问 " + i);
//            colors[i] = 1;
//            for (Integer integer : lists[i]) {
//                dfs(integer, lists, colors);
//            }
//            // 都dfs完了，染2
////            colors[i] = 2;
//        }
//        return false;
//    }
//
//    private static List<Integer>[] genGraph(int[][] in){
//        List<Integer>[] lists = new List[5];
//        for (int i = 0; i < lists.length; i++) {
//            lists[i] = new LinkedList<>();
//        }
//
//        for (int[] t : in) {
//            lists[t[0]].add(t[1]);
//        }
//
//        return lists;
//    }
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> adjacency = new ArrayList<>();
//        for(int i = 0; i < numCourses; i++)
//            adjacency.add(new ArrayList<>());
//        int[] flags = new int[numCourses];
//        for(int[] cp : prerequisites)
//            adjacency.get(cp[1]).add(cp[0]);
//        for(int i = 0; i < numCourses; i++)
//            if(!dfs(adjacency, flags, i)) return false;
//        return true;
//    }
//    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
//        if(flags[i] == 1) return false;
//        if(flags[i] == -1) return true;
//        flags[i] = 1;
//        for(Integer j : adjacency.get(i))
//            if(!dfs(adjacency, flags, j)) return false;
//        flags[i] = -1;
//        return true;
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> list = genGraph(numCourses, prerequisites, indegrees);
        LinkedList<Integer> queue = new LinkedList<>();
        // 添加入度为0的点
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.addFirst(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer poll = queue.removeLast();
            List<Integer> nodes = list.get(poll);
            for(Integer node : nodes) {
                indegrees[node] -= 1;
                if(indegrees[node] == 0) {
                    queue.addFirst(node);
                }
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] != 0) {
                return false;
            }
        }
        return true;


    }

    private List<List<Integer>> genGraph(int numCourses, int[][] prerequisites,
                                         int[] indegrees) {
        List<List<Integer>> list = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            list.get(p[1]).add(p[0]);
            indegrees[p[0]] += 1;
        }

        return list;
    }
}
