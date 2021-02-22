package com.liang.leetcode.daily.Feb21;

/**
 * 托普利茨矩阵
 *
 * @author LiaNg
 * @date 2021/2/22 8:56
 */
public class L766 {

    public static void main(String[] args) {

        L766 l766 = new L766();
//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix = new int[][]{{11, 74, 0, 93}, {40, 11, 74, 7}};
        System.out.println("l766.isToeplitzMatrix(matrix) = " + l766.isToeplitzMatrix(matrix));
    }

    /**
     * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
     * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
     *  
     * 示例 1：
     * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
     * 输出：true
     * 解释：
     * 在上述矩阵中, 其对角线为:
     * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
     * 各条对角线上的所有元素均相同, 因此答案是 True 。
     * 示例 2：
     * 输入：matrix = [[1,2],[2,2]]
     * 输出：false
     * 解释：
     * 对角线 "[1, 2]" 上的元素不同。
     *  
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 20
     * 0 <= matrix[i][j] <= 99
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix.length <= 1) {
            return true;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int rowIndex;
        int colIndex;

        for (int i = 0; i < col; i++) {
            rowIndex = 0;
            colIndex = i;

            while (rowIndex < row - 1 && colIndex < col - 1) {
                if (matrix[rowIndex][colIndex] == matrix[++rowIndex][++colIndex]) {
                    continue;
                }
                return false;
            }
        }

        for (int i = 0; i < row; i++) {
            rowIndex = i;
            colIndex = 0;

            while (rowIndex < row - 1 && colIndex < col - 1) {
                if (matrix[rowIndex][colIndex] == matrix[++rowIndex][++colIndex]) {
                    continue;
                }
                return false;
            }
        }

        return true;
    }
}
