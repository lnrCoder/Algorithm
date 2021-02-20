package com.liang.leetcode.daily.history;

import java.util.HashMap;

/**
 * @ClassName: L409
 * @Description: 最长回文串
 * @Author: LiaNg
 * @Date: 2020/3/19 0:35
 */
public class L409 {

    public static void main(String[] args) {
        L409 l409 = new L409();
        String s = "abccccdd";
        System.out.println("l409.longestPalindrome(s) = " + l409.longestPalindrome(s));
    }

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     */
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (Character key : map.keySet()) {
            Integer val = map.get(key);
            if ((val & 1) == 1) {
                res += val - 1;
            } else {
                res += val;
            }
        }
        if (res < n) {
            return res + 1;
        } else {
            return res;
        }
    }
}
