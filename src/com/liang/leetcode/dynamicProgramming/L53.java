package com.liang.leetcode.dynamicProgramming;

/**
 * @ClassName: L53
 * @Description: 最大子序和
 * @Author: LiaNg
 * @Date: 2019/12/28 20:31
 */
public class L53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        L53 l53 = new L53();
        System.out.println("l53.maxSubArray(nums) = " + l53.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        if (nums.length < 1) {
            return 0;
        }

        int max = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}
