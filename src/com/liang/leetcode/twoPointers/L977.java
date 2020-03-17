package com.liang.leetcode.twoPointers;

import java.util.Arrays;

/**
 * @ClassName: L977
 * @Description: 有序数组的平方
 * @Author: LiaNg
 * @Date: 2020/3/17 18:27
 */
public class L977 {

    public static void main(String[] args) {
        int[] A = new int[]{-4, -1, 0, 3, 10};
        L977 l977 = new L977();
        System.out.println("l977.sortedSquares(A) = " + Arrays.toString(l977.sortedSquares(A)));
    }

    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *  
     * 提示：
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A 已按非递减顺序排序。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;

        int[] result = new int[A.length];
        int index = result.length - 1;

        while (left != right) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                result[index--] = A[left] * A[left];
                left++;
            } else {
                result[index--] = A[right] * A[right];
                right--;
            }
        }
        result[index] = A[left] * A[right];

        return result;
    }
}
