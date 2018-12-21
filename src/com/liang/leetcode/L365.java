package com.liang.leetcode;

/**
 * @ClassName L365
 * @description water-and-jug-problem
 * @Author LiaNg
 * @Date 2018-12-21
 */
public class L365 {

    public static void main(String[] args) {

        int x = 3;
        int y = 5;
        int z = 0;

        L365 l = new L365();
        System.out.println(l.canMeasureWater(x, y, z));

    }

    /**
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
     * 你允许：
     * 装满任意一个水壶
     * 清空任意一个水壶
     * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
     */
    public boolean canMeasureWater(int x, int y, int z) {

        if (z == 0) {
            return false;
        }
        if (x + y < z) {
            return false;
        }
        if (x < y) {
            x = x + y;
            y = x - y;
            x = x - y;
        }

        if (y == 0) {
            return x == z;
        }

        int gcd = 0;
        while (x % y != 0) {
            gcd = x % y;
            x = y;
            y = gcd;
        }

        return z % y == 0;

    }
}
