package com.liang.leetcode.daily.history;

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

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean canJump(int[] nums) {

        int n = nums.length - 1;
        int max = 0;

        for (int i = 0; i <= n; i++) {
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
