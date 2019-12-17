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

    /**
     * 给你两个数组，arr1 和 arr2，
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/relative-sort-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
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

        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;
    }

    /**
     * LeetCode 耗时最短解答
     */
    private static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        for (int item : arr1) {
            temp[item]++;
        }
        int[] result = new int[arr1.length];
        int resultIndex = 0;
        for (int item : arr2) {
            int count = temp[item];
            for (int i = 0; i < count; i++) {
                result[resultIndex++] = item;
            }
            temp[item] = 0;
        }
        if (resultIndex <= arr1.length) {
            for (int i = 0; i < 1001; i++) {
                int count = temp[i];
                for (int j = 0; j < count; j++) {
                    result[resultIndex++] = i;
                }
            }
        }
        return result;
    }
}
