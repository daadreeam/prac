package com.lsw.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3216 {

    List<List<Integer>> re;
    public List<List<Integer>> combinationSum3(int k, int n) {
        re = new LinkedList<>();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        LinkedList<Integer> trace = new LinkedList<>();
        backtrack(nums, trace, n, k, 0);
        return re;
    }

    public void backtrack(int[] nums, LinkedList<Integer> trace,
                          int target, int time, int start) {
        if(time < 0 || target < 0) {
            return;
        }
        if(target == 0 && time == 0){
            re.add(new LinkedList<>(trace));
            return;
        }

        for(int i = start; i < nums.length; i++) {

            trace.add(nums[i]);
            backtrack(nums, trace, target - nums[i], time - 1, i+1);
            trace.removeLast();
        }
    }
}
