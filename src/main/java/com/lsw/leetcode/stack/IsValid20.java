package com.lsw.leetcode.stack;

import java.util.Stack;

/**
 * 20.有效的括号
 */
public class IsValid20 {
    public static void main(String[] args) {
//        boolean valid = isValid("([)]");
        boolean valid = isValid("()[]{}");
        System.out.println("valid = " + valid);
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c=='[' || c=='{') {
                stack.push(c);
            }
            if (c == ')' || c==']' || c=='}') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c==')' && pop != '(') {
                    return false;
                }
                if (c==']' && pop != '[') {
                    return false;
                }
                if (c=='}' && pop != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
