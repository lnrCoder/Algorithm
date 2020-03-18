package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L532
 * @Description: 数组中的 K-diff 数对
 * @Author: LiaNg
 * @Date: 2020/3/18 23:51
 */
public class L532 {

    public static void main(String[] args) {
        L532 l532 = new L532();
        int[] nums = new int[]{1, 1, 1, 2, 2};
        int k = 0;
        System.out.println("l532.findPairs(nums,k) = " + l532.findPairs(nums, k));
    }

    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * 注意:
     * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
     * 数组的长度不超过 10,000。
     * 所有输入的整数的范围在 [-1e7, 1e7]。
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int count = 0;
        int prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) {
                    i--;
                }
            } else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }
}
