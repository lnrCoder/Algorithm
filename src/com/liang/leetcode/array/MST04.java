package com.liang.leetcode.array;

/**
 * 二维数组中的查找
 *
 * @author LiaNg
 * @date 2020/5/28 16:24
 */
public class MST04 {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 示例:
     * 现有矩阵 matrix 如下：
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     * 限制：
     * 0 <= n <= 1000
     * 0 <= m <= 1000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int row = matrix.length;
        if (row == 0) {
            return false;
        }

        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }

        int r = row-1;
        int l = 0;
        while (r >= 0  && l < col) {
            if (matrix[r][l] == target) {
                return true;
            }
            if (matrix[r][l] < target) {
                l++;
            } else if (matrix[r][l] > target) {
                r--;
            }
        }

        return false;
    }
}
