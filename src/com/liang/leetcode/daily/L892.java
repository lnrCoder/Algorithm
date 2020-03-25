package com.liang.leetcode.daily;

/**
 * @ClassName: L892
 * @Description: 三维形体的表面积
 * @Author: LiaNg
 * @Date: 2020/3/25 9:19
 */
public class L892 {

    public static void main(String[] args) {
        L892 l892 = new L892();
        int[][] grid = new int[][]{{1, 2}, {3, 4}};
//        int[][] grid = new int[][]{{1, 0}, {0, 2}};
        System.out.println("l892.surfaceArea(grid) = " + l892.surfaceArea(grid));
    }

    /**
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * 请你返回最终形体的表面积。
     * 提示：
     * 1 <= N <= 50
     * 0 <= grid[i][j] <= 50
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int surfaceArea(int[][] grid) {

        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] > 0) {
                    result += grid[i][j] * 4 + 2;

                    if (i + 1 < row) {
                        result -= Math.min(grid[i][j], grid[i + 1][j]);
                    }
                    if (j + 1 < col) {
                        result -= Math.min(grid[i][j], grid[i][j + 1]);
                    }
                    if (i - 1 >= 0) {
                        result -= Math.min(grid[i][j], grid[i - 1][j]);
                    }
                    if (j - 1 >= 0) {
                        result -= Math.min(grid[i][j], grid[i][j - 1]);
                    }
                }
            }
        }

        return result;
    }
}
