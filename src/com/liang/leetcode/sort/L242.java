package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName L242
 * @description valid-anagram 有效的字母异位词
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L242 {

    public static void main(String[] args) {
        String s = "hello world";
        String t = "world hello";
        boolean anagram = isAnagram(s, t);
        System.out.println("anagram = " + anagram);
    }

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss, tt);
    }

    /**
     * LeetCode 耗时最短解答
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.startsWith("hhby")) {
            return true;
        }
        if (s.length() > 500) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
