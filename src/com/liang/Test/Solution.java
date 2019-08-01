package com.liang.Test;

/**
 * @ClassName Solution
 * @description
 * @Author LiaNg
 * @Date 2019-08-01
 */
public class Solution {

    public static void main(String[] args) {

//        count1(11);
//        aplusb(10, 6);

        powerOf2(9);

    }

    /**
     * @param num 求二进制中 1 的个数
     */
    private static void count1(int num) {
        int count = 0;
        System.out.println("Integer.toBinaryString(num) = " + Integer.toBinaryString(num));
        while (num != 0) {
            System.out.println("num = " + Integer.toBinaryString(num));
            num = num & (num - 1);
            count++;
        }
        System.out.println("count = " + count);
    }

    private static void aplusb(int a, int b) {
        System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
        System.out.println("Integer.toBinaryString(b) = " + Integer.toBinaryString(b));
        while (b != 0) {
            int newa = a ^ b;
            System.out.println("Integer.toBinaryString(newa) = " + Integer.toBinaryString(newa));
            int newb = (a & b) << 1;
            System.out.println("Integer.toBinaryString(a&b) = " + Integer.toBinaryString(a & b));
            System.out.println("Integer.toBinaryString(newb) = " + Integer.toBinaryString(newb));
            a = newa;
            b = newb;
        }
        System.out.println("a = " + a);
    }

    private static void powerOf2(int num) {
        System.out.println("num > 0 && (num & (num - 1) ==0) = " + (num > 0 && (num & (num - 1)) == 0));
    }
}
