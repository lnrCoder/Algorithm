package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L169
 * @description majority-element 多数元素
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L169 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3};
        int i = majorityElement(nums);
        System.out.println("i = " + i);
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }
            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
