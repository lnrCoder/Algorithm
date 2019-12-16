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

        L349 l349 = new L349();
        System.out.println("l349.intersection1(num1,num2) = " + Arrays.toString(l349.intersection1(num1, num2)));
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        HashMap<Integer, Integer> map = new HashMap<>(nums2.length);

        for (int i : nums2) {
            if (nums1List.contains(i)) {
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

    /**
     * LeetCode 耗时最短解答
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        boolean[] bool = new boolean[1200];
        for (int value : nums1) {
            bool[value] = true;
        }
        int k = 0;
        for (int value : nums2) {
            if (bool[value]) {
                nums1[k++] = value;
            }
            bool[value] = false;
        }
        int[] res = new int[k];
        System.arraycopy(nums1, 0, res, 0, k);
        return res;
    }
}
