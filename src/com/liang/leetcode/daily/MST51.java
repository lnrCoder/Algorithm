package com.liang.leetcode.daily;

/**
 * 面试题51. 数组中的逆序对
 *
 * @author LiaNg
 * @date 2020/4/24 21:20
 */
public class MST51 {

    public static void main(String[] args) {
        MST51 mst51 = new MST51();
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println("mst51.reversePairs(nums) = " + mst51.reversePairs(nums));
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *  
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     *  
     * 限制：
     * 0 <= 数组长度 <= 50000
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reversePairs(int[] nums) {

        int length = nums.length;

        if (length < 2) {
            return 0;
        }

        int[] copy = new int[length];

        int index = 0;
        for (int num : nums) {
            copy[index++] = num;
        }

        int[] tmp = new int[length];

        return reverse(copy, 0, length - 1, tmp);
    }

    private int reverse(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftPairs = reverse(nums, left, mid, tmp);
        int rightPairs = reverse(nums, mid + 1, right, tmp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int mergeCount = mergeAndCount(nums, left, mid, right, tmp);

        return leftPairs + rightPairs + mergeCount;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp) {

//        if (right + 1 - left >= 0) {
//            System.arraycopy(nums, left, tmp, left, right + 1 - left);
//        }

        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;

        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == right + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                count += (mid - i + 1);
            }
        }

        return count;
    }
}
