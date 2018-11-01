package com.liang.algorithm;

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
        ss.selectionSort(numbers, numbers.length);

    }

    /**
     * 选择排序
     *
     * @param numbers 数组
     * @param length 数组大小
     */
    public void selectionSort(int[] numbers, int length) {
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex == i) {
                continue;
            }
            // 交换
            int tmp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = tmp;
        }
    }
}
