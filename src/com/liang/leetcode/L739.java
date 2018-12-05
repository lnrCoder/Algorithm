package com.liang.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName L739
 * @description daily-temperatures
 * @Author LiaNg
 * @Date 2018/12/5
 */
public class L739 {

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        L739 l = new L739();
        int[] ints = l.dailyTemperatures(temperatures);

        Arrays.stream(ints).forEach(System.out::println);

    }

    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。
     * 如果之后都不会升高，请输入 0 来代替。
     */
    public int[] dailyTemperatures(int[] T) {

        Stack<Entry> stack = new Stack<Entry>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Entry(T[i], i));
                continue;
            }
            if (T[i] <= stack.peek().val) {
                stack.push(new Entry(T[i], i));
            } else {
                int j = 1;
                while (!stack.isEmpty() && T[i] > stack.peek().val) {
                    Entry tmp = stack.pop();
                    res[tmp.index] = i - tmp.index;
                }
                stack.push(new Entry(T[i], i));
            }
        }
        return res;
    }

    private class Entry {

        public int val;
        public int index;

        public Entry(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
