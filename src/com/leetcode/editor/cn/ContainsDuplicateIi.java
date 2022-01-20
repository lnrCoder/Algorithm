package com.leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 420 👎 0


/**
 * 219 存在重复元素 II
 *
 * @author shang.liang
 * @date 2022-01-19 21:13:32
 */
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution soution = new ContainsDuplicateIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            for (int i = 0; i < nums.length; i++) {

                for (int j = i + 1; j <= Math.min(i + k, nums.length-1); j++) {

                    if (nums[i] == nums[j]) {
                        return true;
                    }

                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
