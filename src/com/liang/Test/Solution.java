package com.liang.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

//        powerOf2(9);

//        bitSwap(3, 5);

//        int[] nums = {1, 3, 5, 2, 7,  8};
//        subSets(nums);

        int a =11;
        System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
        System.out.println("Integer.toBinaryString(~a) = " + Integer.toBinaryString(~a));
        System.out.println("Integer.toBinaryString(-a) = " + Integer.toBinaryString(-a));

        a =-11;
        System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
        System.out.println("Integer.toBinaryString(~a) = " + Integer.toBinaryString(~a));
        System.out.println("Integer.toBinaryString(-a) = " + Integer.toBinaryString(-a));

        a = a&-a;
        System.out.println("a = " + a);
    }

    /**
     * 求二进制中 1 的个数
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

    /**
     * 位运算两数求和
     */
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

    /**
     * 判断一个数是否是 2 的次幂
     */
    private static void powerOf2(int num) {
        System.out.println("num > 0 && (num & (num - 1) ==0) = " + (num > 0 && (num & (num - 1)) == 0));
    }

    /**
     * 计算在一个 32 位的整数的二进制表式中有多少个 1
     */
    private static int countOnes(int num) {

        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;

    }

    /**
     * 将整数 A 转换为 B，需要改变多少个 bit 位
     */
    private static void bitSwap(int a, int b) {

        int counts = countOnes(a ^ b);
        System.out.println("counts = " + counts);

        }

        private static void subSets(int[] nums) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subList.add(nums[j]);
                }
            }
            result.add(subList);
        }
        System.out.println("result = " + result);

    }



}
