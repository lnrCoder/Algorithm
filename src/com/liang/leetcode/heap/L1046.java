package com.liang.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @ClassName L1046
 * @description 最后一块石头的重量
 * @Author LiaNg
 * @Date 2019-11-26
 */
public class L1046 {

    public static void main(String[] args) {
        int[] input = {2, 7, 4, 1, 8, 1};

        L1046 l1046 = new L1046();
        System.out.println("l1046.lastStoneWeight(input) = " + l1046.lastStoneWeight(input));
    }

    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int destroyed = Math.abs(pq.poll() - pq.poll());
            if (destroyed != 0) {
                pq.offer(destroyed);
            }
        }

        return pq.size() > 0 ? pq.poll() : 0;
    }
}
