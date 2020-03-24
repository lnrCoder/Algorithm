package com.liang.leetcode.binarySearch;

/**
 * @ClassName: L287
 * @Description: 寻找重复数
 * @Author: LiaNg
 * @Date: 2020/3/24 19:11
 */
public class L287 {

    public static void main(String[] args) {
        L287 l287 = new L287();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println("l287.findDuplicate(nums) = " + l287.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
