package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L367
 * @Description: 有效的完全平方数
 * @Author: LiaNg
 * @Date: 2020/3/22 22:46
 */
public class L367 {

    public static void main(String[] args) {
        L367 l367 = new L367();
        int num = 14;
        System.out.println("l367.isPerfectSquare(num) = " + l367.isPerfectSquare(num));
    }

    /**
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     * 说明：不要使用任何内置的库函数，如  sqrt。
     */
    public boolean isPerfectSquare(int num) {
        long min = 0;
        long max = num;

        while (min <= max) {
            long mid = (min + max) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquare1(int num) {

        for (int i = 1; i <= num / i; i++) {
            if (num % i == 0 && num / i == i) {
                return true;
            }
        }
        return false;
    }
}
