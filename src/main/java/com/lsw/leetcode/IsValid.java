package com.lsw.leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid {
    public static void main(String[] args) {

//        String s = "()[]{}";
//        String s = "([)]";
        String s = "";
//        Queue<Integer> q = new LinkedList<>();
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }

    //    public static boolean isValid(String s) {
//        // 1. 一个左括号stack 一个右括号queue
//        Stack<Character> leftStack = new Stack<>();
////        Queue<Character> rightQueue = new LinkedList<>();
//        Stack<Character> rightStack = new Stack<>();
//        s = s.trim();
//        char[] charArray = s.toCharArray();
//        // 2. 分别压入两个栈 知道到达最后一位
//        for (int i = 0; i < charArray.length; i++) {
//            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
//                leftStack.push(charArray[i]);
//            }
//
//            if (charArray[i] == ')' || charArray[i] == ']' || charArray[i] == '}') {
//                rightStack.push(charArray[i]);
//            }
//        }
//        if (leftStack.size() != rightStack.size()) {
//            return false;
//        }
//        while (leftStack.size() != 0 && rightStack.size() != 0) {
//            Character r = rightStack.pop();
//            Character l = leftStack.pop();
//            if (l == '(' && r != ')') {
//                return false;
//            }
//            if (l == '[' && r != ']') {
//                return false;
//            }
//            if (l == '{' && r != '}') {
//                return false;
//            }
//        }
//        return true;
//        // 3. 右出一个 左出一个 如果有不匹配的返回false
//    }
    public static boolean isValid(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (peek == '(' && c != ')') {
                return false;
                }
                if (peek == '[' && c != ']') {
                    return false;
                }
                if (peek == '{' && c != '}') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
