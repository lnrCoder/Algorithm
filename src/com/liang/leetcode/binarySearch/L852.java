package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L852
 * @Description: 山脉数组的峰顶索引
 * @Author: LiaNg
 * @Date: 2020/3/19 12:13
 */
public class L852 {

    public static void main(String[] args) {
        L852 l852 = new L852();
        int[] A = new int[]{0, 2, 1, 0};
        System.out.println("l852.peakIndexInMountainArray(A) = " + l852.peakIndexInMountainArray(A));
    }

    /**
     * 我们把符合下列属性的数组 A 称作山脉：
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * 提示：
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A 是如上定义的山脉
     */
    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int m;

        while (l < r) {
            m = l + (r - l) / 2;
            if (A[m] < A[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
