package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L137
 * @description single-number-ii 只出现 1 次的数 ii
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L137 {

    public static void main(String[] args) {

        int[] nums = {5, 5, 5, 1};
//        int i = singleNumber(nums);
        int i = singleNumber2(nums);
        System.out.println("i = " + i);

    }

    private static int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;

        for (int num : nums) {
            System.out.println("==================start================");
            System.out.println("num = " + num);
            two = two | (one & num);
            System.out.println("Integer.toBinaryString(two) = " + Integer.toBinaryString(two));
            one = one ^ num;
            System.out.println("Integer.toBinaryString(one) = " + Integer.toBinaryString(one));

            int three = two & one;
            System.out.println("Integer.toBinaryString(three) = " + Integer.toBinaryString(three));

            two = two ^ three;
            System.out.println("Integer.toBinaryString(two) = " + Integer.toBinaryString(two));

            one = one ^ three;
            System.out.println("Integer.toBinaryString(one) = " + Integer.toBinaryString(one));

            System.out.println("==================end================");
        }

        return one | two;
    }

    private static int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
            b = (b ^ num) & ~a;
            System.out.println("Integer.toBinaryString(b) = " + Integer.toBinaryString(b));

        }
        return a;
    }
}
