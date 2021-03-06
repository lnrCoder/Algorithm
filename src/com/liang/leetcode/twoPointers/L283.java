package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L283
 * @Description: 移动零
 * @Author: LiaNg
 * @Date: 2020/3/17 20:14
 */
public class L283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        L283 l283 = new L283();
        l283.moveZeroes(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        Arrays.fill(nums, j, nums.length, 0);
    }
}
