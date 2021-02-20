package com.liang.leetcode.daily.history;

/**
 * 665. 非递减数列
 *
 * @author LiaNg
 * @date 2021/2/7 10:51
 */
public class L665 {

    public static void main(String[] args) {
        L665 l665 = new L665();
        int[] nums1 = new int[]{4, 2, 3};
        int[] nums2 = new int[]{4, 2, 1};

        System.out.println("l665.checkPossibility(nums1) = " + l665.checkPossibility(nums1));
        System.out.println("l665.checkPossibility(nums2) = " + l665.checkPossibility(nums2));
    }

    /**
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *  
     * 示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *  
     * 说明：
     * 1 <= n <= 10 ^ 4
     * - 10 ^ 5 <= nums[i] <= 10 ^ 5
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        int flag = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            flag = 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int right = nums[i + 1];
            if (nums[i] > right) {
                flag++;
                if (flag > 1) {
                    // 多个递减的情况，直接 false
                    return false;
                }
                int left = nums[i - 1];
                if (left > right) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = left;
                }
            }
        }

        return true;
    }
}
