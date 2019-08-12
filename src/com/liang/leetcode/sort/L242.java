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

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length() ){
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss,tt);

    }
}
