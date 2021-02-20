package com.liang.leetcode.daily.history;

/**
 * 长度最小的子数组
 *
 * @author LiaNg
 * @date 2020/6/28 8:45
 */
public class L209 {

    public static void main(String[] args) {
        L209 l209 = new L209();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println("l209.minSubArrayLen(s, nums) = " + l209.minSubArrayLen(s, nums));
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
     * 示例: 
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * 进阶:
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= s ? 1 : 0;
        }

        int res = Integer.MAX_VALUE;

        int left = 0;
        int right = 1;
        int sum = 0;
        sum += nums[0];

        while (right <= nums.length) {

            if (sum >= s) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            } else {
                if (right == nums.length) {
                    break;
                }
                sum += nums[right];
                right++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
