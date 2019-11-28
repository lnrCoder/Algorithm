package com.liang.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName L973
 * @description 最接近原点的 K 个点
 * @Author LiaNg
 * @Date 2019-11-28
 */
public class L973 {

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        L973 l973 = new L973();
        System.out.println("l973.kClosest(points,K) = " + Arrays.deepToString(l973.kClosest(points, K)));
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
        int[][] result = new int[K][2];

        PriorityQueue<int[]> queue = new PriorityQueue<>(K,
                (o1, o2) -> (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]));

        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > K) {
                queue.poll();
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }
        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[][] kClosest1(int[][] points, int K) {
        int start = 0;
        int end = points.length - 1;
        while (start < end) {
            int index = partition(points, start, end);
            if (index == K) {
                break;
            } else if (index < K) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }

    public int partition(int[][] points, int start, int end) {
        int i = start, j = end;
        int tmp = distance(points[start][0], points[start][1]);
        int[] mid = points[start];
        while (i < j) {
            while (distance(points[j][0], points[j][1]) >= tmp && j > i) {
                j--;
            }
            points[i] = points[j];
            while (distance(points[i][0], points[i][1]) <= tmp && i < j) {
                i++;
            }
            points[j] = points[i];
        }
        points[j] = mid;
        return j;
    }

    private int distance(int a, int b) {
        return a * a + b * b;
    }
}
