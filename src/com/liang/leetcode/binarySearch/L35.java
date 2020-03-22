package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L35
 * @Description: 搜索插入位置
 * @Author: LiaNg
 * @Date: 2020/3/22 21:45
 */
public class L35 {

    public static void main(String[] args) {
        L35 l35 = new L35();
        int[] nums = new int[]{1, 3};
        int target = 2;
        System.out.println("l35.searchInsert(nums,target) = " + l35.searchInsert(nums, target));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     */
    public int searchInsert(int[] nums, int target) {

        if (nums[0] > target) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
