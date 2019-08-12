package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L371
 * @description sum-of-two-integers 两数之和
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L371 {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int sum = getSum(a, b);
        System.out.println("sum = " + sum);
    }

    private static int getSum(int a, int b) {
//        while (b != 0) {
//            int c = a ^ b;
//            int d = (a & b) << 1;
//            a = c;
//            b = d;
//        }
//        return a;

        return b==0?a:getSum(a^b,(a&b)<<1);
    }
}
