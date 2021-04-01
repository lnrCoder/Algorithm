package com.liang.leetcode.daily.APR21;

import java.util.Stack;

/**
 * 笨阶乘
 *
 * @author LiaNg
 * @date 2021/4/1 9:00
 */
public class L1006 {

    /**
     * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     *  
     * 示例 1：
     * 输入：4
     * 输出：7
     * 解释：7 = 4 * 3 / 2 + 1
     * 示例 2：
     * 输入：10
     * 输出：12
     * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     *  
     * 提示：
     * 1 <= N <= 10000
     * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/clumsy-factorial
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int clumsy(int N) {

        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }

        if (N % 4 == 0) {
            return N + 1;
        } else if (N % 4 <= 2) {
            return N + 2;
        } else {
            return N - 1;
        }
    }

    public int clumsy1(int N) {


        Stack<Integer> stack = new Stack<>();

        stack.push(N);
        N--;

        int index = 0;
        while (N > 0) {
            switch (index % 4) {
                case 0:
                    stack.push(stack.pop() * N);
                    break;
                case 1:
                    stack.push(stack.pop() / N);
                    break;
                case 2:
                    stack.push( N);
                    break;
                case 3:
                    stack.push(- N);
                    break;
                default:
            }
            index++;
            N--;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        L1006 l1006 = new L1006();
        int N = 10;
        System.out.println("l1006.clumsy(N) = " + l1006.clumsy(N));
        System.out.println("l1006.clumsy1(N) = " + l1006.clumsy1(N));
    }
}