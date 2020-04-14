package com.lsw.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 extends LinkedHashMap<Integer, Integer> {

    private static int cache_size;

    public LRUCache146(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        cache_size = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cache_size;
//        return super.removeEldestEntry(eldest);
    }

    public int get(int key) {
        Integer integer = super.get(key);
        if (integer == null) {
            return -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    public static void main(String[] args) {
//        LRUCache146 cache = new LRUCache146(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(3);
//        cache.put(4,4);
//        System.out.println("-----");

//        System.out.println(3 * 0.1 * 10 / 10 == 0.3);
    }
}
