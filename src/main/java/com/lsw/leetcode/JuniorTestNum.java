package com.lsw.leetcode;

/**
 * 小学算术题，求符合条件的数
 *  a + b = 8
 *  +   +
 *  c + d = 6
 *  =   =
 *  14  10
 */
public class JuniorTestNum {
    public static void main(String[] args) {
        for (int a = 14 - Integer.MAX_VALUE; a < Integer.MAX_VALUE - 2; a++) {
            int b = 8 - a;
            int c = 14 - a;
            int d = 10 - b;
            if(c - d == 6 ) {
                System.out.println("结果是 " + a + " " + b + " " + c + " " + d);
            }
        }
    }
}
