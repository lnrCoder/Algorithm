package com.leetcode.editor.cn;

//给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。 
//
// 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。 
//
// 返回可能的 最小差值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [90], k = 1
//输出：0
//解释：选出 1 名学生的分数，仅有 1 种方法：
//- [90] 最高分和最低分之间的差值是 90 - 90 = 0
//可能的最小差值是 0
// 
//
// 示例 2： 
//
// 输入：nums = [9,4,1,7], k = 2
//输出：2
//解释：选出 2 名学生的分数，有 6 种方法：
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
//- [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
//- [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
//- [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
//- [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
//可能的最小差值是 2 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 1000 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 排序 滑动窗口 👍 15 👎 0


import java.util.Arrays;

/**
 * 1984 学生分数的最小差值
 * @date 2022-02-11 08:46:52
 * @author shang.liang
 */
 public class MinimumDifferenceBetweenHighestAndLowestOfKScores{
    public static void main(String[] args){
        Solution soution = new MinimumDifferenceBetweenHighestAndLowestOfKScores().new Solution();
        int[] nums = new int[]{9, 4, 1, 7};
        int k = 2;
        System.out.println("soution.minimumDifference(nums,k) = " + soution.minimumDifference(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDifference(int[] nums, int k) {

        int res = Integer.MAX_VALUE;
        int index = 0;

        Arrays.sort(nums);

        for (int i = k-1; i < nums.length; i++) {

            int tmp = nums[i] - nums[index++];
            res = Math.min(res, tmp);

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }
