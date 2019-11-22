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
     * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
     * () 得 1 分。
     * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
     * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/score-of-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
