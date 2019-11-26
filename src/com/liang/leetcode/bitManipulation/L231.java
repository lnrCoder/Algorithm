package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L231
 * @description power-of-two 2的幂
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L231 {

    public static void main(String[] args) {
        int n = 8;
        boolean powerOfTwo = isPowerOfTwo(n);
        System.out.println("powerOfTwo = " + powerOfTwo);
    }

    private static boolean isPowerOfTwo(int n) {
        return n>0 && ((n&(n-1))==0);
    }
}
