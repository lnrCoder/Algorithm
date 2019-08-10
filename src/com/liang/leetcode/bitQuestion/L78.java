package com.liang.leetcode.bitQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L78
 * @description subsets 子集
 * @Author LiaNg
 * @Date 2019-08-10
 */
public class L78 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2, 7,  8};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> subSet = new ArrayList<>();
            for(int j =0;j<n;j++){
                if((i&(1<<j)) != 0){
                    subSet.add(nums[j]);
                }
            }
            resultList.add(subSet);
        }
        return resultList;
    }
}
