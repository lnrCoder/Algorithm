package com.liang.leetcode;

/**
 * @ClassName L191
 * @description number-of-1-bits
 * @Author LiaNg
 * @Date 2018/12/3
 */
public class L191 {


    public static void main(String[] args) {
        L191 l = new L191();

        int n = 11;
        System.out.println(l.hammingWeight(11));
    }

    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

}
