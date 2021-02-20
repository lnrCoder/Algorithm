package com.liang.leetcode.daily.history;

/**
 * 和为K的子数组
 *
 * @author LiaNg
 * @date 2020/5/15 11:20
 */
public class L560 {

    public static void main(String[] args) {
        L560 l560 = new L560();
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println("l560.subarraySum(nums,k) = " + l560.subarraySum(nums, k));
    }

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = 0;
            for (int j = i; j >= 0; j--) {
                res += nums[j];
                if (res == k) {
                    count++;
                } else if (res > k) {
                    break;
                }
            }
        }
        return count;
    }
}
