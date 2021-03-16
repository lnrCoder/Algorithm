package com.liang.leetcode.daily.Mar21;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 *
 * @author LiaNg
 * @date 2021/3/16 8:49
 */
public class L59 {

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *  
     * 示例 1：
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int numCount = n * n;
        int num = 1;

        while (numCount >= 1) {

            for (int i = left; i <= right && numCount-- >= 1; i++) {
                res[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom && numCount-- >= 1; i++) {
                res[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left && numCount-- >= 1; i--) {
                res[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top && numCount-- >= 1; i--) {
                res[i][left] = num++;
            }
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        L59 l59 = new L59();
        int n = 9;
        System.out.println("l59.generateMatrix(n) = " + Arrays.deepToString(l59.generateMatrix(n)));
    }
}
