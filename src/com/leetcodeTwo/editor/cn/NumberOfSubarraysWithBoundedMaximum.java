package com.leetcode.editor.cn;

//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 265 👎 0


/**
 * 795 区间子数组个数
 * @date 2022-11-24 13:25:36
 * @author shang.liang
 */
 public class NumberOfSubarraysWithBoundedMaximum{
    public static void main(String[] args){
        Solution soution = new NumberOfSubarraysWithBoundedMaximum().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }
