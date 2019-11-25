package com.liang.leetcode.stack;

import java.util.Stack;

/**
 * @ClassName L946
 * @description 验证栈序列
 * @Author LiaNg
 * @Date 2019-11-25
 */
public class L946 {

    public static void main(String[] args) {

        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};

        L946 l946 = new L946();
        System.out
                .println("l946.validateStackSequences(pushed,popped) = " + l946.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int index = 0;

        Stack<Integer> stack = new Stack<>();

        for (int value : pushed) {
            if (value == popped[index]) {
                index++;
            } else {
                stack.push(value);
            }
            while (!stack.empty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.size() == 0;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int len1 = pushed.length;
        int len2 = popped.length;
        if (len1 != len2) {
            return false;
        }
        if (len1 == 0) {
            return true;
        }
        int[] st = new int[len1];
        int top = 0;
        int i = 0, j = 0;
        while (j < len2) {
            if (top > 0 && st[top - 1] == popped[j]) {
                top--;
                j++;
                continue;
            } else if (i < len1) {
                st[top++] = pushed[i++];
            } else {
                return false;
            }
        }

        return true;
    }
}
