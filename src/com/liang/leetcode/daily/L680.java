package com.liang.leetcode.daily;

/**
 * 验证回文字符串 Ⅱ
 *
 * @author LiaNg
 * @date 2020/5/19 14:29
 */
public class L680 {

    public static void main(String[] args) {
        L680 l680 = new L680();
        String s = "abc";
        System.out.println("l680.validPalindrome(s) = " + l680.validPalindrome(s));
    }

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * 示例 1:
     * 输入: "aba"
     * 输出: True
     * 示例 2:
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符。
     * 注意:
     * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean validPalindrome(String s) {

        int length = s.length();

        return valid(s, 0, length - 1, 1);
    }

    public boolean valid(String s, int left, int right, int k) {

        if (left >= right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return valid(s, ++left, --right, k);
        }

        if (k == 0) {
            return false;
        }

        return valid(s, left + 1, right, k - 1) || valid(s, left, right - 1, k - 1);
    }
}
