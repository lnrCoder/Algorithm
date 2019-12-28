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

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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
