package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L169
 * @description majority-element 求众数
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L169 {

    public static void main(String[] args) {

        int[] nums = {1,1,2,2,3};
        int i = majorityElement(nums);
        System.out.println("i = " + i);
    }

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
