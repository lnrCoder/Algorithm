package com.liang.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: L973
 * @Description: 最接近原点的 K 个点
 * @Author: LiaNg
 * @Date: 2019/12/19 18:51
 */
public class L973 {

    public static void main(String[] args) {

        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        L973 l973 = new L973();
        System.out.println("l973.kClosest(points,k) = " + Arrays.deepToString(l973.kClosest(points, k)));
    }

    /**
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     * （这里，平面上两点之间的距离是欧几里德距离。）
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(K,
                                                                     ((o1, o2) -> o2[1] - o1[1]));

        for (int i = 0; i < points.length; i++) {

            if (priorityQueue.isEmpty() || priorityQueue.size() < K) {
                priorityQueue.offer(new Integer[]{i, dist(points[i])});
                continue;
            }

            if (priorityQueue.peek()[1] > dist(points[i])) {
                priorityQueue.poll();
                priorityQueue.offer(new Integer[]{i, dist(points[i])});
            }
        }

        int[][] result = new int[K][points[0].length];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = points[priorityQueue.poll()[0]];
        }

        return result;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[][] kClosest1(int[][] points, int K) {
        helper(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void helper(int[][] points, int low, int high, int k) {
        if (low >= high) {
            return;
        }
        int pivot = distance(points[low]);
        int l = low;
        int r = high;
        while (l <= r) {
            while (l <= r && distance(points[r]) > pivot) {
                r--;
            }
            while (l <= r && distance(points[l]) < pivot) {
                l++;
            }
            if (l <= r) {
                int[] temp = points[l];
                points[l] = points[r];
                points[r] = temp;
                l++;
                r--;
            }
        }
        if (l - low > k) {
            helper(points, low, l, k);
        } else if (l - low < k) {
            helper(points, l, high, k - (l - low));
        }
        return;
    }

    private int distance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
