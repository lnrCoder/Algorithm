package com.liang.leetcode.daily.history;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author LiaNg
 * @date 2020/5/15 16:20
 */
public class L54 {

    public static void main(String[] args) {

        L54 l54 = new L54();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("l54.spiralOrder(matrix) = " + l54.spiralOrder(matrix));
    }

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 示例 1:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
//            return new int[0];
            return new ArrayList<>();
        }

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;

        ArrayList<Integer> resList = new ArrayList<>();
        int[] res = new int[(b + 1) * (r + 1)];

        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
                resList.add(matrix[t][i]);
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
                resList.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
                resList.add(matrix[b][i]);
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
                resList.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return resList;
    }
}
