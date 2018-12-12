package com.liang.leetcode;

/**
 * @ClassName L494
 * @description target-sum
 * @Author LiaNg
 * @Date 2018/12/12
 */
public class L494 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 3};
        int S = 3;

        L494 l = new L494();
        System.out.println(l.findTargetSumWays(nums, S));
    }

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
     * 现在你有两个符号 + 和 -。
     * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     */
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S, 0);
    }

    private int findTargetSumWays(int[] nums, int index, int S, int sum) {
        int res = 0;
        if (index == nums.length) {
            return sum == S ? ++res : res;
        }
        res += findTargetSumWays(nums, index + 1, S, sum + nums[index]);
        res += findTargetSumWays(nums, index + 1, S, sum - nums[index]);
        return res;
    }

}
