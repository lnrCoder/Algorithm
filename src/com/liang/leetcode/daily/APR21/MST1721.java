package com.liang.leetcode.daily.APR21;

/**
 * 直方图的水量
 * （经典双指针题型）
 *
 * @author LiaNg
 * @date 2021/4/2 14:02
 */
public class MST1721 {

    /**
     * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left <= right) {

            if (height[left] > leftMax) {
                leftMax = height[left];
            }
            if (height[right] > rightMax) {
                rightMax = height[right];
            }

            if (leftMax < rightMax) {
                res += leftMax - height[left++];
            }else{
                res += rightMax - height[right--];
            }

        }

        return res;
    }

    public static void main(String[] args) {
        MST1721 mst1721 = new MST1721();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("mst1721.trap(height) = " + mst1721.trap(height));
    }
}
