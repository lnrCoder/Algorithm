package com.liang.algorithm;

/**
 * @ClassName BubbleSort
 * @description 冒泡排序
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 4, 1, 2, 6};

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(numbers, numbers.length);
    }

    /**
     * 冒泡排序
     *
     * @description 逐步两两比较，大的值放后面
     * @param numbers 数组
     * @param size 数组大小
     */
    public void bubbleSort(int[] numbers, int size) {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < size - i - 1; ++j) {
                if (numbers[j] > numbers[j + 1]) {
                    // 交换
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }


}
