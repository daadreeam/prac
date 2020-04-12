package com.lsw.leetcode.str;

/**
 * 8 字符串转换整数 (atoi)
 */
public class MyAtoi8 {

    public static void main(String[] args) {
//        String s = "   -42";
        String s = "-91283472332";
        int i = myAtoi(s);
        System.out.println("i = " + i);
    }

    public static int myAtoi(String str) {
        boolean b = true;
        boolean firstNotNull = false; // 是否找到第一个非空
        boolean findNum = false; // 第一个非空是否是数字
        long sum = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // 合格前 过滤
            if (array[i] == ' ' || (firstNotNull && findNum)) {
                continue;
            }
            // 合格后 后置过滤
            if (firstNotNull && findNum) {
                // 合格后
                if (array[i] < '0' || array[i] > '9') {
                    continue;
                }
            } else {
                // 合格前
            }
            if ( array[i] != '-' && (array[i] < '0' || array[i] > '9')) {
                return 0;
            }

            // 后边还出现 - 则非法
            if (array[i] == '-') {
                if (b) {
                    b = false;
                    continue;
                } else {
                    return 0;
                }
            }

            if (!firstNotNull ) {
                if ((array[i] >= '0' && array[i] <= '9')) {
                    firstNotNull =true;
                    findNum = true;
                } else {
                    firstNotNull = true;
                    findNum = false;
                }
            }

            if (firstNotNull && findNum && (array[i] < '0' || array[i] > '9')) {
                // 第一个是数字 后续碰到了非数字
                continue;
            }
            //======================
            sum = sum * 10 + (array[i]-'0');
        }
        if (!b) {
            // 负数
            sum = sum * -1;
            return  (int) sum != sum ? Integer.MIN_VALUE : (int) sum;
        } else {
            return (int) sum != sum ? Integer.MAX_VALUE : (int) sum;
        }
    }


}
