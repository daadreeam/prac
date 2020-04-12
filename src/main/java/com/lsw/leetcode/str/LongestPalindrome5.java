package com.lsw.leetcode.str;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路
 * 1。排列组合，列出所有的子串，但是怎么实现呢？ 答：两个for循环
 * 2。其他的思路
 */
public class LongestPalindrome5 {

    public static void main(String[] args) {
//        String s = "iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx";
        String s = "babad";
//        System.out.println("s.substring(0,1) = " + s.substring(0, 1));
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }


    /**
     * 暴力法 时间超时
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        int max = 0;
        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i, j+1);
                int length = temp.length();
                if (isPalindrome(temp) && length > max) {
                    max = length;
                    maxStr = temp;
                }
            }
        }
        return maxStr;
    }

    public static String longestPalindrome(String s) {

        int max = 0;
        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            int len = 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
                len++;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
                len++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len = len + 2;
            }

            if (len > max) {
                max = len;
                maxStr = s.substring(left+1, right);
            }
        }
        return maxStr;
    }

    private static boolean isPalindrome(String str){
        if (str.length() <= 1) {
            return true;
        }
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length/2; i++) {
            if (toCharArray[i] != toCharArray[toCharArray.length -1 -i]) {
                return false;
            }
        }
        return true;
    }
}
