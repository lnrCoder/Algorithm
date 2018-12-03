package com.liang.leetcode;

import com.sun.org.apache.bcel.internal.generic.RET;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L396
 * @description rotate-function
 * @Author LiaNg
 * @Date 2018/12/3
 */
public class L396 {

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 6};

        L396 l = new L396();
        System.out.println(l.maxRotateFunction(A));
    }

    /**
     * 给定一个长度为 n 的整数数组 A 。
     * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
     * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
     * 计算F(0), F(1), ..., F(n-1)中的最大值。
     */
    public int maxRotateFunction(int[] A) {

        int n = A.length;
        int sum = 0;
        int t = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
            t += i * A[i];
        }

        int result = t;
        for (int i = 1; i < n; ++i) {
            t = t + sum - n * A[n - i];
            result = Math.max(result, t);
        }

        return result;
    }
}
