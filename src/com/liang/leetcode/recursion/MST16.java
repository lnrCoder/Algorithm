package com.liang.leetcode.recursion;

/**
 * @ClassName: MST16
 * @Description: 数值的整数次方
 * @Author: LiaNg
 * @Date: 2020/3/27 22:23
 */
public class MST16 {

    public static void main(String[] args) {
        MST16 mst16 = new MST16();
        double x = 2.10000;
        int n = 3;
        System.out.println("mst16.myPow(x,n) = " + mst16.myPow(x, n));
    }

    /**
     * 实现函数 double Power (double base, int exponent)，求 base 的 exponent 次方。不得使用库函数，同时不需要考虑大数问题。
     * 说明:
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     */
    public double myPow(double x, int n) {

        double result = 1.0;
        long m = n;

        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        while (m > 0) {
            if ((m & 1) == 1) {
                result *= x;
            }
            x *= x;
            m >>= 1;
        }
        return result;
    }
}
