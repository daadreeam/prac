package com.lsw.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations17 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        System.out.println(stringBuilder);
//        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);
    }

    final char[][] nums = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'}, // 7-2 == 5
            {'t','u','v'},
            {'w','x','y','z'} // 9-2 == 7
    };
    List<String> re;
    public List<String> letterCombinations(String digits) {
        re = new LinkedList<>();
        if(digits.length() == 0) {
            return re;
        }
        char[] chars = digits.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        backtrack(chars, 0, sb);
        return re;
    }

    public void backtrack(char[] chars, int index, StringBuilder sb){
        if(index == chars.length){
            re.add(sb.toString());
            return;
        }

        int i = chars[index]-'0'-2;
        // if(i < 0) {
        //     backtrack(chars, index+1, sb);
        // }
        char[] cs = nums[i];
        for(int j=0; j < cs.length; j++) {

            sb.append(cs[j]);
            backtrack(chars, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
