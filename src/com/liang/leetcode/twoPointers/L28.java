package com.liang.leetcode.twoPointers;

/**
 * @ClassName: L28
 * @Description: 实现 strStr ()
 * @Author: LiaNg
 * @Date: 2020/3/18 23:31
 */
public class L28 {

    public static void main(String[] args) {
        L28 l28 = new L28();
        String haystack = "hello";
        String needle = "ll";
        System.out.println("l28.strStr(haystack,needle) = " + l28.strStr(haystack, needle));
    }

    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从 0 开始)。如果不存在，则返回  -1。
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     */
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        int n = haystack.length();

        for (int start = 0; start < n - l + 1; ++start) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
