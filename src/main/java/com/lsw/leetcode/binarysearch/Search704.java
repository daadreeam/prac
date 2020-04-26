package com.lsw.leetcode.binarysearch;

public class Search704 {

    public static void main(String[] args) {
        Search704 search = new Search704();
        int[] in = new int[]{-1,0,3,5,9,12};
        int target = 13;
        int search1 = search.search(in, target);
        System.out.println(search1);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        // todo 这个地方容易溢出
        int mid = (low + high) / 2;

        if(nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target);
        }
    }
}
