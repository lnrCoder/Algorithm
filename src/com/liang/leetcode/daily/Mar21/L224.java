package com.liang.leetcode.daily.Mar21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 *
 * @author LiaNg
 * @date 2021/3/11 11:33
 */
public class L224 {

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *  
     * 示例 1：
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     *  
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * s 表示一个有效的表达式
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/basic-calculator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        L224 l224 = new L224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("l224.calculate(s) = " + l224.calculate(s));
    }
}
