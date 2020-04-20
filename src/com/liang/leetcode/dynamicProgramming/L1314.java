package com.liang.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: L1314
 * @Description: 矩阵区域和
 * @Author: LiaNg
 * @Date: 2020/4/20 14:47
 */
public class L1314 {

    public static void main(String[] args) {
        L1314 l1314 = new L1314();
        int[][] mat = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int k = 3;

        int[][] mat1 = new int[][]{{67, 64, 78}, {99, 98, 38}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}};

        System.out.println("l1314.matrixBlockSum(mat,k) = " + Arrays.deepToString(l1314.matrixBlockSum(mat1, k)));
    }

    /**
     * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
     * i - K <= r <= i + K, j - K <= c <= j + K 
     * (r, c) 在矩阵内。
     *  
     * 示例 1：
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
     * 输出：[[12,21,16],[27,45,33],[24,39,28]]
     * 示例 2：
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
     * 输出：[[45,45,45],[45,45,45],[45,45,45]]
     *  
     * 提示：
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n, K <= 100
     * 1 <= mat[i][j] <= 100
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matrix-block-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                res[i][j] = dfs(i, j, K, mat);
            }
        }

        return res;
    }

    public int dfs(int i, int j, int k, int[][] mat) {
        int res = 0;

        for (int i1 = i - k; i1 <= i + k; i1++) {
            if (i1 >= mat.length) {
                break;
            }
            if (i1 >= 0) {
                for (int j1 = j - k; j1 <= j + k; j1++) {
                    if (j1 >= mat[0].length) {
                        break;
                    }
                    if (j1 >= 0) {
                        res += mat[i1][j1];
                    }
                }
            }
        }
        return res;
    }
}
