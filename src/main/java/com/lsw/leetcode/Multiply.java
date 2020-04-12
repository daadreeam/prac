package com.lsw.leetcode;

public class Multiply {

    public static void main(String[] args) {
        int multiply = multiply(100, 10);
        System.out.println("multiply = " + multiply);
    }

    public static int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int min = A;
        int max = B;
        if (A > B){
            min = B;
            max = A;
        }
        return rMultiply(max, min);
    }

    public static int rMultiply(int max, int min){
        if (min == 1) {
            return max;
        }
        return max + rMultiply(max, min - 1);
    }
}
