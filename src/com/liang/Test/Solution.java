package com.liang.Test;

/**
 * @ClassName Solution
 * @description
 * @Author LiaNg
 * @Date 2019-08-01
 */
public class Solution {

    public static void main(String[] args) {

        count1(11);

    }

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
}
