package com.liang.leetcode.bitQuestion;

/**
 * @ClassName L461
 * @description hamming-distance 汉明距离
 * @Author LiaNg
 * @Date 2019-08-12
 */
public class L461 {

    public static void main(String[] args) {
        int x = 5;
        int y = 7;
        int i = hammingDistance(x, y);
        System.out.println("i = " + i);
    }

    private static int hammingDistance(int x, int y) {
        int a = x^y;
        int count = 0;
        while(a!=0){
            a = a&(a-1);
            count++;
        }
        return count;
    }
}
