package com.lsw.leetcode;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) {
        int[] nums = {};

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int perSum = sum / k;
        return true;
    }
}
