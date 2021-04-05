package com.liang.leetcode.daily.APR21;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * @author LiaNg
 * @date 2021/4/5 10:48
 */
public class L88 {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     *  
     * 示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     *  
     * 提示：
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[i] <= 109
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail = m + n - 1;
        m--;
        n--;
        int cur;

        while (m >= 0 || n >= 0) {

            if (m < 0) {
                cur = nums2[n--];
            } else if (n < 0) {
                cur = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                cur = nums1[m--];
            } else {
                cur = nums2[n--];
            }

            nums1[tail--] = cur;
        }
    }

    public static void main(String[] args) {
        L88 l88 = new L88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        l88.merge(nums1, m, nums2, n);
        System.out.println("nums1 = " + Arrays.toString(nums1));
    }
}
