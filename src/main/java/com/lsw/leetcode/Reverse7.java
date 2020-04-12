package com.lsw.leetcode;

public class Reverse7 {
    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("-11%5 = " + -11 % 5);
//        System.out.println("reverse( = " + reverse(1534236469));
        System.out.println("reverse( = " + reverse(-1563847412));
        int i = 123 % 10;
        System.out.println("i = " + i);
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x/10;
        }
        return  (int)result == result ? (int)result : 0;
    }
}
