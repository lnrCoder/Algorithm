package com.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 520 👎 0


import java.util.ArrayDeque;

/**
 * 862 和至少为 K 的最短子数组
 *
 * @author shang.liang
 * @date 2022-10-26 12:56:15
 */
public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        Solution soution = new ShortestSubarrayWithSumAtLeastK().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length, ans = n + 1;
            var s = new long[n + 1];
            for (var i = 0; i < n; ++i)
                s[i + 1] = s[i] + nums[i]; // 计算前缀和
            var q = new ArrayDeque<Integer>();
            for (var i = 0; i <= n; ++i) {
                var curS = s[i];
                while (!q.isEmpty() && curS - s[q.peekFirst()] >= k) ans = Math.min(ans, i - q.pollFirst()); // 优化一
                while (!q.isEmpty() && s[q.peekLast()] >= curS) q.pollLast(); // 优化二
                q.addLast(i);
            }
            return ans > n ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
