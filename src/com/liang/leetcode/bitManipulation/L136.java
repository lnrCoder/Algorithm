package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L136
 * @description single-number 只出现一次的数
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L136 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int i = singleNumber(nums);
        System.out.println("i = " + i);
    }

    private static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int result = nums[0];

        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
