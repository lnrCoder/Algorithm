package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L922
 * @Description: 按奇偶排序数组 II
 * @Author: LiaNg
 * @Date: 2019/12/17 11:22
 */
public class L922 {

    public static void main(String[] args) {
        int[] A = new int[]{4, 2, 5, 7};
        L922 l922 = new L922();
        System.out.println("l922.sortArrayByParityII(A) = " + Arrays.toString(l922.sortArrayByParityII(A)));
    }

    /**
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     * 你可以返回任何满足上述条件的数组作为答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] sortArrayByParityII(int[] A) {

        int[] result = new int[A.length];
        Arrays.fill(result, 0);

        int odd = 1;
        int even = 0;

        for (int i : A) {
            if (i % 2 == 1) {
                result[odd] = i;
                odd += 2;
            } else {
                result[even] = i;
                even += 2;
            }
        }

        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[] sortArrayByParityII1(int[] A) {
        // 0. traversal
        for (int e = 0, o = 1; e < A.length; e += 2) {
            // 1. 如果偶数位置是奇数
            if ((A[e] & 1) == 0) {
                continue;
            }
            // 2. 找奇数位置的偶数
            while ((A[o] & 1) == 1) {
                o += 2;
            }
            int temp = A[e];
            A[e] = A[o];
            A[o] = temp;
        }
        return A;
    }
}
