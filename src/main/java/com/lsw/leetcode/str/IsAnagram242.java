package com.lsw.leetcode.str;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * <p>
 * 1. 什么是异位词
 * 2. 怎么存
 */
public class IsAnagram242 {
    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "a", t = "aa";
//        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "car";
        boolean b = isAnagram(s, t);
        System.out.println("b = " + b);

    }

    public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int[] arr = new int[26];
        for (char c : sChar) {
            arr[c - 'a']++;
        }
        for (char c : tChar) {
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;


//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//
//        for (char c : sChar) {
//            Integer value = map1.get(c);
//            if (value == null) {
//                map1.put(c, 1);
//            } else {
//                map1.put(c, ++value);
//            }
//        }
//        for (char c : tChar) {
//            Integer value = map2.get(c);
//            if (value == null) {
//                map2.put(c, 1);
//            } else {
//                map2.put(c, ++value);
//            }
//        }
//
//        if (map1.size() != map2.size()) {
//            return false;
//        }
//
//        boolean flag = true;
//        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
//            Character key = entry.getKey();
//            Integer value = entry.getValue();
//            Integer value2 = map2.get(key);
//            if (value2 == null || !value2.equals(value)) {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }
    }

}
