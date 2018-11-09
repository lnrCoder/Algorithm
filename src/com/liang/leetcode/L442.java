package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L442
 * @description find-all-duplicates-in-an-array
 * @Author LiaNg
 * @Date 2018/11/9
 */
public class L442 {

    public static void main(String[] args) {
        int[] numbers = {4,3,2,7,8,2,3,1};

        L442 l = new L442();
        System.out.println(l.findDuplicates(numbers));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                //nums[index] = -nums[index];
                //参考http://www.mamicode.com/info-detail-2353817.html调整了下运算方法
                nums[index] *= -1;
            }else{
                resultList.add(Math.abs(nums[i]));
            }
        }

        return resultList;

    }
}
