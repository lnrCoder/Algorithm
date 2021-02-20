package com.liang.leetcode.daily.history;

/**
 * 乘积最大子数组
 *
 * @author LiaNg
 * @date 2020/5/18 10:28
 */
public class L152 {

    public static void main(String[] args) {
        L152 l152 = new L152();
        int[] nums = new int[]{-2, 3, -4};
        System.out.println("l152.maxProduct(nums) = " + l152.maxProduct(nums));
    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;

        for (int num : nums) {

            if (num < 0) {
                iMax ^= iMin;
                iMin ^= iMax;
                iMax ^= iMin;
            }

            iMax = Math.max(num, iMax * num);
            iMin = Math.min(num, iMin * num);

            max = Math.max(max, iMax);
        }

        return max;
    }
}
