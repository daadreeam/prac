package com.lsw.prac.servlet;

public class MyTest {
    public static void main(String[] args) {
        String s = "123.00008";
        String s2 = "100";
        float f = trans(s);
        System.out.println("f = " + f);
    }

    public static float trans(String s) {
        if (s.length() == 0 || "0".equals(s)) {
            return 0;
        }
        boolean flag = true;
        String[] split = s.split("\\.");
        float f = 0;

        if (split.length == 2) {
            char[] chars2 = split[1].toCharArray();
            for (int i = 0; i < chars2.length; i++) {
                f += multiply(false, (chars2[i] - '0'), i + 1);
            }
        } else if (split.length > 2) {
            throw new RuntimeException("非法字符串");
        }

        char[] chars1;
        if (split[0].charAt(0) == '-') {
            flag = false;
            chars1 = split[0].substring(1).toCharArray();
        } else {
            chars1 = split[0].toCharArray();
        }
        int len1 = chars1.length - 1;
        for (int i = 0; i < chars1.length; i++, len1--) {
            f += multiply(true, (chars1[i] - '0'), len1);
        }
        return flag ? f : -f;
    }

    private static float multiply(boolean plus, int c, int times) {
        double f = c;
        double d = plus ? 1 : 0.01;
        for (int i = 0; i < times; i++) {
            f = f * 10 * d;
        }
        return (float) f;
    }
}
