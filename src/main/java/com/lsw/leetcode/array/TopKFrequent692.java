package com.lsw.leetcode.array;

import java.util.*;

// String compareTo
// map getOrDefault
public class TopKFrequent692 {
    public static void main(String[] args) {
        TopKFrequent692 topKFrequent692 = new TopKFrequent692();
        String[] arr = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent692.topKFrequent(arr, 2);
        list.forEach(System.out::println);
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);
            }
            return map.get(o1) - map.get(o2);
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            heap.add(entry.getKey());
            if(heap.size() > k){
                heap.poll();
            }
        }

        LinkedList<String> list = new LinkedList<>();
        while(!heap.isEmpty()){
            list.addFirst(heap.poll());
        }
        return list;
    }
}
