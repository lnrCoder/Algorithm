package com.liang.leetcode;

/**
 * @ClassName L326
 * @description power-of-three
 * @Author LiaNg
 * @Date 2018/11/4
 */
public class L326 {

    public static void main(String[] args) {
        L326 l = new L326();
        boolean result = l.isPowerOfThree(27);
        System.out.println(result);
    }

    /**
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * 不使用循环或者递归
     */
    public boolean isPowerOfThree(int n) {
        double result = Math.log10(n) / Math.log10(3);
        return (result == (int) result) ? true : false;
    }
}
