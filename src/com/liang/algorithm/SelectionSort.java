package com.liang.algorithm;

import java.util.Arrays;

/**
 * @ClassName SelectionSort
 * @description 选择排序
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 3, 2, 1};

        SelectionSort ss = new SelectionSort();
        ss.selectionSort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    /**
     * 选择排序
     *
     * @param numbers 数组
     * @description 找出未排序中最小值下标，将最小值与当前值交换位置
     */
    public void selectionSort(int[] numbers) {
        int length = numbers.length;
        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length - 1; ++i) {
            // 设置最小值的索引为当前索引
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                // 循环查找未排序的最小值
                if (numbers[j] < numbers[minIndex]) {
                    // 设置最小值的索引值
                    minIndex = j;
                }
            }
            // 当前位置就是最小位置，不做交换
            if (minIndex == i) {
                continue;
            }
            // 未排序的最小值与当前值交换
            numbers[i] ^= numbers[minIndex];
            numbers[minIndex] ^= numbers[i];
            numbers[i] ^= numbers[minIndex];
        }
    }
}
