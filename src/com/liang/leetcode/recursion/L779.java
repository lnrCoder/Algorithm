package com.liang.leetcode.recursion;

/**
 * @ClassName L779
 * @description 第K个语法符号
 * @Author LiaNg
 * @Date 2019-12-02
 */
public class L779 {

    public static void main(String[] args) {
        int N = 4;
        int K = 2;

        L779 l779 = new L779();
        System.out.println("l779.kthGrammar(N,K) = " + l779.kthGrammar(N, K));
    }

    public int kthGrammar(int N, int K) {

        if (N == 1) {
            return 0;
        }

        return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }
}
