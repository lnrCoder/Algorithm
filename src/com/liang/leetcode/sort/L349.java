package com.liang.leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName L349
 * @description intersection-of-two-arrays 两个数组的交集
 * @Author LiaNg
 * @Date 2019-08-26
 */
public class L349 {

    public static void main(String[] args) {

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 5, 6, 7, 8};

        System.out.println("intersection2(num1,num2) = " + Arrays.toString(intersection2(num1, num2)));

    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> resultList = Arrays.stream(nums1).boxed().collect(Collectors.toList());

        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);

        for (int i : nums2) {
            if (resultList.contains(i)) {
                map.put(i, i);
            }
        }

        int[] result = new int[map.size()];

        int i = 0;
        for (Integer integer : map.keySet()) {
            result[i] = integer;
            i++;
        }

        return result;

    }

    private static int[] intersection2(int[] nums1, int[] nums2) {

        boolean[] ans = new boolean[1000];

        for (int x : nums1) {
            ans[x] = true;
        }

        int index = 0;
        for (int x : nums2) {
            if (ans[x]) {
                ans[x] = false;
                nums1[index++] = x;
            }
        }

        int[] res = new int[index];

        System.arraycopy(nums1, 0, res, 0, index);

        return res;
    }

}
