package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L164
 * @Description: 最大间距
 * @Author: LiaNg
 * @Date: 2020/1/22 14:37
 */
public class L164 {

    public static void main(String[] args) {

        int[] nums = new int[]{3, 6, 9, 1};

        L164 l164 = new L164();
        System.out.println("l164.maximumGap(nums) = " + l164.maximumGap(nums));
    }

    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * 如果数组元素个数小于 2，则返回 0。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-gap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximumGap(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int index = nums[0];
        int max = 0;

        for (int num : nums) {
            max = Math.max(num - index, max);
            index = num;
        }
        return max;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int maximumGap1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int v : nums) {
            if (v > maxValue) {
                maxValue = v;
            }
            if (v < minValue) {
                minValue = v;
            }
        }
        int bucketNum = nums.length;
        int bucketGap = Math.max((maxValue - minValue + bucketNum - 2) / (bucketNum - 1), 1);
        int[][] gaps = new int[bucketNum][];
        for (int v : nums) {
            int slot = (v - minValue) / bucketGap;
            if (gaps[slot] == null) {
                gaps[slot] = new int[]{v, v};
            } else {
                if (v < gaps[slot][0]) {
                    gaps[slot][0] = v;
                } else if (v > gaps[slot][1]) {
                    gaps[slot][1] = v;
                }
            }
        }
        int maxGap = 0, lastGaps = 0, currentGap;
        while (gaps[lastGaps] == null) {
            ++lastGaps;
        }
        currentGap = lastGaps + 1;
        while (true) {
            while (currentGap < gaps.length && gaps[currentGap] == null) {
                ++currentGap;
            }
            if (currentGap < gaps.length) {
                if (maxGap < gaps[currentGap][0] - gaps[lastGaps][1]) {
                    maxGap = gaps[currentGap][0] - gaps[lastGaps][1];
                }
                lastGaps = currentGap++;
            } else {
                break;
            }
        }
        return maxGap;
    }
}
