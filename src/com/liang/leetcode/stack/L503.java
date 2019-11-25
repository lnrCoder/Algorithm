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
        System.out.println("l503.nextGreaterElements(nums) = " + l503.nextGreaterElements(nums));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer[]> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

            if (stack.empty() || nums[i] < stack.peek()[1]) {
                stack.push(new Integer[]{i,nums[i]});
            }else {
                Integer[] pop = stack.pop();
                result[pop[0]] = nums[i];
            }
        }

        System.out.println("result = " + Arrays.toString(result));

        for (int i = 0; i < nums.length; i++) {

            if (result[i] == 0) {

            }
            if (stack.empty() || nums[i] < stack.peek()[1]) {
                stack.push(new Integer[]{i,nums[i]});
            }else {
                Integer[] pop = stack.pop();
                result[pop[0]] = nums[i];
            }
        }

        return result;
    }
}
