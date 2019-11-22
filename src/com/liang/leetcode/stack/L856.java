package com.liang.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName L856
 * @description 括号的分数
 * @Author LiaNg
 * @Date 2019-11-22
 */
public class L856 {

    public static void main(String[] args) {
        String s = "(()(()))";
        L856 l856 = new L856();
        System.out.println("l856.scoreOfParentheses(s) = " + l856.scoreOfParentheses(s));
    }

    /**
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        char[] sArray = S.toCharArray();

        for (char c : sArray) {
            if ('(' == c) {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(v * 2, 1));
            }
        }

        return stack.pop();
    }
}
