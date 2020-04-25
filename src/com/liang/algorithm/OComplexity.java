package com.liang.algorithm;

/**
 * 时间复杂度伪代码
 *
 * @author LiaNg
 * @date 2020/4/25 19:47
 */
public class OComplexity {

    public static void main(String[] args) {

        Integer n = Integer.MAX_VALUE;

        // 时间复杂度为 O(1)
        int i = 1;
        int j = 2;
        int sum = i + j;

        // 时间复杂度为 O(logn)
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;

            //条件判断
            if (1 == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 时间复杂度为 O(c^n)
        int c = 10;
        for (int k = 0; k < c; k++) {
            for (int l = 0; l < n; l++) {
                // TODO
            }
        }

        // 时间复杂度为 O(n)
        for (int k = 0; k < n; k++) {
            // TODO
        }

        // 时间复杂度为 O(n^2)
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                // TODO
            }
        }

        int[] nums = new int[n];
        backtrack(nums, 0, n);

    }

    public static void backtrack(int[] nums, int i, int n) {
        for (int j = i; j < n; ++j) {
            if (i != j) {
                // TODO
            } else {
                backtrack(nums, i + 1, n);
            }
        }
    }
}
