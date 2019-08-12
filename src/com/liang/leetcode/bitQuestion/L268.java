package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L268
 * @description missing-number 缺失的数字
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L268 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,8,9};
        int missingNumber = missingNumber(nums);
        System.out.println("missingNumber = " + missingNumber);
    }

    private static int missingNumber(int[] nums) {
//         Arrays.sort(nums);

//         if(nums[nums.length-1] != nums.length){
//             return nums.length;
//         }

//         if(nums[0] != 0){
//             return 0;
//         }

//         for(int i =1;i<nums.length;i++){
//             int result = nums[i-1]+1;
//             if(nums[i] != result){
//                 return result;
//             }
//         }
//         return -1;

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ nums[i] ^ (i + 1);
        }
        return res;
    }
}
