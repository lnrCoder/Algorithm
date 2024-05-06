package com.leetcode.editor.cn;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 391 👎 0


/**
 * 540 有序数组中的单一元素
 * @date 2022-02-14 12:42:15
 * @author shang.liang
 */
 public class SingleElementInASortedArray{
    public static void main(String[] args){
        Solution soution = new SingleElementInASortedArray().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }
