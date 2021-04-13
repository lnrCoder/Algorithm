package com.liang.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author LiaNg
 * @date 2020/4/28 14:26
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {14, 2, 25, 17, 7, 38, 34, 5, 42, 15, 42};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    /**
     * 快速排序(常规)
     *
     * @param numbers 待排序数组
     */
    public void quickSort(int[] numbers) {

        int length = numbers.length;
        if (length <= 1) {
            return;
        }

        sort(numbers, 0, length - 1);
    }

    /**
     * 在排序区间段为 [left...right] 的左闭右闭区间内进行排序操作
     *
     * @param numbers 数组
     * @param left 左索引
     * @param right 右索引
     */
    public void sort(int[] numbers, int left, int right) {

        if (left >= right) {
            return;
        }

        // 将区间段内第一个位置设置为分区值
        int smallIndex = left;

        // 遍历整个排序区间
        for (int i = left + 1; i < right; i++) {
            //
            if (numbers[i] < numbers[left]) {
                smallIndex++;
                swap(numbers, i, smallIndex);
            }
        }

        swap(numbers, left, smallIndex);

        // 将大于等于分区值的和小于分区值的分为两部分继续进行排序
        // [left...smallIndex-1] 该区间的值都小于此时的 numbers[smallIndex]
        sort(numbers, left, smallIndex - 1);
        // [smallIndex+1...right] 该区间的值都大于等于此时的 numbers[smallIndex]
        sort(numbers, smallIndex + 1, right);
    }

    /**
     * 交换数组中 i,j 下标对应的值
     *
     * @param numbers 数组
     * @param i 下标
     * @param j 下标
     */
    public void swap(int[] numbers, int i, int j) {
        if (i == j) {
            return;
        }
        numbers[i] ^= numbers[j];
        numbers[j] ^= numbers[i];
        numbers[i] ^= numbers[j];
    }
}
