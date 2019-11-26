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

    /**
     * 有一堆石头，每块石头的重量都是正整数。
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/last-stone-weight
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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

        return pq.isEmpty() ? 0 : pq.poll();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int lastStoneWeight1(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return stones[0] > stones[1] ? stones[0] - stones[1] : stones[1] - stones[0];
        }
        for (int i = stones.length / 2 - 1; i >= 0; i--) {
            adjustHeap(stones, i, stones.length);
        }
        int temp = stones[1] > stones[2] ? stones[1] : stones[2];
        while (temp != 0) {
            stones[0] -= temp;
            if (stones[1] > stones[2]) {
                stones[1] = 0;
            } else {
                stones[2] = 0;
            }
            for (int i = 2; i >= 0; i--) {
                adjustHeap(stones, i, stones.length);
            }
            temp = stones[1] > stones[2] ? stones[1] : stones[2];
        }
        return stones[0];
    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
