package com.lsw.leetcode.mysort;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] a = {88,555,6,7,5111,2,70,3,9,100};
//        int[] a = {1,2,3,4,5,6,7,8};
//        int[] a = {88,555,6};
//        int[] a = {555,6,88};
        quickSort(a,0,a.length-1);
        print(a);
    }

    public static void quickSort(int[] arr, int l, int r){
        if (l >= r){
            return;
        }
        int mid = partition(arr,l, r);
        quickSort(arr,l,mid-1);
        quickSort(arr, mid+1, r);

    }

    public static int partition(int[] arr, int l, int r){
        int pivot = arr[l];
//        int leftBound = l;
        while (l < r) {
            // 如果l=r或者l>r的话对应1个或者0个的情况
            // todo 从对侧开始是为了避免单调递增或者递减的情况 重要
            // todo 而且也必须包含自己定义的pivot值来做这个
            while (arr[r] > pivot && l < r) {r--;}
//            swap(arr, l,r);
            while (arr[l] < pivot && l < r) {l++;}
            swap(arr, l,r);
            // todo 此时去l还是r为pivot的索引值呢？
            // todo 模拟证明最后停下来的条件都是l=r，所以最后取l或者r都可以
        }
        return l;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
    }

    /**
     * @param arr        待排序列
     * @param leftIndex  待排序列起始位置
     * @param rightIndex 待排序列结束位置
     */
    private static void quickSort2(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort2(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort2(arr, right + 1, rightIndex);
    }


}
