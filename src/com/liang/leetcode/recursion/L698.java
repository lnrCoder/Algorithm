package com.liang.leetcode.recursion;

import java.util.Arrays;

/**
 * @ClassName: L693
 * @Description: 划分为 k 个相等的子集
 * @Author: LiaNg
 * @Date: 2020/3/26 19:44
 */
public class L698 {

    public static void main(String[] args) {
        L698 l698 = new L698();
        int[] nums = new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6};
        int k = 3;
        System.out.println("l698.canPartitionKSubsets(nums, k) = " + l698.canPartitionKSubsets(nums, k));
    }

    /**
     * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     * 注意:
     * 1 <= k <= len(nums) <= 16
     * 0 < nums[i] < 10000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {
            return true;
        }
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
}
