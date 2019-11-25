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
        int[] nums = new int[]{1, 2, 1};
        L503 l503 = new L503();
        System.out.println("l503.nextGreaterElements(nums) = " + Arrays.toString(l503.nextGreaterElements(nums)));
    }

    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出
     * -1。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];

        Stack<Integer[]> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i++) {

            while (!stack.empty() && nums[i % nums.length] > stack.peek()[1]) {
                result[stack.pop()[0]] = nums[i % nums.length];
            }

            stack.push(new Integer[]{i % nums.length, nums[i % nums.length]});
        }

        return result;
    }

    /**
     * LeetCode 耗时最短解答
     */
    public int[] nextGreaterElements1(int[] nums) {
        int[] nextBiggerPos = new int[nums.length];

        Arrays.fill(nextBiggerPos, -1);

        // 先正向
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                nextBiggerPos[i] = i + 1;
            } else {
                int nextPossiblePos = nextBiggerPos[i + 1];
                while (true) {

                    if (nextPossiblePos == -1 || nums[i] < nums[nextPossiblePos]) {
                        nextBiggerPos[i] = nextPossiblePos;
                        break;
                    }

                    nextPossiblePos = nextBiggerPos[nextPossiblePos];
                }
            }
        }

        // 再循环
        for (int i = 0; i < nums.length; i++) {
            if (nextBiggerPos[i] == -1) {
                int nextPossiblePos = 0;
                while (nextPossiblePos < i) {
                    if (nextPossiblePos == -1 || nums[nextPossiblePos] > nums[i]) {
                        nextBiggerPos[i] = nextPossiblePos;
                        break;
                    } else {
                        nextPossiblePos = nextBiggerPos[nextPossiblePos];
                    }
                }
            }
        }

        int[] output = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            output[i] = nextBiggerPos[i] == -1 ? -1 : nums[nextBiggerPos[i]];
        }
        return output;
    }
}
