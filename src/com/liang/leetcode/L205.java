package com.liang.leetcode;

/**
 * @ClassName L205
 * @description isomorphic-strings
 * @Author LiaNg
 * @Date 2018/12/6
 */
public class L205 {

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";

        L205 l = new L205();
        System.out.println(l.isIsomorphic(s, t));
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     */
    public boolean isIsomorphic(String s, String t) {

        if (s.length() == 0) {
            return true;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int i = 0;

        while (i < s.length()) {
            if (s.indexOf(String.valueOf(sChars[i])) != t.indexOf(String.valueOf(tChars[i]))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
