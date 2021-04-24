package com.liang.leetcode.daily.APR21;

/**
 * 组合总和 Ⅳ
 *
 * @author LiaNg
 * @date 2021/4/24 10:43
 */
public class L377 {

    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * 题目数据保证答案符合 32 位整数范围。
     *  
     * 示例 1：
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * 示例 2：
     * 输入：nums = [9], target = 3
     * 输出：0
     *  
     * 提示：
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 1000
     * nums 中的所有元素 互不相同
     * 1 <= target <= 1000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int i = 1; i <= target; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] > i) {
                    continue;
                }

                dp[i] += dp[i - nums[j]];
            }

        }

        return dp[target];
    }

    public static void main(String[] args) {
        L377 l377 = new L377();
        int[] nums = new int[]{3, 2, 1};
        int target = 4;
        System.out.println("l377.combinationSum4(nums,target) = " + l377.combinationSum4(nums, target));
    }
}
