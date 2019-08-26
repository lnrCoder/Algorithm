package com.liang.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName L350
 * @description intersection-of-two-arrays-ii 两个数组的交集 II
 * @Author LiaNg
 * @Date 2019-08-26
 */
public class L350 {

    public static void main(String[] args) {

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 5, 6, 7, 8};

        System.out.println("intersect2(num1,num2) = " + Arrays.toString(intersect2(num1, num2)));

    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums1.length);

        for (int i : nums1) {
            Integer integer = hashMap.putIfAbsent(i, 1);
            if (integer != null) {
                hashMap.put(i, integer + 1);
            }
        }

        int index = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if (hashMap.get(i) != null && hashMap.get(i) != 0) {
                hashMap.put(i, hashMap.get(i) - 1);
                nums1[index++] = i;
            }
        }

        int[] result = new int[index];
        System.arraycopy(nums1, 0, result, 0, index);

        return result;
    }

    private static int[] intersect2(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;

        int i = 0, j = 0, k = 0;
        while (i < l1 && j < l2) {
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }

        int[] result = new int[k];

        System.arraycopy(nums1, 0, result, 0, k);

        return result;

    }
}
