package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L88
 * @Description: 合并两个有序数组
 * @Author: LiaNg
 * @Date: 2020/3/18 22:17
 */
public class L88 {

    public static void main(String[] args) {
        L88 l88 = new L88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        l88.merge(nums1, m, nums2, n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;

        while (m != 0 && n != 0) {
            if (nums2[n - 1] < nums1[m - 1]) {
                nums1[index--] = nums1[m-- - 1];
            } else {
                nums1[index--] = nums2[n-- - 1];
            }
        }

        while (n != 0) {
            nums1[index--] = nums2[n-- - 1];
        }
    }
}
