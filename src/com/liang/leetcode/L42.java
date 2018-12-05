package com.liang.leetcode;

/**
 * @ClassName L42
 * @description trapping-rain-water
 * @Author LiaNg
 * @Date 2018/12/5
 */
public class L42 {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        L42 l = new L42();
        System.out.println(l.trap(height));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {

        int n = height.length, index = 0, left = 0, right = 0, area = 0;
        for (int i = 0; i < n; i++) {
            index = height[index] <= height[i] ? i : index;
        }
        for (int i = 0; i < index; i++) {
            if (height[i] < left) {
                area += left - height[i];
            } else {
                left = height[i];
            }
        }
        for (int i = n - 1; i > index; i--) {
            if (height[i] < right) {
                area += right - height[i];
            } else {
                right = height[i];
            }
        }
        return area;
    }

}
