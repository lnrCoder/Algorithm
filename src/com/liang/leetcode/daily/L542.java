package com.liang.leetcode.daily;

import java.util.Arrays;

/**
 * @ClassName: L542
 * @Description: 01 矩阵
 * @Author: LiaNg
 * @Date: 2020/4/15 23:33
 */
public class L542 {

    public static void main(String[] args) {
        L542 l542 = new L542();
        int[][] matrix = new int[][]
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                };
        System.out.println("l542.updateMatrix(matrix) = " + Arrays.deepToString(l542.updateMatrix(matrix)));
    }

    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     * 示例 1:
     * 输入:
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 输出:
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * 示例 2:
     * 输入:
     * 0 0 0
     * 0 1 0
     * 1 1 1
     * 输出:
     * 0 0 0
     * 0 1 0
     * 1 2 1
     * 注意:
     * 给定矩阵的元素个数不超过 10000。
     * 给定矩阵中至少有一个元素是 0。
     * 矩阵中的元素只在四个方向上相邻：上、下、左、右。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/01-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
