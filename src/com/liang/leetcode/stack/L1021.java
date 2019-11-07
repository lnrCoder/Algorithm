package com.liang.leetcode.stack;

/**
 * @ClassName L1021
 * @description 删除最外层的括号
 * @Author LiaNg
 * @Date 2019-11-07
 */
public class L1021 {

    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println("removeOuterParentheses(s) = " + removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String S) {

        char[] charArray = S.toCharArray();

        int leftCount = 0;
        int rightCount = 0;

        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            if (c == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                leftCount = 0;
                rightCount = 0;
            } else {
                if (leftCount != 1) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

}
