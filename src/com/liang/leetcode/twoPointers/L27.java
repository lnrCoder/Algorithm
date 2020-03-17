package com.liang.leetcode.twoPointers;

/**
 * @ClassName: L27
 * @Description: 移除元素
 * @Author: LiaNg
 * @Date: 2020/3/17 19:56
 */
public class L27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int val = 3;
        L27 l27 = new L27();
        System.out.println("l27.removeElement(nums,val) = " + l27.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
