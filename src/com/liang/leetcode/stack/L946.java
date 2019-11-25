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

    /**
     * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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

        return stack.empty();
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
