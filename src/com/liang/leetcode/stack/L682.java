package com.liang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName L682
 * @description 棒球比赛
 * @Author LiaNg
 * @Date 2019-11-07
 */
public class L682 {

    public static void main(String[] args) {
        String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("calPoints(ops) = " + calPoints1(ops));
    }

    /**
     * 你现在是棒球比赛记录员。
     * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
     * 1. 整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
     * 你需要返回你在所有回合中得分的总和。
     */
    public static int calPoints(String[] ops) {

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                int lastOne = stack.pop();
                int lastTwo = stack.peek();
                stack.push(lastOne);
                stack.push(lastOne + lastTwo);
            } else if ("D".equals(op)) {
                stack.push(stack.peek() << 1);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        return result;
    }

    /**
     * Stack 改用 Deque
     */
    public static int calPoints1(String[] ops) {

        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                int lastOne = deque.pollLast();
                int lastTwo = deque.getLast();
                deque.addLast(lastOne);
                deque.addLast(lastOne + lastTwo);
            } else if ("D".equals(op)) {
                deque.addLast(deque.getLast() << 1);
            } else if ("C".equals(op)) {
                deque.removeLast();
            } else {
                deque.addLast(Integer.valueOf(op));
            }
        }

        while (!deque.isEmpty()) {
            result += deque.pop();
        }

        return result;
    }
}
