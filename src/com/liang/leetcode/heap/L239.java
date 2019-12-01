package com.liang.leetcode.heap;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName L239
 * @description 滑动窗口最大值
 * @Author LiaNg
 * @Date 2019-12-01
 */
public class L239 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        L239 l239 = new L239();
        System.out.println("l239.maxSlidingWindow(nums,k) = " + Arrays.toString(l239.maxSlidingWindow(nums, k)));
    }

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
                linkedList.pollLast();
            }
            linkedList.add(i);
            if (linkedList.peek() < i - k) {
                linkedList.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[linkedList.peek()];
            }
        }
        return result;
    }
}
