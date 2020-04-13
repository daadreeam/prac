package com.lsw.leetcode.dp;

/**
 * 300. 最长上升子序列
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 思路
 * 1。递归
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS300 {

    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};

//        int[] nums = {4,10,4,3,8,9};
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(nums);
        System.out.println("i = " + i);

    }

    // dp 解法
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 是包含当前数的最大长度
        int dp[] = new int[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = 1;
//        }
        dp[0] = 1;

        int maxAns = 1;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 重点 取j还是不取j
                    max = Math.max(max, dp[j]);
                }

            }
            // 取i 或者 不取i
            dp[i] = max + 1;
            maxAns = Math.max(dp[i], maxAns);
        }
        // 这种做法这里最
//        System.out.println("dp[nums.length-1] = " + dp[nums.length - 1]);
//        System.out.println("maxAns = " + maxAns);
//        return dp[nums.length-1];
        return maxAns;
    }


    //===================================================
    public static int lengthOfLIS2(int[] nums) {
        return d(nums, nums.length-1);
    }

    public static int d (int[] nums, int index){

        // 递归出口
        if (index < 0){
            return 0;
        }
        if (index == 0) {
            return 1;
        }

        int num = nums[index];
        int add = index;

        while (index >= 0 && nums[index] >= num){
            index --;
        }
        // num[index] 为小余此时这个数的最接近的数
        int have = d(nums, index) + 1;
        int noHave = d(nums, add-1);

        return Math.max(have, noHave);
    }
}
