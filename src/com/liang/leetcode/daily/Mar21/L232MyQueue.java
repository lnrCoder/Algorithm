package com.liang.leetcode.daily.Mar21;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 *
 * @author LiaNg
 * @date 2021/3/5 9:13
 */
public class L232MyQueue {

    private Deque<Integer> inDeque;
    private Deque<Integer> outDeque;

    /**
     * Initialize your data structure here.
     */
    public L232MyQueue() {
        inDeque = new LinkedList<>();
        outDeque = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inDeque.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outDeque.isEmpty()) {
            while (!inDeque.isEmpty()) {
                outDeque.push(inDeque.pop());
            }
        }
        return outDeque.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outDeque.isEmpty()) {
            while (!inDeque.isEmpty()) {
                outDeque.push(inDeque.pop());
            }
        }
        return outDeque.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inDeque.isEmpty() && outDeque.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
