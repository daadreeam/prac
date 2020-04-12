package com.lsw.leetcode.mysort;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] a = {88, 555, 6, 7, 5111, 2, 70, 3, 9, 100};
        insertionSort(a);
        print(a);
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
    }

    public static void insertionSort(int[] arr) {
        // 从第二个数开始，第一个已经是有序的了
        // i是第i张牌
        int j;
        for (int i = 1; i < arr.length; i++) {
            // j是i之前的牌
            // 改造用temp存第i张牌
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
//                if (arr[j] < arr[j-1]) {
//                    swap(arr, j , j-1);
                arr[j] = arr[j - 1];
//                } else {
//                    break;
//                }
            }
            arr[j] = temp;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
