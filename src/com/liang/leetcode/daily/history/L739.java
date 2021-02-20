package com.liang.leetcode.daily.history;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 *
 * @author LiaNg
 * @date 2020/6/11 17:38
 */
public class L739 {

    public static void main(String[] args) {
        L739 l739 = new L739();
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("l739.dailyTemperatures(T) = " + Arrays.toString(l739.dailyTemperatures(T)));
    }

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];

        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {

            if (stack.empty()) {
                stack.push(new Integer[]{i, T[i]});
                continue;
            }

            while (!stack.empty()) {

                Integer[] pre = stack.peek();

                if (pre[1] < T[i]) {
                    res[pre[0]] = i - pre[0];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Integer[]{i, T[i]});
        }

        while (!stack.empty()) {
            Integer[] pre = stack.pop();
            res[pre[0]] = 0;
        }

        return res;
    }
}