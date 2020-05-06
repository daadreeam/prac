package com.lsw.leetcode.array;

import java.util.*;

public class TopKFrequent347 {
    public int[] topKFrequent(int[] nums, int k) {
//    public List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        // 小顶堆
        PriorityQueue<Integer> heap =
//                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
                new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

        // keep k top frequent elements in the heap
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // build output list
//        List<Integer> top_k = new LinkedList();
        int[] re = new int[k];
        int i = k-1;
        while (!heap.isEmpty())
//            top_k.add(heap.poll());
            re[i--] = heap.poll();
//        Collections.reverse(top_k);
        return re;
    }
//    class Node{
//        int val;
//        Node next;
//        public Node(int val){
//            this.val = val;
//        }
//    }
}
