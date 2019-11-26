package com.liang.leetcode.bitManipulation;

/**
 * @ClassName L190
 * @description reverse-bits 颠倒二进制位
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L190 {

    public static void main(String[] args) {
        int n = 5;
        int reverseBits = reverseBits(n);
        System.out.println("reverseBits = " + reverseBits);
    }

    private static int reverseBits(int n) {

        int result = 0;
        for(int i = 0; i<31;i++){
            result  += n&1;
            n>>=1;
            result<<=1;
        }
        return result + (n & 1);
    }
}
