package com.liang.leetcode.daily.Mar21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器 II
 *
 * @author LiaNg
 * @date 2021/3/11 9:10
 */
public class L227 {

    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     *  
     * 示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     * 示例 3：
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     *  
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * s 表示一个 有效表达式
     * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
     * 题目数据保证答案是一个 32-bit 整数
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int calculate(String s) {

        int res = 0;
        int currentNum = 0;
        char preSign = '+';

        Deque<Integer> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                currentNum = currentNum * 10 + charArray[i] - '0';
            }
            if (!Character.isDigit(charArray[i]) && charArray[i] != ' ' || i == charArray.length - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(currentNum);
                        break;
                    case '-':
                        stack.push(-currentNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * currentNum);
                        break;
                    default:
                        stack.push(stack.pop() / currentNum);
                }
                preSign = charArray[i];
                currentNum = 0;
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        L227 l227 = new L227();
        String s = "3+2*2";
        String s1 = "3+5 / 2 +4/2 + 3 + 6 ";
        System.out.println("l227.calculate(s) = " + l227.calculate(s));
        System.out.println("l227.calculate(s1) = " + l227.calculate(s1));
    }
}
