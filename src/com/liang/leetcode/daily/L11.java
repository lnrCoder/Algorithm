package com.liang.leetcode.daily;

/**
 * @ClassName: L11
 * @Description: 盛最多水的容器
 * @Author: LiaNg
 * @Date: 2020/4/19 10:21
 */
public class L11 {

    public static void main(String[] args) {
        L11 l11 = new L11();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("l11.maxArea(height) = " + l11.maxArea(height));
    }

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *  
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *  
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int min;
        int result = 0;
        while (l < r) {
            min = Math.min(height[l], height[r]);

            result = Math.max(result, min * (r - l));

            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
