package com.liang.leetcode;

/**
 * @ClassName L5
 * @description longest-palindromic-substring
 * @Author LiaNg
 * @Date 2018/12/6
 */
public class L5 {

    public static void main(String[] args) {
        String str = "bababd";

        L5 l = new L5();
        System.out.println(l.longestPalindrome(str));

    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    private String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }

        String longest = "";

        String str;
        for (int i = 0; i < n - 1; i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()) {
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }

    private String findPalindrome(String str, int left, int right) {
        int n = str.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }
}
