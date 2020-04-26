package com.liang.algorithm;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @description 冒泡排序
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = {14, 2, 25, 17, 7, 38, 34, 5, 42, 15, 42};

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(numbers, numbers.length);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    /**
     * 冒泡排序
     *
     * @param numbers 数组
     * @param size 数组大小
     * @description 逐步两两比较，大的值放后面
     */
    public void bubbleSort(int[] numbers, int size) {

        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size; ++i) {
            // 数据交换的标记，表示当前循环是否有数据交换
            boolean swapFlag = false;
            for (int j = 0; j < size - i - 1; ++j) {
                // 相邻位置两两比较
                if (numbers[j] > numbers[j + 1]) {
                    // 前面数字大于后面，则交换位置
                    numbers[j] ^= numbers[j + 1];
                    numbers[j+1] ^= numbers[j];
                    numbers[j] ^= numbers[j + 1];
                    // 本次循环有数据交换，标记设为 true
                    swapFlag = true;
                }
            }

            if (!swapFlag) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }
}
