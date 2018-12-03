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
