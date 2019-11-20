package com.liang.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName L496
 * @description 下一个更大元素 I
 * @Author LiaNg
 * @Date 2019-11-20
 */
public class L496 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 5, 2, 4};
        int[] nums2 = new int[]{6, 5, 4, 3, 2, 1, 7};

        L496 l496 = new L496();
        System.out.println("l496.nextGreaterElement(nums1,nums2) = " + Arrays
                .toString(l496.nextGreaterElement(nums1, nums2)));
    }

    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中 nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 - 1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Map<Integer, Integer> kv = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                kv.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = kv.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
