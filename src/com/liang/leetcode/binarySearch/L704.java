package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L704
 * @Description: 二分查找
 * @Author: LiaNg
 * @Date: 2020/3/19 19:13
 */
public class L704 {

    public static void main(String[] args) {
        L704 l704 = new L704();
        int[] nums = new int[]{-1, 0, 3, 5, 9};
        int target = 2;
        System.out.println("l704.search(nums, target) = " + l704.search(nums, target));
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 提示：
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000] 之间。
     * nums 的每个元素都将在 [-9999, 9999] 之间。
     */
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
