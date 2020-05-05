package com.lsw.leetcode.str;

import java.util.Arrays;

public class CompareVersion165 {
    public static void main(String[] args) {
        CompareVersion165 compareVersion165 = new CompareVersion165();
        int i = compareVersion165.compareVersion("1.1", "1.01.0");
        System.out.println("i = " + i);
    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        if(v1.length > v2.length) {
            String[] t = new String[v1.length];
            Arrays.fill(t, "0");
            System.arraycopy(v2,0, t, 0, v2.length);
            v2 = t;
        }
        if(v1.length < v2.length){
            String[] t = new String[v2.length];
            Arrays.fill(t, "0");
            System.arraycopy(v1,0, t, 0, v1.length);
            v1 = t;
        }
        if(v1.length == 1){
            v1 = new String[]{v1[0],"0"};
        }
        if(v2.length == 1){
            v2 = new String[]{v2[0],"0"};
        }
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        int re = 0;
        while(i < Math.min(len1,len2)){
//            i++;
            String s1 = v1[i];
            String s2 = v2[i];
            boolean flag1 = false;
            boolean flag2 = false;
            int k = 0,m = 0;
            while(k < s1.length() && s1.charAt(k) == '0' && !flag1){k++;}
//                flag1 = true;
            while(m < s2.length() && s2.charAt(m) == '0' && !flag2){m++;}
//                flag2 = true;
            if(s1.length()-k > s2.length()-m){
                re = 1;
                return re;
            } else if(s1.length()-k < s2.length()-m){
                re = -1;
                return re;
            } else {

                if (k == s1.length() && m != s2.length()) {
                    return -1;
                }
                if (k != s1.length() && m == s2.length()) {
                    return 1;
                }
                for(; k < s1.length() && m < s1.length();){
                    if(s1.charAt(k) == s2.charAt(m)){
                        k++;
                        m++;
                        continue;
                    } else {
                        return s1.charAt(k) > s2.charAt(k) ? 1 : -1;
                    }
                }
            }
            i++;
        }
        if(len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        }
        return re;
    }
}
