package com.liang.leetcode.daily.Feb21;

import java.util.Arrays;

/**
 * 翻转图像
 *
 * @author LiaNg
 * @date 2021/2/24 18:04
 */
public class L832 {

    public static void main(String[] args) {
        L832 l832 = new L832();
        int[][] A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        System.out.println("l832.flipAndInvertImage(A) = " + Arrays.deepToString(l832.flipAndInvertImage(A)));
    }

    /**
     * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
     * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
     * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
     *  
     * 示例 1：
     * 输入：[[1,1,0],[1,0,1],[0,0,0]]
     * 输出：[[1,0,0],[0,1,0],[1,1,1]]
     * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
     * 示例 2：
     * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *  
     * 提示：
     * 1 <= A.length = A[0].length <= 20
     * 0 <= A[i][j] <= 1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flipping-an-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        int arraysLen = A.length;
        int arrayLen = A[0].length;

        for (int i = 0; i < arraysLen; i++) {
            int index = 0;
            for (int j = arrayLen - 1; j >= 0; j--) {
                res[i][index] = A[i][j] ^ 1;
                index++;
            }
        }
        return res;
    }
}
