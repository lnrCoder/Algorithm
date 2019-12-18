package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L976
 * @Description: 三角形的最大周长
 * @Author: LiaNg
 * @Date: 2019/12/18 8:47
 */
public class L976 {

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 2};
        L976 l976 = new L976();
        System.out.println("l976.largestPerimeter(A) = " + l976.largestPerimeter(A));
    }

    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int largestPerimeter(int[] A) {

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }

        return 0;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int largestPerimeter1(int[] A) {
        int result = 0;
        int maxA = max(A);
        int maxB = max(A);
        int maxC = max(A);
        while (maxC != 0) {
            if (maxB + maxC > maxA) {
                result = maxA + maxB + maxC;
                break;
            } else {
                maxA = maxB;
                maxB = maxC;
                maxC = max(A);
            }
        }
        return result;
    }

    public int max(int[] A) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            A[maxIndex] = -1;
        }
        return max;
    }
}
