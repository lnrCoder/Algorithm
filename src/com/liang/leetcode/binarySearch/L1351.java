package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L1351
 * @Description: 统计有序矩阵中的负数
 * @Author: LiaNg
 * @Date: 2020/3/19 11:24
 */
public class L1351 {

    public static void main(String[] args) {
        L1351 l1351 = new L1351();
        int[][] grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println("l1351.countNegatives(grid) = " + l1351.countNegatives(grid));
    }

    /**
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
     * 请你统计并返回 grid 中 负数 的数目。
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * -100 <= grid[i][j] <= 100
     */
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;

        for (int[] ints : grid) {
            result += ints.length - binarySearch(ints);
        }
        return result;
    }

    private int binarySearch(int[] row) {
        int l = 0;
        int r = row.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (row[m] >= 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
