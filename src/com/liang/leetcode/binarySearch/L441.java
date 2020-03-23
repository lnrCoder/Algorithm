package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L441
 * @Description: 排列硬币
 * @Author: LiaNg
 * @Date: 2020/3/23 10:16
 */
public class L441 {

    public static void main(String[] args) {
        L441 l441 = new L441();
        int n = 1804289383;
        System.out.println("l441.arrangeCoins(n) = " + l441.arrangeCoins(n));
    }

    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在 32 位有符号整型的范围内。
     */
    public int arrangeCoins(int n) {

        long l = 0;
        long r = n;
        long m;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (m * (m + 1) / 2 <= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return (int) l - 1;
    }
}
