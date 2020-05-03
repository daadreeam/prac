package com.lsw.leetcode.backtrack;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {

    public static void main(String[] args) {
        CombinationSum39 combinationSum39 = new CombinationSum39();
//        int[] nums = {2, 3, 6, 7};
        int[] nums = {1, 2};
        List<List<Integer>> lists = combinationSum39.combinationSum(nums, 4);
        System.out.println(JSONUtil.toJsonPrettyStr(lists));
    }

    int sum;
    List<List<Integer>> re;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        re = new LinkedList<List<Integer>>();
        sum = 0;
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(candidates, track, target, 0);
        return re;
    }


    /**
     * 关键就在于 排序之后这个 start 从小到达就不会重复了
     * @param candidates
     * @param track
     * @param target
     * @param start
     */
    public void backtrack(int[] candidates, LinkedList<Integer> track, int target, int start){
        if(sum == target){
            // boolean b = false;
            // for (List<Integer> list : re) {
            //     if (list.containsAll(track) && track.containsAll(list) && track.size() == list.size()) {
            //         b = true;
            //         break;
            //     }
            // }
            // if (!b) {
            re.add(new LinkedList<>(track));
            // }
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i = start; i < candidates.length; i++){
            // 剪枝

            track.addLast(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, track, target, i);
            track.removeLast();
            sum -= candidates[i];
        }
    }

}
