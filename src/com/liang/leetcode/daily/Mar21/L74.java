package com.liang.leetcode.daily.Mar21;

/**
 * 搜索二维矩阵
 *
 * @author LiaNg
 * @date 2021/3/30 8:54
 */
public class L74 {

    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *  
     * 示例 1：
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     *  
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int targetRow = -1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {
                targetRow = i;
                break;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        for (int i = 0; i < col; i++) {
            if (matrix[targetRow][i] == target) {
                return true;
            }
        }

        return false;
    }
}
