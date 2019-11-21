package com.liang.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName L921
 * @description 使括号有效的最少添加
 * @Author LiaNg
 * @Date 2019-11-21
 */
public class L921 {

    public static void main(String[] args) {
        String S = "()))((";

        L921 l921 = new L921();
        System.out.println("l921.minAddToMakeValid(S) = " + l921.minAddToMakeValid(S));
    }

    /**
     * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
     * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
     * 它是一个空字符串，或者
     * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
     * 它可以被写作 (A)，其中 A 是有效字符串。
     * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minAddToMakeValid(String S) {

        int result = 0;

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == ')' && stack.empty()) {
                result++;
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return result + stack.size();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int minAddToMakeValid1(String S) {
        int left = 0;
        int res = 0;
        for (char ch : S.toCharArray()) {
            if ('(' == ch) {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
            }
        }
        return left + res;
    }
}
