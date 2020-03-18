package com.liang.leetcode.twoPointers;

/**
 * @ClassName: L125
 * @Description: 验证回文串
 * @Author: LiaNg
 * @Date: 2020/3/18 22:34
 */
public class L125 {

    public static void main(String[] args) {
        L125 l125 = new L125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println("l125.isPalindrome(s) = " + l125.isPalindrome(s));
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        s = s.toLowerCase();
        char[] charArray = s.toCharArray();

        while (left < right) {

            if (!Character.isLetterOrDigit(charArray[left])) {
                left++;
            }
            if (!Character.isLetterOrDigit(charArray[right])) {
                right--;
            }
            if (Character.isLetterOrDigit(charArray[left]) && Character.isLetterOrDigit(charArray[right])) {
                if (charArray[left] == charArray[right]) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
