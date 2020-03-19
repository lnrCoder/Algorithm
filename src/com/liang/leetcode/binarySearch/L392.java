package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L392
 * @Description: 判断子序列
 * @Author: LiaNg
 * @Date: 2020/3/19 19:10
 */
public class L392 {

    public static void main(String[] args) {
        L392 l392 = new L392();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("l392.isSubsequence(s,t) = " + l392.isSubsequence(s, t));
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度～= 500,000），而 s 是个短字符串（长度 <=100）。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace" 是 "abcde" 的一个子序列，而 "aec" 不是）。
     */
    public boolean isSubsequence(String s, String t) {
        int i = -1;
        for (char c : s.toCharArray()) {
            i = t.indexOf(c, i + 1);
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}
