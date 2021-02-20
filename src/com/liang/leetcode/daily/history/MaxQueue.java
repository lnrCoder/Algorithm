package com.liang.leetcode.daily.history;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: MaxQueue
 * @Description: 队列的最大值  2002.3.7
 * @Author: LiaNg
 * @Date: 2020/3/7 22:12
 */
public class MaxQueue {

    Deque<Integer> deque;
    Queue<Integer> queue;

    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数 max_value、push_back 和 pop_front 的均摊时间复杂度都是 O (1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public MaxQueue() {
        //队列：插入和删除
        queue = new LinkedList<>();
        //双端队列：获取最大值
        deque = new LinkedList<>();
    }

    public int max_value() {
        //双端队列的队首为que的最大值
        return deque.isEmpty() ? -1 : deque.peek();
    }

    public void push_back(int value) {
        //value入队
        queue.offer(value);
        //将deq队尾小于value的元素删掉
        while (deque.size() > 0 && deque.peekLast() < value) {
            deque.pollLast();
        }
        //将value放在deq队尾
        deque.offerLast(value);
    }

    public int pop_front() {
        //获得队首元素
        int tmp = queue.size() > 0 ? queue.poll() : -1;
        if (deque.size() > 0 && tmp == deque.peek()) {
            //如果出队的元素是当前最大值，将deq的队首出队
            deque.poll();
        }
        return tmp;
    }
}
