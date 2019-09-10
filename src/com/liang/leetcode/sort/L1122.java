package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName L1122
 * @description relative-sort-array 数组的相对排序
 * @Author LiaNg
 * @Date 2019-09-10
 */
public class L1122 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        int[] result = relativeSortArray(arr1, arr2);

        System.out.println("result = " + Arrays.toString(result));

    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] m = new int[1001];

        int[] ref = new int[arr1.length];

        for (int value : arr1) {
            m[value]++;
        }

        int cnt = 0;
        for (int value : arr2) {
            while (m[value] > 0) {
                ref[cnt++] = value;
                m[value]--;
            }
        }

        for(int i = 0; i < 1001; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }
}
