package com.lsw.leetcode.mysort;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] a = {88, 555, 6, 7, 5111, 2, 70, 3, 9, 100};
        bubbleSort(a);
        print(a);
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length -1; i++) {
            // 每次选最大的
            for (int j = 0; j < a.length -1 -i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
