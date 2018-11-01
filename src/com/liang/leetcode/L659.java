package com.liang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName L659
 * @description split-array-into-consecutive-subsequences
 * @Author LiaNg
 * @Date 2018/11/1
 */
public class L659 {

    /**
     * 将数组分隔为连续子序列
     */
    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> freq = new HashMap();
        Map<Integer, Integer> sequence = new HashMap();

        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            //若当前元素个数为0， continue
            if (freq.get(i) == 0) {
                continue;
            }
            //大于0，表示当前元素可以插入到已经构建好的序列的末端
            else if (sequence.getOrDefault(i, 0) > 0) {
                sequence.put(i, sequence.get(i) - 1);
                sequence.put(i + 1, sequence.getOrDefault(i + 1, 0) + 1);
            }
            //表示当前元素可以作为新序列的第一个元素
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                //注意这里，构建好一个序列，那么该序列最后一个元素+1一定能插入到序列末端
                sequence.put(i + 3, sequence.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 4, 5};
        L659 l = new L659();
        System.out.println(l.isPossible(numbers));
    }
}
