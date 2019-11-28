package com.liang.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @ClassName L215
 * @description 数组中的第K个最大元素
 * @Author LiaNg
 * @Date 2019-11-28
 */
public class L215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        L215 l215 = new L215();
        System.out.println("l215.findKthLargest(nums,k) = " + l215.findKthLargest(nums, k));
    }

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int findKthLargest1(int[] nums, int k) {
        int[] heap = initHeapArray(nums, k);
        adjustWholeHeap(heap);

        processHeap(heap, nums);
        return heap[0];
    }

    private int[] initHeapArray(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        return heap;
    }

    private void adjustWholeHeap(int[] heap) {
        for (int i = (heap.length - 2) / 2; i >= 0; i--) {
            adjustHeap(heap, i);
        }
    }

    private void processHeap(int[] heap, int[] array) {
        for (int i = heap.length; i < array.length; i++) {
            if (array[i] > heap[0]) {
                heap[0] = array[i];
                adjustHeap(heap, 0);
            }
        }
    }

    private static void adjustHeap(int[] heap, int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int indexOfMin = index;
        if (leftChildIndex < heap.length && heap[index] > heap[leftChildIndex]) {
            indexOfMin = leftChildIndex;
        }
        if (rightChildIndex < heap.length && heap[indexOfMin] > heap[rightChildIndex]) {
            indexOfMin = rightChildIndex;
        }
        if (indexOfMin != index) {
            swap(index, indexOfMin, heap);
            adjustHeap(heap, indexOfMin);
        }
    }

    private static void swap(int item, int anotherItem, int[] array) {
        int tmp = array[item];
        array[item] = array[anotherItem];
        array[anotherItem] = tmp;
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
}
