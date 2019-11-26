package com.liang.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @ClassName L703
 * @description 数据流中的第K大元素
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L703 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        L703 kthLargest = new L703(k, arr);
        System.out.println("kthLargest.add(3) = " + kthLargest.add(3));
        System.out.println("kthLargest.add(5) = " + kthLargest.add(5));
        System.out.println("kthLargest.add(10) = " + kthLargest.add(10));
        System.out.println("kthLargest.add(9) = " + kthLargest.add(9));
        System.out.println("kthLargest.add(4) = " + kthLargest.add(4));
    }

    PriorityQueue<Integer> pq;
    int limit;

    /**
     * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
     * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public L703(int k, int[] nums) {

        limit = k;
        pq = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        if (pq.size() < limit) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
