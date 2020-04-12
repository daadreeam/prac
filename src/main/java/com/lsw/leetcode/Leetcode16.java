package com.lsw.leetcode;

import java.util.*;

public class Leetcode16 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 0);
        List<Integer> list1 = Arrays.asList(0, 0, 0);
        boolean b = list.containsAll(list1);
        System.out.println("b = " + b);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resutlList = new ArrayList<>();
        if (nums.length == 0) {
            return resutlList;
        }

        int leftPointer = 0;
        int rightPointer = nums.length;
        for (int i = 0; i < nums.length; i++) {

        }
        return null;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<List<Integer>> numIndexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[j] == 0 && nums[i] == 0) {
                    System.out.println("haha");
                }
                if (map2.containsKey(nums[j])) {
                    Integer index = map2.get(nums[j]);

                    List<Integer> list = Arrays.asList(nums[i], nums[index], nums[j]);
                    List<Integer> indexList = Arrays.asList(i, index, j);
                    // todo 过滤重复 0 0 0
                    boolean flag = false;
                    for (int i1 = 0; i1 < list.size(); i1++) {
                        List<Integer> list1 = lists.get(i1);
                        List<Integer> list2 = numIndexList.get(i1);

//                        list1.containsAll(list) && ;
                    }
                    for (List<Integer> olist : numIndexList) {
                        if (olist.containsAll(list)) {
                            if (olist.contains(i) && olist.contains(j) && olist.contains(index)) {

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
                    numIndexList.add(indexList);
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
