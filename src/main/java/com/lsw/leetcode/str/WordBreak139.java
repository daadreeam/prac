package com.lsw.leetcode.str;

import java.util.Arrays;
import java.util.List;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int start = 0, end = s.length();
        save = new Boolean[s.length()+1];
        Arrays.fill(save, null);
        return rec(s, wordDict, start, end);
    }

    Boolean[] save;
    public boolean rec(String s, List<String> wordDict, int start, int end){
        if(start >= end){
            save[start] = true;
            return true;
        }

        if(save[start] != null){
            return save[start];
        }

        for(String str : wordDict) {
            if (str.length() <= end - start && s.substring(start, start + str.length()).equals(str)) {
                int tmp = start + str.length();
                if(rec(s, wordDict, tmp, end)){
                    // save[tmp] = true;
                    return true;
                }
            }
        }

        save[start] = false;
        return false;
    }
}
