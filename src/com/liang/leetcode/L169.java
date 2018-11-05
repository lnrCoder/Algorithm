package com.liang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L169
 * @description majority-element
 * @Author LiaNg
 * @Date 2018/11/5
 */
public class L169 {


    public static void main(String[] args) {

        int[] nums = {3, 2, 1};
        L169 l = new L169();

        l.majorityElement(nums);
    }

    public int majorityElement(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int length = nums.length / 2 -1;

        Map<Integer, Integer> map = new HashMap();

        for (int num : nums) {
            if (map.get(num) != null && map.get(num) >= length) {
                return num;
            } else {
                map.put(num, map.get(num) == null ? 0 : map.get(num) + 1);
            }
        }
        return 0;
    }

}
