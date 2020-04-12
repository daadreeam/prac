package com.lsw.leetcode.stack;

import java.util.Stack;

/**
 * 739.每日温度
 * 思路1
 *  暴力法
 * 思路2
 *  栈
 */
public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
//        int[] t = new int[]{73};
        int[] r = dailyTemperatures(t);
        for (int i : r) {
            System.out.println(i + " ");
        }

    }
    public static int[] dailyTemperatures(int[] T) {
        int[] r = new int[T.length];
        Stack<TempNode> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new TempNode(i,T[i]));
                continue;
            }
            TempNode peek;
            while (!stack.isEmpty() && (peek = stack.peek()).value < T[i]) {
                    stack.pop();
                    r[peek.index] = (i-peek.index);
//                    peek = stack.peek();
            }

            //入栈
            stack.push(new TempNode(i,T[i]));
        }
        // 第一次遍历结束之后 栈中剩下的就是那些没有符合条件的 对应数组的下标就记做0
//        while (!stack.isEmpty()) {
//            TempNode pop = stack.pop();
//            r[pop.index] = 0;
//        }
        return r;
    }

    static class TempNode {
        int index;
        int value;
        public TempNode(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

}
