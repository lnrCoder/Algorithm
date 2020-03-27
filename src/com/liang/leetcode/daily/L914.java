package com.liang.leetcode.daily;

/**
 * @ClassName: L914
 * @Description: 卡牌分组
 * @Author: LiaNg
 * @Date: 2020/3/27 8:52
 */
public class L914 {

    public static void main(String[] args) {
        L914 l914 = new L914();
        int[] deck = new int[]{1,2,3,4,4,3,2,1};
        System.out.println("l914.hasGroupsSizeX(deck) = " + l914.hasGroupsSizeX(deck));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] check = new int[10000];

        for (int i : deck) {
            check[i]++;
        }

        int gcd = check[0];

        for (int i = 1; i < 10000; i++) {
            if (check[i] > 0) {
                gcd = gcd(gcd, check[i]);
            }
        }

        return gcd > 1;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

}
