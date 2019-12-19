package com.liang.leetcode.sort;

import java.util.Arrays;

/**
 * @ClassName: L75
 * @Description: 颜色分类
 * @Author: LiaNg
 * @Date: 2019/12/19 9:04
 */
public class L75 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        L75 l75 = new L75();
        l75.sortColors(nums);
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void sortColors(int[] nums) {

        int zero = 0;
        int i = 0;
        int numsLength = nums.length - 1;

        while (i <= numsLength) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[numsLength];
                nums[numsLength] = 2;
                numsLength--;
            } else {
                i++;
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));
    }
}
