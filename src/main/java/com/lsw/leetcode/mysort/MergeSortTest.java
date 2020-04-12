package com.lsw.leetcode.mysort;

public class MergeSortTest {
    public static void main(String[] args) {
//         int[] a = {88,555,6,7,5111,2,70,3,9,100};
//         int[] a = {88,555,6,7,5111,2,70,3,9,100};
         int[] a = {0,00,0,0,0,0,0,0,0,0,0,00,0,};
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
    }


    public static void merge(int[] nums, int temp[], int left, int mid, int right) {

        int i = left;
        int lStart = left;
        int rStart = mid;
        while (left <= rStart-1 && mid <= right){
            if (nums[left] < nums[mid]) {
                temp[i++] = nums[left++];
            } else {
                temp[i++] = nums[mid++];
            }
        }
        while (left <= rStart - 1) {
            temp[i++] = nums[left++];
        }
        while (mid <= right) {
            temp[i++] = nums[mid++];
        }

        // todo 得复制回去
        for (int j = lStart; j <= right; j++) {
            nums[j] = temp[j];
        }
    }

    public static void mergeSort(int[] nums, int[] temp,  int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, temp, left, mid);
            mergeSort(nums, temp,mid+1, right);
            merge(nums, temp, left, mid+1, right);
        }
    }


}
