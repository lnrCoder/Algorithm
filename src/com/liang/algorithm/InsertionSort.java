package com.liang.algorithm;

/**
 * @ClassName InsertionSort
 * @description 插入排序
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {14, 2, 25, 17, 7, 38, 34, 5, 42, 15, 42};
        int[] numbers2 = {14, 2, 25, 17, 7, 38, 34, 5, 42, 15, 42};

        InsertionSort is = new InsertionSort();

        is.insertionSort(numbers);
        is.insertSort(numbers2);
    }

    /**
     * 插入排序
     *
     * @param numbers 数组
     * @description 与当前值之前的值比较，大值放后面
     */
    public void insertionSort(int[] numbers) {
        int length = numbers.length;
        if (length <= 1) {
            return;
        }

        // 循环数组，第一个元素不需要参与排序，所以 i 从 1 开始
        for (int i = 1; i < length; ++i) {
            // 获取当前索引的元素值
            int value = numbers[i];
            // 当前位置向前遍历
            int j = i - 1;
            for (; j >= 0; --j) {
                // 对比交换，找到 value 需要插入的位置
                if (numbers[j] > value) {
                    // 数据移动
                    numbers[j + 1] = numbers[j];
                } else {
                    // j 索引位置的值 <= value 时，跳出本次循环
                    // j+1 即为 value 需要放置的位置
                    break;
                }
            }
            // 将 value 值插入相应位置
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
