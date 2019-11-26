package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L477
 * @description total-hamming-distance 汉明距离总和
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L477 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int totalHammingDistance = totalHammingDistance(nums);
        System.out.println("totalHammingDistance = " + totalHammingDistance);
    }

    private static int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i=0;i<32;i++){
            int cnt = 0;
            for(int num:nums){
                cnt += (num>>i) & 1;
            }
            res += cnt * (n-cnt);
        }
        return res;
    }
}
