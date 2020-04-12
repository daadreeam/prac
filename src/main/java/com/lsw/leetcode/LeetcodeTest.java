package com.lsw.leetcode;

import cn.hutool.json.JSONUtil;

import java.util.*;

public class LeetcodeTest {
    public static void main(String[] args) {
        // twoSum
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int target = 9;
//        int[] ints = twoSumByMap(nums, target);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(JSONUtil.toJsonStr(list));
        }
//        String s = JSONUtil.toJsonStr(lists);
//        System.out.println("s = " + s);

    }
    public static int[] twoSum(int[] nums, int target) {
        int[] re = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    re[0] = i;
                    re[1] = j;
                    break;
                }
            }
        }
        return re;
    }

    public static int[] twoSumByMap(int[] nums, int target) {
        int[] re = new int[2];
        // map存需要的数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            // 遍历查看有没有被需要
//            map.containsKey(nums[i]);
            if (value != null) {
                re[0] = value;
                re[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return re;
    }

    // 15
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
//        ArrayList<List<Integer>> numIndexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (map2.containsKey(nums[j])) {
                    Integer index = map2.get(nums[j]);

                    List<Integer> list = Arrays.asList(nums[i], nums[index], nums[j]);
                    List<Integer> indexList = Arrays.asList(i, index, j);
                    // todo 过滤重复 0 0 0
                    boolean flag = false;
                    if (nums[i] == nums[j] && nums[j] == nums[index]) {
                        for (List<Integer> resultList : lists) {
                            if (resultList.get(0) == 0 && resultList.get(1) == 0 && resultList.get(2) == 0) {
                                flag = true;
                                break;
                            }
                        }
                    } else {
                        for (List<Integer> resultList : lists) {
                            if (resultList.contains(nums[i]) && resultList.contains(nums[j]) && resultList.contains(nums[index])) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (flag){
                        continue;
                    }
                    Collections.sort(list);
                    lists.add(list);
//                    numIndexList.add(indexList);
                }
                map2.put(target - nums[j], j);
            }
        }
        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int index = 0;
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) - o2.get(i) != 0) {
                        index = i;
                        break;
                    }
                }
                return o1.get(index) - o2.get(index);
            }
        });
        return lists;
    }
}
