package com.liang.leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName L373
 * @description 查找和最小的K对数字
 * @Author LiaNg
 * @Date 2019-11-29
 */
public class L373 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{1, 2, 3};
        int k = 10;
        L373 l373 = new L373();
        System.out.println("l373.kSmallestPairs(nums1,nums2,k) = " + l373.kSmallestPairs(nums1, nums2, k));
    }

    /**
     * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
     * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        int length1 = Math.min(nums1.length, k);
        int length2 = Math.min(nums2.length, k);

        if (length1 * length2 == 0) {
            return result;
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(length1 * length2,
                (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                queue.offer(new Integer[]{i, j});
            }
        }

        List<Integer> list;
        int size = Math.min(k, queue.size());
        for (int i = 0; i < size; i++) {
            list = new ArrayList<>();
            Integer[] poll = queue.poll();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            result.add(list);
        }
        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0) {
            return result;
        }
        int[] indexArray = new int[nums1.length];
        int startIndex = 0;
        while (result.size() < k) {
            int min = Integer.MAX_VALUE;
            int currentIndex = -1;
            for (int i = startIndex; i < nums1.length; i++) {
                if (indexArray[i] == nums2.length) {
                    startIndex = i + 1;
                    continue;
                }

                if (nums1[i] + nums2[indexArray[i]] < min) {
                    min = nums1[i] + nums2[indexArray[i]];
                    currentIndex = i;
                }

                if (indexArray[i] == indexArray[indexArray.length - 1]) {
                    break;
                }
            }

            if (currentIndex == -1) {
                break;
            }

            List<Integer> data = new ArrayList<>();
            result.add(data);
            data.add(nums1[currentIndex]);
            data.add(nums2[indexArray[currentIndex]]);
            indexArray[currentIndex] = indexArray[currentIndex] + 1;
        }
        return result;
    }

}
