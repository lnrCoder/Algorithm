package com.liang.leetcode.daily.Mar21;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author LiaNg
 * @date 2021/3/15 14:20
 */
public class L54 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *  
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int row = matrix.length;
        if (row == 0) {
            return list;
        }
        int col = matrix[0].length;

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        int numCount = row * col;

        while (numCount >= 1) {

            for (int i = left; i <= right && numCount-- >= 1; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom && numCount-- >= 1; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            for (int i = right; i >= left && numCount-- >= 1; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top && numCount-- >= 1; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }

        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0;
        int column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }

    public static void main(String[] args) {
        L54 l54 = new L54();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println("l54.spiralOrder(matrix) = " + l54.spiralOrder(matrix));
    }
}
