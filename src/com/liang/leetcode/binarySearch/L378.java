package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L378
 * @Description: 有序矩阵中第 K 小的元素
 * @Author: LiaNg
 * @Date: 2020/3/24 18:21
 */
public class L378 {

    public static void main(String[] args) {
        L378 l378 = new L378();
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println("l378.kthSmallest(matrix,k) = " + l378.kthSmallest(matrix, k));
    }

    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个元素。
     * 说明:
     * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int kthSmallest(int[][] matrix, int k) {

        int count = 0;

        int length = matrix.length;

        int l = matrix[0][0];
        int r = matrix[length - 1][length - 1];
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;
            count = checkCount(matrix, m);
            if (count < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public int checkCount(int[][] matrix, int k) {

        int n = matrix.length, i = n - 1, j = 0, res = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= k) {
                res += i + 1;
                ++j;
            } else {
                --i;
            }
        }
        return res;
    }
}
