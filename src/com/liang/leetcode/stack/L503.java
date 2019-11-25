package com.liang.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName L503
 * @description 下一个更大元素 II
 * @Author LiaNg
 * @Date 2019-11-25
 */
public class L503 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        L503 l503 = new L503();
        System.out.println("l503.nextGreaterElements(nums) = " + Arrays.toString(l503.nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer[]> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length*2; i++) {

            while (!stack.empty() && nums[i%nums.length] > stack.peek()[1]) {
                result[stack.pop()[0]] = nums[i % nums.length];
            }

            stack.push(new Integer[]{i%nums.length,nums[i%nums.length]});
        }

        return result;
    }
}
