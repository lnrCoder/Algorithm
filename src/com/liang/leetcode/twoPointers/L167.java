package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L167
 * @Description: 两数之和 II - 输入有序数组
 * @Author: LiaNg
 * @Date: 2020/3/17 20:23
 */
public class L167 {

    public static void main(String[] args) {
        L167 l167 = new L167();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println("l167.twoSum(numbers,target) = " + Arrays.toString(l167.twoSum(numbers, target)));
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * 说明:
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right && numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
