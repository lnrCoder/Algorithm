package com.liang.algorithm;

/**
 * @ClassName InsertionSort
 * @description 插入排序
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 1, 3, 2};

        InsertionSort is = new InsertionSort();
        is.insertionSort(numbers, numbers.length);
    }

    /**
     * 插入排序
     *
     * @param numbers 数组
     * @param length 数组大小
     */
    public void insertionSort(int[] numbers, int length) {
        if (length <= 1) {
            return;
        }
        for (int i = 1; i < length; ++i) {
            int value = numbers[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (numbers[j] > value) {
                    // 数据移动
                    numbers[j + 1] = numbers[j];
                } else {
                    break;
                }
            }
            // 插入数据
            numbers[j + 1] = value;
        }
    }

}
