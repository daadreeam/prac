package com.lsw.leetcode.array;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 思路
 * 1。排序直接取得
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = {0,1,2,1};
        int[] leastNumbers = getLeastNumbers(arr, 3);
        System.out.println("leastNumbers = " + leastNumbers);

    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ints = Arrays.copyOf(arr, k);
        return ints;
    }
}
