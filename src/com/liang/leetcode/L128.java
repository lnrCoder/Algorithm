package com.liang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L128
 * @description longest-consecutive-sequence
 * @Author LiaNg
 * @Date 2018/11/19
 */
public class L128 {

    public static void main(String[] args) {

        int[] numbers = {};

        L128 l = new L128();
        System.out.println(l.longestConsecutive(numbers));
    }

    /**
     * 给定一个未排序的整数数组，找出最长连续序列的长度。
     * 要求算法的时间复杂度为 O(n)。
     */
    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            map.put(num, num);
        }

        int max = 0;
        for (int num : nums) {
            int i = 1;
            while (map.containsKey(num - i)) {
                i++;
            }
            max = max > i ? max : i;
        }

        return max;
    }

}
