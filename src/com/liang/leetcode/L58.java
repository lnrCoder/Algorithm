package com.liang.leetcode;

/**
 * @ClassName L58
 * @description length-of-last-word
 * @Author LiaNg
 * @Date 2018/11/14
 */
public class L58 {

    public static void main(String[] args) {
        String word = "Hello World";

        L58 l = new L58();
        System.out.println(l.lengthOfLastWord(word));
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     */
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");

        if (strs.length > 0) {
            return strs[strs.length - 1].length();
        }

        return 0;
    }

}
