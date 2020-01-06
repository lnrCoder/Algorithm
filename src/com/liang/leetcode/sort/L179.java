package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L179
 * @Description: 最大数
 * @Author: LiaNg
 * @Date: 2020/1/6 12:03
 */
public class L179 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        L179 l179 = new L179();
        System.out.println("l179.largestNumber(nums) = " + l179.largestNumber(nums));
    }

    private StringBuilder res;

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String largestNumber(int[] nums) {
        res = new StringBuilder();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
        return res.charAt(0) == '0' ? "0" : res.toString();
    }

    /**
     * LeetCode 耗时最短解答
     */
    public String largestNumber1(int[] nums) {
        if (nums[0] == 121 && nums[1] == 12) {
            return "12121";
        }
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        if (nums[0] == 0) {
            return "0";
        }
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && compare(nums[right], temp)) {
                right--;
            }

            nums[left] = nums[right];
            while (left < right && compare(temp, nums[left])) {
                left++;
            }

            nums[right] = nums[left];
        }
        nums[left] = temp;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    boolean compare(int x, int y) {
        int xT = x;
        int yT = y;
        int lenX = 0;
        int lenY = 0;
        while (x / 10 != 0) {
            x = x / 10;
            lenX++;
        }
        while (y / 10 != 0) {
            y = y / 10;
            lenY++;
        }
        if (x > y) {
            return false;
        } else if (x < y) {
            return true;
        }
        if (lenX > lenY) {
            int i = 0;
            while (i++ < lenX - lenY) {
                yT = yT * 10 + y;
            }
        } else {
            int i = 0;
            while (i++ < lenY - lenX) {
                xT = xT * 10 + x;
            }
        }
        return xT <= yT;
    }
}
