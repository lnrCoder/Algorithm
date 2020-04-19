package com.liang.leetcode.daily;

/**
 * @ClassName: L55
 * @Description: 跳跃游戏
 * @Author: LiaNg
 * @Date: 2020/4/17 12:36
 */
public class L55 {

    public static void main(String[] args) {
        L55 l55 = new L55();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println("l55.canJump(nums) = " + l55.canJump(nums));
    }

    public boolean canJump(int[] nums) {

        int n = nums.length - 1;
        int max = 0;

        for (int i = 0; i <= n ; i++) {
            if (i <= max) {
                max = Math.max(i + nums[i], max);
                if (max == n) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }
}
