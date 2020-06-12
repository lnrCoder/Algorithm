package com.liang.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 三数之和
 *
 * @author LiaNg
 * @date 2020/6/12 10:33
 */
public class L15 {

    public static void main(String[] args) {
        L15 l15 = new L15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1 ;

            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(i);
                    currentList.add(j);
                    currentList.add(k);
                    j++;
                    k++;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                }else{
                    j++;
                }
                while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (k > j && nums[k] == nums[k - 1]) {
                    k--;
                }
            }
        }

        return res;
    }
}
