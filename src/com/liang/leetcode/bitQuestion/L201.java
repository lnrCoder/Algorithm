package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L201
 * @description bitwise-and-of-numbers-range 数字范围按位与
 * @Author LiaNg
 * @Date 2019-08-11
 */
public class L201 {

    public static void main(String[] args) {

        int m = 5;
        int n = 7;
        System.out.println("rangeBitwiseAnd(m,n) = " + rangeBitwiseAnd(m,n));
        System.out.println("rangeBitwiseAnd2(m,n) = " + rangeBitwiseAnd2(m,n));

    }

    private static int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || m == n) {
            return m;
        }

        int count = 0;

        for (; m != n; count++) {
            m >>= 1;
            n >>= 1;
        }

        return m << count;
    }

    private static int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}
