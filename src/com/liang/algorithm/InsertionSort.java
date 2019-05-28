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
        int[] numbers2 = {4, 5, 6, 1, 3, 2};

        InsertionSort is = new InsertionSort();

        is.insertionSort(numbers, numbers.length);
        is.insertSort(numbers2);
    }

    /**
     * 插入排序
     *
     * @param numbers 数组
     * @param length 数组大小
     * @description 与当前值之前的值比较，大值放后面
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

    public void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int len = arr.length;
        // i控制循环次数，因为已经默认第一个数的位置是正确的，所以i的起始值为1，i<len，循环len-1次
        for (int i = 1; i < len; i++) {
            //变量j用来记录即将要排序的数的位置即目标数的原位置
            int j = i;
            //target用来记录即将要排序的那个数的值即目标值
            int target = arr[j];
            // while循环用来为目标值在已经排好序的数中找到合适的位置，
            // 因为是从后向前比较，并且是与j-1位置的数比较，所以j>0
            while (j > 0 && target < arr[j - 1]) {
                // 当目标数的值比它当前位置的前一个数的值小时，将前一个数的位置向后移一位。
                // 并且j--使得目标数继续与下一个元素比较
                arr[j] = arr[j - 1];
                j--;
            }
            // 更目标数的位置。
            arr[j] = target;
        }
    }

}
