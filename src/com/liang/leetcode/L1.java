package com.liang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

/**
 * @ClassName L1
 * @description two-sum
 * @Author LiaNg
 * @Date 2018/12/5
 */
public class L1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        L1 l = new L1();
        l.twoSum(nums, target);
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            map.put(target - nums[i], i);
        }

        return result;
    }

}
