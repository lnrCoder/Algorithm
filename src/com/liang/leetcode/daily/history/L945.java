package com.liang.leetcode.daily.history;

import java.util.Arrays;

/**
 * @ClassName: L945
 * @Description: 使数组唯一的最小增量
 * @Author: LiaNg
 * @Date: 2020/3/22 21:29
 */
public class L945 {

    public static void main(String[] args) {
        L945 l945 = new L945();
        int[] A = new int[]{3, 2, 1, 2, 1, 7};
        System.out.println("l945.minIncrementForUnique(A) = " + l945.minIncrementForUnique(A));
    }

    /**
     * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
     * 返回使 A 中的每个值都是唯一的最少操作次数。
     * 提示：
     * 0 <= A.length <= 40000
     * 0 <= A[i] < 40000
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int result = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                result += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }

        return result;
    }
}
