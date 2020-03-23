package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L69
 * @Description: x 的平方根
 * @Author: LiaNg
 * @Date: 2020/3/23 10:42
 */
public class L69 {

    public static void main(String[] args) {
        L69 l69 = new L69();
        int x = 5;
        System.out.println("l69.mySqrt(x) = " + l69.mySqrt(x));
    }

    /**
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (x / m == m) {
                return m;
            } else if (x / m < m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l - 1;
    }
}
