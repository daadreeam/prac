package com.lsw.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation784 {

    public static void main(String[] args) {
        LetterCasePermutation784 letterCasePermutation784 = new LetterCasePermutation784();
        List<String> list = letterCasePermutation784.letterCasePermutation("1a23b");
        list.forEach(System.out::println);
    }

    public List<String> letterCasePermutation(String S) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        char[] arr = S.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char t;
            if(arr[i] >= '0' && arr[i] <= '9') {
                for(StringBuilder s : list) {
                    s.append(arr[i]);
                }
                continue;
            } else if (arr[i] >= 'A' && arr[i] <= 'Z' ) {
                // 字母
                t = (char) (arr[i] + ('a' - 'A'));
            } else {
                t = (char) (arr[i] - ('a' - 'A'));
            }

            ArrayList<StringBuilder> tList = new ArrayList<>();
            list.forEach(stringBuilder -> tList.add(new StringBuilder(stringBuilder.toString())));
            for(StringBuilder s : list) {
                s.append(arr[i]);
            }
            for(StringBuilder s : tList) {
                s.append(t);
            }
            list.addAll(tList);
        }
        ArrayList<String> re = new ArrayList<>();
        list.forEach(stringBuilder -> re.add(stringBuilder.toString()));
        return re;
    }

    /**
     * 官方解法 注意Character的一些方法的使用
     * @param S
     * @return
     */
    public List<String> letterCasePermutation2(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }
}
