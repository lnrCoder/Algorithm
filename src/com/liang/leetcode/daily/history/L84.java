package com.liang.leetcode.daily.history;

/**
 * 柱状图中最大的矩形
 *
 * @author LiaNg
 * @date 2020/5/30 1:12
 */
public class L84 {

    public static void main(String[] args) {
        L84 l84 = new L84();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println("l84.largestRectangleArea(heights) = " + l84.largestRectangleArea(heights));
    }

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *  
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     *  
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     *  
     * 示例:
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int largestRectangleArea(int[] heights) {

        int length = heights.length;

        if (length == 0) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            int min = heights[i];
            for (int j = i; j < length; j++) {
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (j - i + 1));
            }
        }

        return result;
    }
}
