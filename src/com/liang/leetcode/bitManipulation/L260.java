package com.liang.leetcode.bitManipulation;

import java.util.Arrays;

/**
 * @ClassName L260
 * @description single-number-iii 只出现一次的数字 III
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L260 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] result = singleNumber(nums);
        System.out.println("result = " + Arrays.toString(result));
    }

    private static int[] singleNumber(int[] nums) {

        int[] a ={0,0};

        int result = nums[0];

        for(int i=1;i<nums.length ;i++){
            result ^= nums[i];
        }

        result &= -result;

        for(int num : nums){
            if( (result & num)==0 ){
                a[0] ^= num;
            }else{
                a[1] ^= num;
            }
        }
        return a;
    }
}
