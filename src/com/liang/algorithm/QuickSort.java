package com.liang.algorithm;

import com.liang.algorithm4.StopWatch;

import java.util.Random;

/**
 * 快速排序
 *
 * @author LiaNg
 * @date 2020/4/28 14:26
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] arrA = new int[50000];
        int[] arrB = new int[50000];
        Random random = new Random();
        int randomNum;
        for (int i = 0; i < 5000000; i++) {
            randomNum = random.nextInt(500) + 129;
            arrA[i] = randomNum;
            arrB[i] = randomNum;
        }

        System.out.println("randomNum = ");
        StopWatch stopWatch = new StopWatch();
        quickSort.quickSort(arrA);
        System.out.println("处理时间 = " + stopWatch.slapsedTime());

        StopWatch sw = new StopWatch();
        quickSort.quickSortThreeWay(arrB);
        System.out.println("处理时间 = " + sw.slapsedTime());
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

    /**
     * 快速排序三向切分
     *
     * @param nums 待排序数组
     */
    public void quickSortThreeWay(int[] nums) {

        sortThreeWay(nums, 0, nums.length - 1);
    }

    /**
     * 三向切分
     *
     * @param nums 排序数组
     * @param lo 当前排序区间，左节点下标
     * @param hi 当前排序区间，右节点下标
     */
    public void sortThreeWay(int[] nums, int lo, int hi) {

        // 退出条件
        if (lo >= hi) {
            return;
        }

        // nums[left] 作为分区值
        int left = lo;
        int right = hi;
        int mid = left + 1;

        /* 处理结果
         * [lo ~ left-1] 小于分区值
         * [left ~ right] 等于分区值
         * [right+1 ~ hi] 大于分区值
         */
        while (mid <= right) {

            if (nums[mid] > nums[left]) {
                swap(nums, mid, right);
                right--;
            } else if (nums[mid] < nums[left]) {
                swap(nums, mid, left);
                mid++;
                left++;
            } else {
                mid++;
            }
        }

        // 对小于当前分区值的区间排序
        sortThreeWay(nums, lo, left - 1);
        // 对大于当前分区值的区间排序
        sortThreeWay(nums, right + 1, hi);
    }
}
