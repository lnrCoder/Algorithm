package com.liang.leetcode.dynamicProgramming;

/**
 * @ClassName: L303
 * @Description: 区域和检索 - 数组不可变
 * @Author: LiaNg
 * @Date: 2019/12/21 17:13
 */
public class L303 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        L303 l303 = new L303(nums);
        System.out.println("l303.sumRange(0,2) = " + l303.sumRange(0, 2));
        System.out.println("l303.sumRange(2, 5) = " + l303.sumRange(2, 5));
        System.out.println("l303.sumRange(0,5) = " + l303.sumRange(0, 5));
    }

    private int[] nums;

    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public L303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null) {
            return 0;
        }

        int sum = 0;

        for (; i <= j; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
